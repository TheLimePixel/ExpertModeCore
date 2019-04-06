package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.blocks.BlockFurnaceBase;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import com.EmosewaPixel.expertmodecore.recipes.MachineRecipe;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.expertmodecore.recipes.TagStack;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityCokeOven extends TileEntityFurnaceBase implements ITickable {
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
            return stack.getItem() instanceof ItemBucket;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityCokeOven.this.markDirty();
        }
    };

    private ItemStackHandler bucket_output = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            TileEntityCokeOven.this.markDirty();
        }
    };

    private CombinedInvWrapper outputHandler;

    public TileEntityCokeOven() {
        super(ExpertTypes.COKE_OVEN, 1, 1, RecipeTypes.cokeOvenRecipes);

        combinedHandler = new CombinedInvWrapper(input, fuel_input, bucket_input, bucket_output, output);
        slotCount = 5;
        outputHandler = new CombinedInvWrapper(bucket_output, output);
    }


    @Override
    public void tick() {
        if (!world.isRemote) {
            if (getBurnTime() > 0) {
                setBurnTime(getBurnTime() - 1);
                if (creosoteAmount < 6000) {
                    world.setBlockState(pos, world.getBlockState(pos).with(BlockFurnaceBase.LIT, true));
                    if (getProgress() > 0) {
                        setProgress(getProgress() - 1);
                        if (getProgress() == 0)
                            smelt();
                    } else
                        startSmelting();
                }
            } else {
                if (!fuel_input.getStackInSlot(0).isEmpty() && creosoteAmount < 6000)
                    consumeFuel();
                else
                    world.setBlockState(pos, world.getBlockState(pos).with(BlockFurnaceBase.LIT, false));
            }
            if (creosoteAmount >= 1000)
                consumeBucket();

            markDirty();
        }
    }

    private void consumeBucket() {
        if (bucket_input.getStackInSlot(0).getItem() instanceof ItemBucket)
            if (bucket_output.insertItem(0, new ItemStack(ItemRegistry.CREOSOTE_BUCKET), false).isEmpty()) {
                bucket_input.extractItem(0, 1, false);
                creosoteAmount -= 1000;
            }
    }

    @Override
    protected void smelt() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (canOutput(recipe, false)) {
                for (int i = 0; i < getInputCount(); i++) {
                    if (recipe.getinput(i) instanceof ItemStack)
                        input.extractItem(i, ((ItemStack) recipe.getinput(i)).copy().getCount(), false);
                    else
                        input.extractItem(i, ((TagStack) recipe.getinput(i)).copy().getCount(), false);

                }
                creosoteAmount += 500;
            }
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        creosoteAmount = compound.getInt("CreosoteAmount");
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.setInt("CreosoteAmount", creosoteAmount);
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