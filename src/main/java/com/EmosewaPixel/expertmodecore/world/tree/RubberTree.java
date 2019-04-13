package com.EmosewaPixel.expertmodecore.world.tree;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.blocks.trees.BlockRubberLog;
import net.minecraft.block.trees.AbstractTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class RubberTree extends AbstractTree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return random.nextInt(20) == 0 ? new BigRubberTreeFeatures(true) : new TreeFeature(true, 4, BlockRegistry.RUBBER_LOG.getDefaultState().with(BlockRubberLog.HAS_SAP, true), BlockRegistry.RUBBER_LEAVES.getDefaultState(), false);
    }
}
