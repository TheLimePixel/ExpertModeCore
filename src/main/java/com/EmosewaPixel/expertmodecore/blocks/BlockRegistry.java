package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class BlockRegistry {
    public static Block BRONZER_BLOCK;
    public static Block COPPER_BLOCK;
    public static Block COPPER_ORE;
    public static Block ELECTRUM_BLOCK;
    public static Block SILVER_BLOCK;
    public static Block SILVER_ORE;
    public static Block STEEL_BLOCK;
    public static Block TIN_BLOCK;
    public static Block TIN_ORE;

    public static Block BLAST_FURNACE;

    public static void registry(RegistryEvent.Register<Block> e) {
        BRONZER_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.METAL), "bronze_block", 0), e);
        COPPER_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.METAL), "copper_block", 0), e);
        COPPER_ORE = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE), "copper_ore", 0), e);
        ELECTRUM_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.METAL), "electrum_block", 2), e);
        SILVER_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL), "silver_block", 1), e);
        SILVER_ORE = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE), "silver_ore", 1), e);
        STEEL_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL), "steel_block", 1), e);
        TIN_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.METAL), "tin_block", 0), e);
        TIN_ORE = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE), "tin_ore", 0), e);

        BLAST_FURNACE = register(new BlockBlastFurnace(), e);
    }

    public static void itemRegistry(RegistryEvent.Register<Item> e) {
        registerItemBlock(BRONZER_BLOCK, e);
        registerItemBlock(COPPER_BLOCK, e);
        registerItemBlock(COPPER_ORE, e);
        registerItemBlock(ELECTRUM_BLOCK, e);
        registerItemBlock(SILVER_BLOCK, e);
        registerItemBlock(SILVER_ORE, e);
        registerItemBlock(STEEL_BLOCK, e);
        registerItemBlock(TIN_BLOCK, e);
        registerItemBlock(TIN_ORE, e);

        registerItemBlock(BLAST_FURNACE, e);
    }

    private static Block register(Block block, RegistryEvent.Register<Block> e) {
        e.getRegistry().register(block);
        return block;
    }

    private static void registerItemBlock(Block block, RegistryEvent.Register<Item> e) {
        e.getRegistry().register(new ItemBlock(block, new Item.Properties().group(ExpertModeCore.main)).setRegistryName(block.getRegistryName()));
    }
}
