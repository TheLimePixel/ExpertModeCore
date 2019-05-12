package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.pixellib.recipes.AbstractRecipeList;
import net.minecraft.util.ResourceLocation;

public class RedstoneBasedRecipeList extends AbstractRecipeList<RedstoneBasedRecipe, RedstoneBasedRecipeBuilder> {
    public RedstoneBasedRecipeList(ResourceLocation name, int maxInputs, int maxOutputs) {
        super(name, maxInputs, maxOutputs);
    }

    public RedstoneBasedRecipeBuilder recipeBuilder() {
        return new RedstoneBasedRecipeBuilder(this);
    }
}