package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.pixellib.recipes.AbstractRecipeBuilder;
import com.EmosewaPixel.pixellib.recipes.AbstractRecipeList;

public class RedstoneBasedRecipeBuilder extends AbstractRecipeBuilder<RedstoneBasedRecipe, RedstoneBasedRecipeBuilder> {
    private boolean highSignal = false;

    public RedstoneBasedRecipeBuilder(AbstractRecipeList<RedstoneBasedRecipe, RedstoneBasedRecipeBuilder> list) {
        super(list);
    }

    public RedstoneBasedRecipeBuilder highSignal() {
        highSignal = true;
        return this;
    }

    @Override
    public RedstoneBasedRecipe build() {
        return this.getInputs().size() <= this.getRecipeList().getMaxInputs() && this.getOutputs().size() <= this.getRecipeList().getMaxOutputs() ? new RedstoneBasedRecipe(this.getInputs().toArray(), this.getOutputs().toArray(), this.getTime(), highSignal) : RedstoneBasedRecipe.EMPTY;
    }
}