package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.pixellib.recipes.AbstractRecipeList;

public class RedstoneBasedRecipeList extends AbstractRecipeList<RedstoneBasedRecipe, RedstoneBasedRecipeBuilder> {
    public RedstoneBasedRecipeList(int maxInputs, int maxOutputs) {
        super(maxInputs, maxOutputs);
    }

    public RedstoneBasedRecipeBuilder recipeBuilder() {
        return new RedstoneBasedRecipeBuilder(this);
    }
}