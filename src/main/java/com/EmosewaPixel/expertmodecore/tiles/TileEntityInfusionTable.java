package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.pixellib.recipes.SimpleMachineRecipe;
import com.EmosewaPixel.pixellib.tiles.TERecipeBased;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.util.math.BlockPos;

public class TileEntityInfusionTable extends TERecipeBased {
    public TileEntityInfusionTable() {
        super(ExpertTypes.INFUSION_TABLE, RecipeTypes.INFUSION_RECIPES);
        setCurrentRecipe(SimpleMachineRecipe.EMPTY);
    }


    @Override
    public void tick() {
        if (!world.isRemote) {
            if (getProgress() > 0) {
                if (!getCurrentRecipe().isEmpty()) {
                    subtractProgress(countShelves());
                    if (getProgress() <= 0)
                        work();
                } else
                    setProgress(0);
            } else
                startWorking();
            markDirty();
        }
    }

    private int countShelves() {
        int shelves = 0;
        for (int i = -2; i < 3; i++)
            for (int j = -2; j < 3; j++)
                for (int h = 0; h < 2; h++) {
                    if (world.getBlockState(new BlockPos(pos.getX() + i, pos.getY() + h, pos.getZ() + j)).getBlock() instanceof BlockBookshelf)
                        shelves++;
                }
        return shelves;
    }
}
