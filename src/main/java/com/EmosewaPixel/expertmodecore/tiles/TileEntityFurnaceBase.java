package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.blocks.BlockBlastFurnace;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityFurnaceBase extends TileEntity implements ITickable {
    private ITextComponent furnaceCustomName;
    private int progress = 0;
    private int burnTime = 0;
    private int maxBurnTime = 0;
    private int inputCount;
    public int slotCount = 2 + inputCount;

    public void setProgress(int i) {
        progress = i;
    }

    public int getProgress() {
        return progress;
    }

    public void setBurnTime(int i) {
        burnTime = i;
    }

    public int getBurnTime() {
        return burnTime;
    }

    public void setMaxBurnTime(int i) {
        maxBurnTime = i;
    }

    public int getMaxBurnTime() {
        return maxBurnTime;
    }

    public TileEntityFurnaceBase(TileEntityType type, int inputCount) {
        super(type);
        this.inputCount = inputCount;
    }

    private ItemStackHandler input = new ItemStackHandler(inputCount) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return stack.getItem() == Items.IRON_INGOT;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityFurnaceBase.this.markDirty();
        }
    };

    private ItemStackHandler fuel_input = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return getItemBurnTime(stack) > 0;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityFurnaceBase.this.markDirty();
        }
    };

    private ItemStackHandler output = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityFurnaceBase.this.markDirty();
        }
    };

    private CombinedInvWrapper combinedHandler = new CombinedInvWrapper(input, fuel_input, output);

    @Override
    public void tick() {
        if (!world.isRemote) {
            if (burnTime > 0) {
                burnTime--;
                world.setBlockState(pos, world.getBlockState(pos).with(BlockBlastFurnace.LIT, true));
                if (progress > 0) {
                    progress--;
                    if (progress == 0)
                        smelt();
                } else
                    startSmelting();
            } else {
                world.setBlockState(pos, world.getBlockState(pos).with(BlockBlastFurnace.LIT, false));
                consumeFuel();
            }
            markDirty();
        }
    }

    private int getItemBurnTime(ItemStack stack) {
        if (stack.isEmpty())
            return 0;
        int rec = stack.getBurnTime();
        return ForgeEventFactory.getItemBurnTime(stack, rec == -1 ? TileEntityFurnace.getBurnTimes().getOrDefault(stack.getItem(), 0) : rec);
    }

    private void startSmelting() {
        for (int i = 0; i < inputCount; i++)
            if (input.getStackInSlot(i).getItem() == Items.IRON_INGOT)
                if (output.insertItem(0, new ItemStack(ItemRegistry.STEEL_INGOT), true).isEmpty()) {
                    progress = 200;
                    break;
                }
    }

    private void smelt() {
        for (int i = 0; i < inputCount; i++)
            if (input.getStackInSlot(i).getItem() == Items.IRON_INGOT)
                if (output.insertItem(0, new ItemStack(ItemRegistry.STEEL_INGOT), false).isEmpty()) {
                    input.extractItem(0, 1, false);
                    break;
                }
    }

    private void consumeFuel() {
        burnTime = maxBurnTime = getItemBurnTime(fuel_input.getStackInSlot(0));
        if (burnTime > 0)
            fuel_input.extractItem(0, 1, false);
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        if (compound.hasKey("InputItems")) {
            input.deserializeNBT((NBTTagCompound) compound.getTag("input_items"));
        }
        if (compound.hasKey("FuelItems")) {
            fuel_input.deserializeNBT((NBTTagCompound) compound.getTag("fuel_items"));
        }
        if (compound.hasKey("OutputItems")) {
            output.deserializeNBT((NBTTagCompound) compound.getTag("output_items"));
        }
        compound.getInt("Progress");
        compound.getInt("BurnTime");
        compound.getInt("MaxBurnTime");
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.setTag("InputItems", input.serializeNBT());
        compound.setTag("FuelItems", fuel_input.serializeNBT());
        compound.setTag("OutputItems", output.serializeNBT());
        compound.setInt("Progress", progress);
        compound.setInt("BurnTime", burnTime);
        compound.setInt("MaxBurnTime", maxBurnTime);
        return compound;
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable EnumFacing side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == null)
                return LazyOptional.of(() -> combinedHandler).cast();
            if (side == EnumFacing.UP)
                return LazyOptional.of(() -> this.input).cast();
            if (side == EnumFacing.EAST || side == EnumFacing.WEST || side == EnumFacing.NORTH || side == EnumFacing.SOUTH)
                return LazyOptional.of(() -> this.fuel_input).cast();

            if (side == EnumFacing.DOWN)
                return LazyOptional.of(() -> this.output).cast();
        }
        return LazyOptional.empty();
    }

    public void setCustomName(@Nullable ITextComponent name) {
        this.furnaceCustomName = name;
    }
}
