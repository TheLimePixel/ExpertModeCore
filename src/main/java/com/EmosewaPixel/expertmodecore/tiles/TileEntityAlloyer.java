package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import net.minecraft.util.ITickable;

public class TileEntityAlloyer extends TileEntityFurnaceBase implements ITickable {
    public TileEntityAlloyer() {
        super(ExpertTypes.ALLOYER, 2, 1, RecipeTypes.alloyerRecipes);
    }
}