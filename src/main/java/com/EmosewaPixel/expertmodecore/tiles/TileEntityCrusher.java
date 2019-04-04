package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import net.minecraft.util.ITickable;

public class TileEntityCrusher extends TileEntityFurnaceBase implements ITickable {
    public TileEntityCrusher() {
        super(ExpertTypes.CRUSHER, 1, 2, RecipeTypes.crusherRecipes);
    }
}