package com.EmosewaPixel.expertmodecore.tiles;

import net.minecraft.tileentity.TileEntityType;

public class ExpertTypes {
    public static TileEntityType<TileEntityAlloyer> ALLOYER = TileEntityType.register("alloyer", TileEntityType.Builder.create(TileEntityAlloyer::new));
    public static TileEntityType<TileEntityBlastFurnace> BLAST_FURNACE = TileEntityType.register("blast_furnace", TileEntityType.Builder.create(TileEntityBlastFurnace::new));
    public static TileEntityType<TileEntityCrusher> CRUSHER = TileEntityType.register("crusher", TileEntityType.Builder.create(TileEntityCrusher::new));

}
