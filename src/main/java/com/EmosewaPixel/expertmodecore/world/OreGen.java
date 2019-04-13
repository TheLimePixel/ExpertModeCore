package com.EmosewaPixel.expertmodecore.world;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.blocks.trees.BlockRubberLog;
import com.EmosewaPixel.expertmodecore.world.tree.BigRubberTreeFeatures;
import com.EmosewaPixel.expertmodecore.world.tree.GiantTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void addOres() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new DimensionFeature<>(
                    Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockRegistry.COPPER_ORE.getDefaultState(), 9), Biome.COUNT_RANGE,
                    new CountRangeConfig(25, 0, 0, 64), DimensionType.OVERWORLD
            ));


            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new DimensionFeature<>(
                    Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockRegistry.SILVER_ORE.getDefaultState(), 9), Biome.COUNT_RANGE,
                    new CountRangeConfig(10, 0, 0, 64), DimensionType.OVERWORLD
            ));


            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new DimensionFeature<>(
                    Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockRegistry.TIN_ORE.getDefaultState(), 9), Biome.COUNT_RANGE,
                    new CountRangeConfig(16, 0, 0, 64), DimensionType.OVERWORLD
            ));

            if (biome.getCategory() == Biome.Category.FOREST)
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new DimensionFeature<>(
                        Feature.RANDOM_FEATURE_LIST, new RandomDefaultFeatureListConfig(new Feature[]{new BigRubberTreeFeatures(false)}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.05F}, new TreeFeature(true, 4, BlockRegistry.RUBBER_LOG.getDefaultState().with(BlockRubberLog.HAS_SAP, true), BlockRegistry.RUBBER_LEAVES.getDefaultState(), false), IFeatureConfig.NO_FEATURE_CONFIG), biome.AT_SURFACE_WITH_EXTRA, new AtSurfaceWithExtraConfig(0, 0.05F, 5), DimensionType.OVERWORLD));

            if (biome.getTempCategory() == Biome.TempCategory.WARM)
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new DimensionFeature<>(
                        Feature.RANDOM_FEATURE_LIST, new RandomDefaultFeatureListConfig(new Feature[]{}, new IFeatureConfig[]{}, new float[]{}, new TreeFeature(true, 6, BlockRegistry.IRONWOOD_LOG.getDefaultState(), BlockRegistry.IRONWOOD_LEAVES.getDefaultState(), false), IFeatureConfig.NO_FEATURE_CONFIG), biome.AT_SURFACE_WITH_EXTRA, new AtSurfaceWithExtraConfig(0, 0.05F, 5), DimensionType.OVERWORLD));

            if (biome.getCategory() == Biome.Category.TAIGA)
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new DimensionFeature<>(
                        Feature.RANDOM_FEATURE_LIST, new RandomDefaultFeatureListConfig(new Feature[]{}, new IFeatureConfig[]{}, new float[]{}, new GiantTree(true), IFeatureConfig.NO_FEATURE_CONFIG), biome.AT_SURFACE_WITH_EXTRA, new AtSurfaceWithExtraConfig(0, 0.01F, 1), DimensionType.OVERWORLD));
        }
    }
}
