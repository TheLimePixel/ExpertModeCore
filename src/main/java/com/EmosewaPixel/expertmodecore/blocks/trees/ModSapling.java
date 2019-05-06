package com.EmosewaPixel.expertmodecore.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.AbstractTree;

public class ModSapling extends BlockSapling {
    public ModSapling(AbstractTree tree, String name) {
        super(tree, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0F).sound(SoundType.PLANT));
        setRegistryName("expertmodecore:" + name);
    }
}