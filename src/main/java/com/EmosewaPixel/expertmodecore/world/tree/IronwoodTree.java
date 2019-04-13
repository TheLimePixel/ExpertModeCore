package com.EmosewaPixel.expertmodecore.world.tree;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import net.minecraft.block.trees.AbstractTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class IronwoodTree extends AbstractTree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new TreeFeature(true, 6, BlockRegistry.IRONWOOD_LOG.getDefaultState(), BlockRegistry.IRONWOOD_LEAVES.getDefaultState(), false);
    }
}
