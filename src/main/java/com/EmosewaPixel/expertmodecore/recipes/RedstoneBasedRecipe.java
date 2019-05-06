package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.pixellib.recipes.SimpleMachineRecipe;

public class RedstoneBasedRecipe extends SimpleMachineRecipe {
    private boolean highSignal;
    public static RedstoneBasedRecipe EMPTY = new RedstoneBasedRecipe(null, null, 0, false);

    public RedstoneBasedRecipe(Object[] input, Object[] output, int time, boolean highSignal) {
        super(input, output, time);
        this.highSignal = highSignal;
    }

    public boolean needsHighSignal() {
        return highSignal;
    }

    @Override
    public boolean isEmpty() {
        return this == EMPTY;
    }
}