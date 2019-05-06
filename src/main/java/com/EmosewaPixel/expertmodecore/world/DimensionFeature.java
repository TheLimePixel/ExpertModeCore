package com.EmosewaPixel.expertmodecore.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.BasePlacement;
import net.minecraft.world.gen.placement.IPlacementConfig;

import java.util.Random;

public class DimensionFeature<F extends IFeatureConfig, D extends IPlacementConfig> extends CompositeFeature<F, D> {
    private DimensionType dim;

    public DimensionFeature(Feature<F> featureIn, F featureConfigIn, BasePlacement<D> basePlacementIn, D placementConfigIn, DimensionType dim) {
        super(featureIn, featureConfigIn, basePlacementIn, placementConfigIn);
        this.dim = dim;
    }

    @Override
    public boolean place(IWorld world, IChunkGenerator<? extends IChunkGenSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (world.getDimension().getType() == dim)
            return super.place(world, generator, rand, pos, config);
        return false;
    }
}