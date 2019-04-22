package com.EmosewaPixel.expertmodecore.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.ToolType;

public class ModLog extends BlockLog {
    private int harvestLvl;

    public ModLog(String name, int harvestLvl, float hardness) {
        super(MaterialColor.DIRT, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(hardness).sound(SoundType.WOOD));
        setRegistryName("expertmodecore:" + name);
        this.harvestLvl = harvestLvl;
    }

    @Override
    public ToolType getHarvestTool(IBlockState state) {
        return ToolType.AXE;
    }

    @Override
    public int getHarvestLevel(IBlockState state) {
        return harvestLvl;
    }
}