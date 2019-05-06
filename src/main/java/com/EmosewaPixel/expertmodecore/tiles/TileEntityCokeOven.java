package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.pixellib.blocks.BlockMachineFuelBased;
import com.EmosewaPixel.pixellib.tiles.TEFuelBased;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityCokeOven extends TEFuelBased {
    private int creosoteAmount;

    public void setCreosoteAmount(int amount) {
        creosoteAmount = amount;
    }

    public int getCreosoteAmount() {
        return creosoteAmount;
    }

    private ItemStackHandler bucket_input = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return stack.getItem() == Items.BUCKET || stack.getItem() == Items.GLASS_BOTTLE;
        }

        @Override
        protected void onContentsChanged(int slot) {
            markDirty();
        }
    };

    private ItemStackHandler bucket_output = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            markDirty();
        }
    };

    private CombinedInvWrapper outputHandler;

    public TileEntityCokeOven() {
        super(ExpertTypes.COKE_OVEN, RecipeTypes.COKE_OVEN_RECIPES);

        combinedHandler = new CombinedInvWrapper(input, fuel_input, bucket_input, bucket_output, output);
        setSlotCount(5);
        outputHandler = new CombinedInvWrapper(bucket_output, output);
    }


    @Override
    public void tick() {
        if (!world.isRemote) {
            if (getBurnTime() > 0) {
                setBurnTime(getBurnTime() - 1);
                if (creosoteAmount < 6000) {
                    world.setBlockState(pos, world.getBlockState(pos).with(BlockMachineFuelBased.LIT, true));
                    if (getProgress() > 0) {
                        if (!getCurrentRecipe().isEmpty()) {
                            setProgress(getProgress() - 1);
                            if (getProgress() == 0)
                                work();
                        } else
                            setProgress(0);
                    } else
                        startWorking();
                }
            } else {
                if (!fuel_input.getStackInSlot(0).isEmpty() && creosoteAmount < 6000)
                    consumeFuel();
                else
                    world.setBlockState(pos, world.getBlockState(pos).with(BlockMachineFuelBased.LIT, false));
            }
            if (creosoteAmount >= 500)
                consumeBucket();

            markDirty();
        }
    }

    private void consumeBucket() {
        if (bucket_input.getStackInSlot(0).getItem() == Items.BUCKET && creosoteAmount > 1000)
            if (bucket_output.insertItem(0, new ItemStack(ItemRegistry.CREOSOTE_BUCKET), false).isEmpty()) {
                bucket_input.extractItem(0, 1, false);
                creosoteAmount -= 1000;
            }
        if (bucket_input.getStackInSlot(0).getItem() == Items.GLASS_BOTTLE)
            if (bucket_output.insertItem(0, new ItemStack(ItemRegistry.CREOSOTE_BOTTLE), false).isEmpty()) {
                bucket_input.extractItem(0, 1, false);
                creosoteAmount -= 500;
            }
    }

    @Override
    protected void work() {
        super.work();
        creosoteAmount += 500;
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        creosoteAmount = compound.getInt("CreosoteAmount");
        if (compound.contains("BucketInput"))
            bucket_input.deserializeNBT((NBTTagCompound) compound.get("BucketInput"));
        if (compound.contains("BucketOutput"))
            bucket_output.deserializeNBT((NBTTagCompound) compound.get("BucketOutput"));
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.putInt("CreosoteAmount", creosoteAmount);
        compound.put("BucketInput", bucket_input.serializeNBT());
        compound.put("BucketOutput", bucket_output.serializeNBT());
        return compound;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable EnumFacing side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == null)
                return LazyOptional.of(() -> combinedHandler).cast();
            if (side == EnumFacing.UP)
                return LazyOptional.of(() -> input).cast();
            if (side == EnumFacing.NORTH || side == EnumFacing.SOUTH)
                return LazyOptional.of(() -> fuel_input).cast();
            if (side == EnumFacing.EAST || side == EnumFacing.WEST)
                return LazyOptional.of(() -> bucket_input).cast();
            if (side == EnumFacing.DOWN)
                return LazyOptional.of(() -> outputHandler).cast();
        }
        return LazyOptional.empty();
    }
}