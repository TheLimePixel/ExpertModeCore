package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.MachineRecipe;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.expertmodecore.recipes.TagStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;

public class TileEntityAlloyer extends TileEntityFurnaceBase implements ITickable {
    public TileEntityAlloyer() {
        super(ExpertTypes.ALLOYER, 2, RecipeTypes.alloyerRecipes);

        input = new ItemStackHandler(2) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                for (MachineRecipe recipe : recipes)
                    if (recipe.itemBelongsInRecipe(stack))
                        return true;

                return false;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityAlloyer.this.markDirty();
            }
        };

        fuel_input = new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return getItemBurnTime(stack) > 0;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityAlloyer.this.markDirty();
            }
        };

        output = new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return false;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityAlloyer.this.markDirty();
            }
        };

        combinedHandler = new CombinedInvWrapper(input, fuel_input, output);
    }

    @Override
    protected void smelt() {
        MachineRecipe recipe = getRecipeByInput();
        if (recipe != null)
            if (output.insertItem(0, recipe.getOutput().copy(), false).isEmpty()) {
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++) {
                        if (recipe.getinput(j) instanceof ItemStack) {
                            if (input.getStackInSlot(i).getItem() == ((ItemStack) recipe.getinput(j)).getItem()) {
                                input.extractItem(i, ((ItemStack) recipe.getinput(j)).copy().getCount(), false);
                            }
                        } else if (((TagStack) recipe.getinput(j)).geTag().contains(input.getStackInSlot(i).getItem()))
                            input.extractItem(i, ((TagStack) recipe.getinput(j)).copy().getCount(), false);
                    }
            }
    }
}