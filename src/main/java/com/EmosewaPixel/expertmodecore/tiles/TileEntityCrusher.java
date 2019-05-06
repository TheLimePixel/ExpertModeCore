package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.pixellib.tiles.TEFuelBased;

public class TileEntityCrusher extends TEFuelBased {
    public TileEntityCrusher() {
        super(ExpertTypes.CRUSHER, RecipeTypes.CRUSHER_RECIPES);
    }
}