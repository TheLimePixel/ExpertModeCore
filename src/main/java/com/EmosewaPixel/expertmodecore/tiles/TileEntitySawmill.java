package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.blocks.trees.BlockSawmill;
import com.EmosewaPixel.expertmodecore.recipes.MachineRecipe;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.expertmodecore.recipes.TagStack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class TileEntitySawmill extends TileEntity implements ITickable {
    private int progress = 0;
    private int maxProgress = 0;
    public int slotCount = 2;
    private int curSignal;
    private static int prevSignals[] = new int[8];
    private boolean highForCurrent;

    private ArrayList<MachineRecipe> recipes = RecipeTypes.sawmillRecipes;

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

    public TileEntitySawmill() {
        super(ExpertTypes.SAWMILL);
    }

    protected ItemStackHandler input = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            for (MachineRecipe recipe : TileEntitySawmill.this.recipes)
                if (recipe.itemBelongsInRecipe(stack))
                    return true;

            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntitySawmill.this.markDirty();
        }
    };

    protected ItemStackHandler output = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntitySawmill.this.markDirty();
        }
    };

    protected CombinedInvWrapper combinedHandler = new CombinedInvWrapper(input, output);
    ;

    @Override
    public void tick() {
        if (!world.isRemote) {
            curSignal = world.getRedstonePowerFromNeighbors(pos);
            if (progress > 0) {
                int highestPrev = getHighestPrev();
                if (highForCurrent == (highestPrev > 8) && highestPrev != 0) {
                    for (int prevSignal : prevSignals)
                        if ((prevSignal == 0) != (curSignal == 0)) {
                            world.setBlockState(pos, world.getBlockState(pos).with(BlockSawmill.ON, true));
                            progress--;
                            break;
                        } else
                            world.setBlockState(pos, world.getBlockState(pos).with(BlockSawmill.ON, false));
                    if (progress == 0)
                        smelt();
                } else progress = 0;
            } else
                startSmelting();
            pushPrevs();
            markDirty();
        }
    }


    protected void startSmelting() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (canOutput(recipe, true)) {
                maxProgress = progress = recipe.getTime() - 1;
            } else
                world.setBlockState(pos, world.getBlockState(pos).with(BlockSawmill.ON, false));
    }

    protected void smelt() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (canOutput(recipe, false)) {
                if (recipe.getinput(0) instanceof ItemStack)
                    input.extractItem(0, ((ItemStack) recipe.getinput(0)).copy().getCount(), false);
                else
                    input.extractItem(0, ((TagStack) recipe.getinput(0)).copy().getCount(), false);
            }
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        if (compound.hasKey("InputItems"))
            input.deserializeNBT((NBTTagCompound) compound.getTag("InputItems"));
        if (compound.hasKey("OutputItems"))
            output.deserializeNBT((NBTTagCompound) compound.getTag("OutputItems"));
        progress = compound.getInt("Progress");
        maxProgress = compound.getInt("MaxProgress");
        highForCurrent = compound.getBoolean("HighForCurrent");
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.setTag("InputItems", input.serializeNBT());
        compound.setTag("OutputItems", output.serializeNBT());
        compound.setInt("Progress", progress);
        compound.setInt("MaxProgress", maxProgress);
        compound.setBoolean("HighForCurrent", highForCurrent);
        return compound;
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    private void pushPrevs() {
        for (int i = prevSignals.length - 1; i > 0; i--)
            prevSignals[i] = prevSignals[i - 1];

        prevSignals[0] = curSignal;
    }

    private int getHighestPrev() {
        int highestSignal = curSignal;
        for (int prevSignal : prevSignals)
            if (prevSignal > highestSignal)
                highestSignal = prevSignal;

        return highestSignal;
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable EnumFacing side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == null)
                return LazyOptional.of(() -> combinedHandler).cast();
            if (side == EnumFacing.UP)
                return LazyOptional.of(() -> this.input).cast();
            if (side == EnumFacing.DOWN)
                return LazyOptional.of(() -> this.output).cast();
        }
        return LazyOptional.empty();
    }

    protected MachineRecipe getRecipeByInput() {
        if (input.getStackInSlot(0).isEmpty())
            return null;

        for (MachineRecipe recipe : recipes)
            if (recipe.isInputValid(new ItemStack[]{input.getStackInSlot(0)}) && ((RecipeTypes.SawmillRecipe) recipe).inHighSignal() == (getHighestPrev() > 8)) {
                highForCurrent = ((RecipeTypes.SawmillRecipe) recipe).inHighSignal();
                return recipe;
            }
        return null;
    }

    protected boolean canOutput(MachineRecipe recipe, boolean simulate) {
        return output.insertItem(0, recipe.getOutput(0).copy(), simulate).isEmpty();
    }

    public void dropInventory() {
        for (int i = 0; i < slotCount; i++) {
            ItemStack stack = combinedHandler.getStackInSlot(i);

            world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack));
        }
    }
}
