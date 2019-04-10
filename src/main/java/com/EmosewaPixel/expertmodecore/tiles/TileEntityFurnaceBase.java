package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.blocks.BlockFurnaceBase;
import com.EmosewaPixel.expertmodecore.recipes.MachineRecipe;
import com.EmosewaPixel.expertmodecore.recipes.TagStack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class TileEntityFurnaceBase extends TileEntity implements ITickable {
    private int progress = 0;
    private int maxProgress = 0;
    private int burnTime = 0;
    private int maxBurnTime = 0;
    private int inputCount;
    private int outputCount;
    public int slotCount;

    private ArrayList<MachineRecipe> recipes;

    public void setProgress(int i) {
        progress = i;
    }

    public int getProgress() {
        return progress;
    }

    public void setMaxProgress(int i) {
        maxProgress = i;
    }

    public int getMaxProgress() {
        return maxProgress;
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

    public int getInputCount() {
        return inputCount;
    }

    public int getOutputCount() {
        return outputCount;
    }

    public TileEntityFurnaceBase(TileEntityType type, int inputCount, int outputCount, ArrayList<MachineRecipe> recipes) {
        super(type);
        this.inputCount = inputCount;
        this.outputCount = outputCount;
        slotCount = inputCount + 1 + outputCount;
        this.recipes = recipes;

        input = new ItemStackHandler(inputCount) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                for (MachineRecipe recipe : TileEntityFurnaceBase.this.recipes)
                    if (recipe.itemBelongsInRecipe(stack))
                        return true;

                return false;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityFurnaceBase.this.markDirty();
            }
        };

        fuel_input = new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return getItemBurnTime(stack) > 0;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityFurnaceBase.this.markDirty();
            }
        };

        output = new ItemStackHandler(outputCount) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return false;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityFurnaceBase.this.markDirty();
            }
        };

        combinedHandler = new CombinedInvWrapper(input, fuel_input, output);
    }

    protected ItemStackHandler input;

    protected ItemStackHandler fuel_input;

    protected ItemStackHandler output;

    protected CombinedInvWrapper combinedHandler;

    @Override
    public void tick() {
        if (!world.isRemote) {
            if (burnTime > 0) {
                burnTime--;
                world.setBlockState(pos, world.getBlockState(pos).with(BlockFurnaceBase.LIT, true));
                if (progress > 0) {
                    progress--;
                    if (progress == 0)
                        smelt();
                } else
                    startSmelting();
            } else {
                if (!fuel_input.getStackInSlot(0).isEmpty())
                    consumeFuel();
                else
                    world.setBlockState(pos, world.getBlockState(pos).with(BlockFurnaceBase.LIT, false));
            }
            markDirty();
        }
    }

    protected int getItemBurnTime(ItemStack stack) {
        if (stack.isEmpty())
            return 0;
        int rec = stack.getBurnTime();
        return ForgeEventFactory.getItemBurnTime(stack, rec == -1 ? TileEntityFurnace.getBurnTimes().getOrDefault(stack.getItem(), 0) : rec);
    }

    protected void startSmelting() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (canOutput(recipe, true)) {
                maxProgress = progress = recipe.getTime() - 1;
            }
    }

    protected void smelt() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (canOutput(recipe, false)) {
                for (int i = 0; i < inputCount; i++) {
                    if (recipe.getinput(i) instanceof ItemStack)
                        input.extractItem(i, ((ItemStack) recipe.getinput(i)).copy().getCount(), false);
                    else
                        input.extractItem(i, ((TagStack) recipe.getinput(i)).copy().getCount(), false);

                }
            }
    }

    protected void consumeFuel() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null && canOutput(recipe, true)) {
            burnTime = maxBurnTime = getItemBurnTime(fuel_input.getStackInSlot(0));
            if (burnTime > 0) {
                if (fuel_input.getStackInSlot(0).getItem().hasContainerItem())
                    fuel_input.setStackInSlot(0, new ItemStack(fuel_input.getStackInSlot(0).getItem().getContainerItem()));
                else
                    fuel_input.extractItem(0, 1, false);
            }
        } else
            world.setBlockState(pos, world.getBlockState(pos).with(BlockFurnaceBase.LIT, false));
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        if (compound.hasKey("InputItems"))
            input.deserializeNBT((NBTTagCompound) compound.getTag("InputItems"));
        if (compound.hasKey("FuelItems"))
            fuel_input.deserializeNBT((NBTTagCompound) compound.getTag("FuelItems"));
        if (compound.hasKey("OutputItems"))
            output.deserializeNBT((NBTTagCompound) compound.getTag("OutputItems"));
        progress = compound.getInt("Progress");
        maxProgress = compound.getInt("MaxProgress");
        burnTime = compound.getInt("BurnTime");
        maxBurnTime = compound.getInt("MaxBurnTime");
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.setTag("InputItems", input.serializeNBT());
        compound.setTag("FuelItems", fuel_input.serializeNBT());
        compound.setTag("OutputItems", output.serializeNBT());
        compound.setInt("Progress", progress);
        compound.setInt("MaxProgress", maxProgress);
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

    protected MachineRecipe getRecipeByInput() {
        ItemStack[] stacks = new ItemStack[inputCount];
        for (int i = 0; i < inputCount; i++) {
            if (input.getStackInSlot(i).isEmpty())
                return null;
            stacks[i] = input.getStackInSlot(i);
        }

        for (MachineRecipe recipe : recipes) {
            if (recipe.isInputValid(stacks))
                return recipe;
        }
        return null;
    }

    protected boolean canOutput(MachineRecipe recipe, boolean simulate) {
        boolean can = true;

        for (int i = 0; i < recipe.getAllOutputs().length; i++)
            if (!output.insertItem(i, recipe.getOutput(i).copy(), simulate).isEmpty())
                can = false;

        return can;
    }

    public void dropInventory() {
        for (int i = 0; i < slotCount; i++) {
            ItemStack stack = combinedHandler.getStackInSlot(i);

            world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack));
        }
    }
}
