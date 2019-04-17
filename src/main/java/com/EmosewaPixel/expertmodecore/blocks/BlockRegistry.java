package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.blocks.trees.*;
import com.EmosewaPixel.expertmodecore.world.tree.IronwoodTree;
import com.EmosewaPixel.expertmodecore.world.tree.RedwoodTree;
import com.EmosewaPixel.expertmodecore.world.tree.RubberTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class BlockRegistry {
    public static Block BRONZER_BLOCK;
    public static Block CHARRED_IRON_BLOCK;
    public static Block COKE_BRICKS;
    public static Block COPPER_BLOCK;
    public static Block COPPER_ORE;
    public static Block CRYSTALLINE_BLOCK;
    public static Block ELECTRUM_BLOCK;
    public static Block SILVER_BLOCK;
    public static Block SILVER_ORE;
    public static Block STEEL_BLOCK;
    public static Block TIN_BLOCK;
    public static Block TIN_ORE;

    public static Block IRONWOOD_LEAVES;
    public static Block IRONWOOD_LOG;
    public static Block IRONWOOD_PLANKS;
    public static Block IRONWOOD_SAPLING;
    public static Block IRONWOOD_WOOD;
    public static Block REDWOOD_LEAVES;
    public static Block REDWOOD_LOG;
    public static Block REDWOOD_PLANKS;
    public static Block REDWOOD_SAPLING;
    public static Block REDWOOD_WOOD;
    public static Block RUBBER_LEAVES;
    public static Block RUBBER_LOG;
    public static Block RUBBER_PLANKS;
    public static Block RUBBER_SAPLING;
    public static Block RUBBER_WOOD;
    public static Block STRIPPED_IRONWOOD_LOG;
    public static Block STRIPPED_IRONWOOD_WOOD;
    public static Block STRIPPED_REDWOOD_LOG;
    public static Block STRIPPED_REDWOOD_WOOD;
    public static Block STRIPPED_RUBBER_LOG;
    public static Block STRIPPED_RUBBER_WOOD;

    public static Block ALLOYER;
    public static Block COKE_OVEN;
    public static Block BLAST_FURNACE;
    public static Block CRUSHER;
    public static Block INFUSION_TABLE;
    public static Block SAWMILL;

    public static void registry(RegistryEvent.Register<Block> e) {
        BRONZER_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6).sound(SoundType.METAL), "bronze_block", 0), e);
        CHARRED_IRON_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL), "charred_iron_block", 1), e);
        COKE_BRICKS = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2, 6).sound(SoundType.STONE), "coke_bricks", 0), e);
        COPPER_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6).sound(SoundType.METAL), "copper_block", 0), e);
        COPPER_ORE = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6).sound(SoundType.STONE), "copper_ore", 0), e);
        CRYSTALLINE_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6).sound(SoundType.METAL), "crystalline_block", 2), e);
        ELECTRUM_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6).sound(SoundType.METAL), "electrum_block", 2), e);
        SILVER_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL), "silver_block", 1), e);
        SILVER_ORE = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5, 6).sound(SoundType.STONE), "silver_ore", 1), e);
        STEEL_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL), "steel_block", 1), e);
        TIN_BLOCK = register(new ModBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6).sound(SoundType.METAL), "tin_block", 0), e);
        TIN_ORE = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6).sound(SoundType.STONE), "tin_ore", 0), e);

        IRONWOOD_LEAVES = register(new BlockIronwoodLeaves(), e);
        IRONWOOD_LOG = register(new ModLog("ironwood_log", 1, 7), e);
        IRONWOOD_PLANKS = register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ironwood_planks"), e);
        IRONWOOD_SAPLING = register(new ModSapling(new IronwoodTree(), "ironwood_sapling"), e);
        IRONWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("ironwood_wood"), e);
        REDWOOD_LEAVES = register(new BlockRedwoodLeaves(), e);
        REDWOOD_LOG = register(new ModLog("redwood_log", 2, 4), e);
        REDWOOD_PLANKS = register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("redwood_planks"), e);
        REDWOOD_SAPLING = register(new ModSapling(new RedwoodTree(), "redwood_sapling"), e);
        REDWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("redwood_wood"), e);
        RUBBER_LEAVES = register(new BlockRubberLeaves(), e);
        RUBBER_LOG = register(new BlockRubberLog(), e);
        RUBBER_PLANKS = register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("rubber_planks"), e);
        RUBBER_SAPLING = register(new ModSapling(new RubberTree(), "rubber_sapling"), e);
        RUBBER_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("rubber_wood"), e);
        STRIPPED_IRONWOOD_LOG = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_ironwood_log"), e);
        STRIPPED_IRONWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_ironwood_wood"), e);
        STRIPPED_REDWOOD_LOG = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_redwood_log"), e);
        STRIPPED_REDWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_redwood_wood"), e);
        STRIPPED_RUBBER_LOG = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_rubber_log"), e);
        STRIPPED_RUBBER_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_rubber_wood"), e);

        ALLOYER = register(new BlockAlloyer(), e);
        BLAST_FURNACE = register(new BlockBlastFurnace(), e);
        COKE_OVEN = register(new BlockCokeOven(), e);
        CRUSHER = register(new BlockCrusher(), e);
        INFUSION_TABLE = register(new BlockInfusionTable(), e);
        SAWMILL = register(new BlockSawmill(), e);
    }

    public static void itemRegistry(RegistryEvent.Register<Item> e) {
        registerItemBlock(BRONZER_BLOCK, e);
        registerItemBlock(CHARRED_IRON_BLOCK, e);
        registerItemBlock(COKE_BRICKS, e);
        registerItemBlock(COPPER_BLOCK, e);
        registerItemBlock(COPPER_ORE, e);
        registerItemBlock(CRYSTALLINE_BLOCK, e);
        registerItemBlock(ELECTRUM_BLOCK, e);
        registerItemBlock(SILVER_BLOCK, e);
        registerItemBlock(SILVER_ORE, e);
        registerItemBlock(STEEL_BLOCK, e);
        registerItemBlock(TIN_BLOCK, e);
        registerItemBlock(TIN_ORE, e);

        registerItemBlock(IRONWOOD_LEAVES, e);
        registerItemBlock(IRONWOOD_LOG, e);
        registerItemBlock(IRONWOOD_PLANKS, e);
        registerItemBlock(IRONWOOD_SAPLING, e);
        registerItemBlock(IRONWOOD_WOOD, e);
        registerItemBlock(REDWOOD_LEAVES, e);
        registerItemBlock(REDWOOD_LOG, e);
        registerItemBlock(REDWOOD_PLANKS, e);
        registerItemBlock(REDWOOD_SAPLING, e);
        registerItemBlock(REDWOOD_WOOD, e);
        registerItemBlock(RUBBER_LEAVES, e);
        registerItemBlock(RUBBER_LOG, e);
        registerItemBlock(RUBBER_PLANKS, e);
        registerItemBlock(RUBBER_SAPLING, e);
        registerItemBlock(RUBBER_WOOD, e);
        registerItemBlock(STRIPPED_REDWOOD_LOG, e);
        registerItemBlock(STRIPPED_REDWOOD_WOOD, e);
        registerItemBlock(STRIPPED_IRONWOOD_LOG, e);
        registerItemBlock(STRIPPED_IRONWOOD_WOOD, e);
        registerItemBlock(STRIPPED_RUBBER_LOG, e);
        registerItemBlock(STRIPPED_RUBBER_WOOD, e);

        registerItemBlock(ALLOYER, e);
        registerItemBlock(BLAST_FURNACE, e);
        registerItemBlock(COKE_OVEN, e);
        registerItemBlock(CRUSHER, e);
        registerItemBlock(INFUSION_TABLE, e);
        registerItemBlock(SAWMILL, e);
    }

    private static Block register(Block block, RegistryEvent.Register<Block> e) {
        e.getRegistry().register(block);
        return block;
    }

    private static void registerItemBlock(Block block, RegistryEvent.Register<Item> e) {
        e.getRegistry().register(new ItemBlock(block, new Item.Properties().group(ExpertModeCore.main)).setRegistryName(block.getRegistryName()));
    }
}
