package com.EmosewaPixel.expertmodecore.blocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void addOres() {
        for (Biome biome : ForgeRegistries.BIOMES) {

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(
                    Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockRegistry.COPPER_ORE.getDefaultState(), 9), Biome.COUNT_RANGE,
                    new CountRangeConfig(25, 0, 0, 64)
            ));


            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(
                    Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockRegistry.SILVER_ORE.getDefaultState(), 9), Biome.COUNT_RANGE,
                    new CountRangeConfig(10, 0, 0, 64)
            ));


            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, biome.createCompositeFeature(
                    Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockRegistry.TIN_ORE.getDefaultState(), 9), Biome.COUNT_RANGE,
                    new CountRangeConfig(16, 0, 0, 64)
            ));
        }
    }
}
