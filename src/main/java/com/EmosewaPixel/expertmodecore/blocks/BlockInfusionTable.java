package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityInfusionTable;
import com.EmosewaPixel.pixellib.blocks.BlockMachine;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BlockInfusionTable extends BlockMachine {
    public BlockInfusionTable() {
        super(Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD), new ResourceLocation("expertmodecore:infusion_table"));
    }

    public ToolType getHarvestTool(IBlockState state) {
        return ToolType.AXE;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityInfusionTable();
    }
}