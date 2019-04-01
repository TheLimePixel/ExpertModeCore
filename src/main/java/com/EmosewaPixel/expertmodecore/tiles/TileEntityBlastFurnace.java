package com.EmosewaPixel.expertmodecore.tiles;

import net.minecraft.util.ITickable;

public class TileEntityBlastFurnace extends TileEntityFurnaceBase implements ITickable {
    public TileEntityBlastFurnace() {
        super(ExpertTypes.BLAST_FURNACE, 1);
    }
}