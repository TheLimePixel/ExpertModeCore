package com.EmosewaPixel.expertmodecore.world.tree;

import net.minecraft.block.trees.AbstractBigTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class RedwoodTree extends AbstractBigTree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return null;
    }

    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
        return new GiantTree(true);
    }
}