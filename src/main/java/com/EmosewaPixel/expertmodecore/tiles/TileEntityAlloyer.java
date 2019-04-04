package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.MachineRecipe;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.expertmodecore.recipes.TagStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;

public class TileEntityAlloyer extends TileEntityFurnaceBase implements ITickable {
    public TileEntityAlloyer() {
        super(ExpertTypes.ALLOYER, 2, 1, RecipeTypes.alloyerRecipes);
    }

    @Override
    protected void smelt() {
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
            }
    }
}