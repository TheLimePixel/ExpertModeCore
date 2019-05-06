package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityAlloyer;
import com.EmosewaPixel.pixellib.blocks.BlockMachineFuelBased;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

public class BlockCrusher extends BlockMachineFuelBased {
    public BlockCrusher() {
        super(new ResourceLocation("expertmodecore:crusher"));
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityAlloyer();
    }
}
