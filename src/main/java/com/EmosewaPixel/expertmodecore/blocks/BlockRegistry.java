package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.blocks.trees.*;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialsAndTextureTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.ObjTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.expertmodecore.materialSystem.types.BlockType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
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

import java.util.ArrayList;

public class BlockRegistry {
    public static Block COKE_BRICKS;

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

    private static ArrayList<Block> templates = new ArrayList<>();

    public static void registry(RegistryEvent.Register<Block> e) {
        for (com.EmosewaPixel.expertmodecore.materialSystem.materials.Material mat : MaterialsAndTextureTypes.materials)
            for (ObjectType type : ObjTypes.objTypes)
                if (type instanceof BlockType && type.isMaterialCompatible(mat))
                    register(new MaterialBlock((IngotMaterial) mat, (BlockType) type), e);

        COKE_BRICKS = register(new ModBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2, 6).sound(SoundType.STONE), "coke_bricks", 0), e);

        IRONWOOD_LEAVES = register(new BlockIronwoodLeaves(), e);
        IRONWOOD_LOG = register(new ModLog("ironwood_log", 1, 7), e);
        IRONWOOD_PLANKS = register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:ironwood_planks"), e);
        IRONWOOD_SAPLING = register(new ModSapling(new IronwoodTree(), "ironwood_sapling"), e);
        IRONWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:ironwood_wood"), e);
        REDWOOD_LEAVES = register(new BlockRedwoodLeaves(), e);
        REDWOOD_LOG = register(new ModLog("redwood_log", 2, 4), e);
        REDWOOD_PLANKS = register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:redwood_planks"), e);
        REDWOOD_SAPLING = register(new ModSapling(new RedwoodTree(), "redwood_sapling"), e);
        REDWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:redwood_wood"), e);
        RUBBER_LEAVES = register(new BlockRubberLeaves(), e);
        RUBBER_LOG = register(new BlockRubberLog(), e);
        RUBBER_PLANKS = register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:rubber_planks"), e);
        RUBBER_SAPLING = register(new ModSapling(new RubberTree(), "rubber_sapling"), e);
        RUBBER_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:rubber_wood"), e);
        STRIPPED_IRONWOOD_LOG = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:stripped_ironwood_log"), e);
        STRIPPED_IRONWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:stripped_ironwood_wood"), e);
        STRIPPED_REDWOOD_LOG = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:stripped_redwood_log"), e);
        STRIPPED_REDWOOD_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:stripped_redwood_wood"), e);
        STRIPPED_RUBBER_LOG = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:stripped_rubber_log"), e);
        STRIPPED_RUBBER_WOOD = register(new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("expertmodecore:stripped_rubber_wood"), e);

        ALLOYER = register(new BlockAlloyer(), e);
        BLAST_FURNACE = register(new BlockBlastFurnace(), e);
        COKE_OVEN = register(new BlockCokeOven(), e);
        CRUSHER = register(new BlockCrusher(), e);
        INFUSION_TABLE = register(new BlockInfusionTable(), e);
        SAWMILL = register(new BlockSawmill(), e);

        for (ObjectType objT : ObjTypes.objTypes)
            if (objT instanceof BlockType)
                for (TextureType textureT : MaterialsAndTextureTypes.textureTypes)
                    if (!(textureT == MaterialRegistry.iron && objT.isMaterialCompatible(MaterialRegistry.IRON)))
                        templates.add(register(new ModBlock(Block.Properties.create(Material.IRON), textureT.toString() + "_" + objT.getName(), 0), e));
    }

    public static void itemRegistry(RegistryEvent.Register<Item> e) {
        for (MaterialItem block : MaterialBlocks.materialBlocks)
            if (block instanceof Block)
                registerItemBlock((Block) block, e);

        registerItemBlock(COKE_BRICKS, e);
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

        for (Block template : templates)
            registerItemBlock(template, e, false);
    }

    private static Block register(Block block, RegistryEvent.Register<Block> e) {
        e.getRegistry().register(block);
        return block;
    }

    private static void registerItemBlock(Block block, RegistryEvent.Register<Item> e) {
        registerItemBlock(block, e, true);
    }

    private static void registerItemBlock(Block block, RegistryEvent.Register<Item> e, boolean withGroup) {
        e.getRegistry().register(new ItemBlock(block, withGroup ? new Item.Properties().group(ExpertModeCore.main) : new Item.Properties()).setRegistryName(block.getRegistryName()));
    }
}
