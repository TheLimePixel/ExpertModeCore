package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityAlloyer;
import com.EmosewaPixel.pixellib.blocks.BlockMachineFuelBased;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

public class BlockAlloyer extends BlockMachineFuelBased {
    public BlockAlloyer() {
        super(new ResourceLocation("expertmodecore:alloyer"));
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityAlloyer();
    }
}
