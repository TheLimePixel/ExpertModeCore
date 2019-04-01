package com.EmosewaPixel.expertmodecore.tiles;

import net.minecraft.tileentity.TileEntityType;

public class ExpertTypes {
    public static TileEntityType<TileEntityBlastFurnace> BLAST_FURNACE = TileEntityType.register("blast_furnace", TileEntityType.Builder.create(TileEntityBlastFurnace::new));
}
