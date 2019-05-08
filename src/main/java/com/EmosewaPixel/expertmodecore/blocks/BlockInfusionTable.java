package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityInfusionTable;
import com.EmosewaPixel.pixellib.blocks.BlockMachine;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.ToolType;

public class BlockInfusionTable extends BlockMachine {
    public BlockInfusionTable() {
        super(Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD), "expertmodecore:infusion_table", TileEntityInfusionTable::new);
    }

    public ToolType getHarvestTool(IBlockState state) {
        return ToolType.AXE;
    }
}