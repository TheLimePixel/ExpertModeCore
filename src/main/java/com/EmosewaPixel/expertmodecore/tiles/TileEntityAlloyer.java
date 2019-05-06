package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.pixellib.tiles.TEFuelBased;

public class TileEntityAlloyer extends TEFuelBased {
    public TileEntityAlloyer() {
        super(ExpertTypes.ALLOYER, RecipeTypes.ALLOYER_RECIPES);
    }
}