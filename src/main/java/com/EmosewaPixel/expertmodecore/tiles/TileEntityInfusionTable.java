package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.MachineRecipe;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.expertmodecore.recipes.TagStack;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class TileEntityInfusionTable extends TileEntity implements ITickable {
    private int progress = 0;
    private int maxProgress = 0;
    private int inputCount = 2;
    private int outputCount = 1;
    public int slotCount = inputCount + outputCount;

    private ArrayList<MachineRecipe> recipes = RecipeTypes.infusionRecipes;

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

    public TileEntityInfusionTable() {
        super(ExpertTypes.INFUSION_TABLE);
    }

    private ItemStackHandler input = new ItemStackHandler(2) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            for (MachineRecipe recipe : TileEntityInfusionTable.this.recipes)
                if (recipe.itemBelongsInRecipe(stack))
                    return true;

            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityInfusionTable.this.markDirty();
        }
    };

    private ItemStackHandler output = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityInfusionTable.this.markDirty();
        }
    };

    private CombinedInvWrapper combinedHandler = new CombinedInvWrapper(input, output);

    @Override
    public void tick() {
        if (!world.isRemote) {
            if (progress > 0) {
                progress -= countShelves();
                if (progress <= 0)
                    infuse();
            } else
                startInfusing();
            markDirty();
        }
    }

    private void startInfusing() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (canOutput(recipe, true)) {
                maxProgress = progress = recipe.getTime();
            }
    }

    private void infuse() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (canOutput(recipe, false)) {
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++) {
                        if (recipe.getinput(j) instanceof ItemStack) {
                            if (input.getStackInSlot(i).getItem() == ((ItemStack) recipe.getinput(j)).getItem()) {
                                input.extractItem(i, ((ItemStack) recipe.getinput(j)).copy().getCount(), false);
                            }
                        } else if (((TagStack) recipe.getinput(j)).geTag().contains(input.getStackInSlot(i).getItem()))
                            input.extractItem(i, ((TagStack) recipe.getinput(j)).copy().getCount(), false);
                    }
                progress = 0;
            }
    }

    private int countShelves() {
        int shelves = 0;
        for (int i = -2; i < 3; i++)
            for (int j = -2; j < 3; j++)
                for (int h = 0; h < 2; h++) {
                    if (world.getBlockState(new BlockPos(pos.getX() + i, pos.getY() + h, pos.getZ() + j)).getBlock() instanceof BlockBookshelf)
                        shelves++;
                }
        return shelves;
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
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.setTag("InputItems", input.serializeNBT());
        compound.setTag("OutputItems", output.serializeNBT());
        compound.setInt("Progress", progress);
        compound.setInt("MaxProgress", maxProgress);
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
            if (side == EnumFacing.DOWN)
                return LazyOptional.of(() -> this.output).cast();
        }
        return LazyOptional.empty();
    }

    private MachineRecipe getRecipeByInput() {
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

    private boolean canOutput(MachineRecipe recipe, boolean simulate) {
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
