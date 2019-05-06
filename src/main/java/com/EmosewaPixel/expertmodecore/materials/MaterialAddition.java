package com.EmosewaPixel.expertmodecore.materialSystem.materials;

import com.EmosewaPixel.expertmodecore.items.armor.ExpertMaterials;
import com.EmosewaPixel.expertmodecore.items.tools.ExpertTiers;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.types.BlockType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ItemType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class MaterialRegistry {
    public static TextureType ROUGH, REGULAR, SHINY;

    public static Material IRON, GOLD, COPPER, TIN, SILVER, BRONZE, STEEL, ELECTRUM, CHARRED_IRON, CRYSTALLINE, FLINT,
            LAPIS, QUARTZ, DIAMOND, PRISMARINE, MAGMA, STONE, NETHERRACK, EMERALD, REDSTONE;

    public static ObjectType INGOT, NUGGET, PLATE, DUST, BLOCK, ORE, PICKAXE, SHOVEL, AXE, SAW, HAMMER, SWORD, HOE, CHESTPLATE, HELMET, BOOTS, LEGGINGS, SMALL_DUST, GEM;

    static {
        //Texture Types
        ROUGH = new TextureType("rough");
        REGULAR = new TextureType("regular");
        SHINY = new TextureType("shiny");

        //Materials
        IRON = new IngotMaterial("iron", ROUGH, 0xd8d8d8).hasOre().build();
        GOLD = new IngotMaterial("gold", SHINY, 0xfad64a).hasOre().build();
        COPPER = new IngotMaterial("copper", REGULAR, 0xf39500).hasOre().setBlockHarvestTier(HarvestTiers.STONE).build();
        TIN = new IngotMaterial("tin", REGULAR, 0xc1cfcf).hasOre().setBlockHarvestTier(HarvestTiers.STONE).build();
        SILVER = new IngotMaterial("silver", SHINY, 0xf0f7f7).hasOre().setBlockHarvestTier(HarvestTiers.IRON).build();
        BRONZE = new IngotMaterial("bronze", REGULAR, 0xd79117).setToolAndArmorMaterial(ExpertTiers.BRONZE, ExpertMaterials.BRONZE).setBlockHarvestTier(HarvestTiers.STONE).build();
        STEEL = new IngotMaterial("steel", ROUGH, 0xb7b7b7).setToolAndArmorMaterial(ExpertTiers.STEEl, ExpertMaterials.STEEL).setBlockHarvestTier(HarvestTiers.IRON).build();
        ELECTRUM = new IngotMaterial("electrum", SHINY, 0xfaff3b).setToolAndArmorMaterial(ExpertTiers.ELECTRUM, ExpertMaterials.ELECTRUM).setBlockHarvestTier(HarvestTiers.DIAMOND).build();
        CHARRED_IRON = new IngotMaterial("charred_iron", ROUGH, 0x393939).setBlockHarvestTier(HarvestTiers.IRON).build();
        CRYSTALLINE = new IngotMaterial("crystalline", SHINY, 0x76dada).setToolAndArmorMaterial(ExpertTiers.CRYSTALLINE, ExpertMaterials.CRYSTALLINE).setBlockHarvestTier(HarvestTiers.DIAMOND).build();
        FLINT = new Material("flint", REGULAR, 0x222020).setToolAndArmorMaterial(ExpertTiers.FLINT, null).build();
        LAPIS = new GemMaterial("lapis", REGULAR, 0x2351be).build();
        QUARTZ = new GemMaterial("quartz", REGULAR, 0xe8dfd0).build();
        DIAMOND = new GemMaterial("diamond", REGULAR, 0x34ebe3).build();
        EMERALD = new GemMaterial("emerald", REGULAR, 0x08ad2c).build();
        PRISMARINE = new GemMaterial("prismarine", REGULAR, 0xa1dacb).build();
        MAGMA = new DustMaterial("magma", REGULAR, 0xffb62e).build();
        STONE = new DustMaterial("stone", REGULAR, 0xcccccc).build();
        NETHERRACK = new DustMaterial("netherrack", REGULAR, 0xb33939).build();
        REDSTONE = new DustMaterial("redstone", REGULAR, 0xfc1a19).hasOre().build();

        //Object Types
        INGOT = new ItemType("ingot", mat -> mat instanceof IngotMaterial);
        NUGGET = new ItemType("nugget", mat -> mat instanceof IngotMaterial);
        PLATE = new ItemType("plate", mat -> mat instanceof IngotMaterial);
        DUST = new ItemType("dust", mat -> mat instanceof DustMaterial);
        BLOCK = new BlockType("storage_block", mat -> {
            if (mat instanceof DustMaterial)
                return ((DustMaterial) mat).getHarvestTier() != null;
            return false;
        }, Block.Properties.create(net.minecraft.block.material.Material.IRON).sound(SoundType.METAL));
        ORE = new BlockType("ore", mat -> {
            if (mat instanceof IngotMaterial && mat.doesHaveOre())
                return ((IngotMaterial) mat).getHarvestTier() != null;
            return false;
        }, Block.Properties.create(net.minecraft.block.material.Material.ROCK).sound(SoundType.STONE));
        PICKAXE = new ItemType("pickaxe", mat -> false);
        AXE = new ItemType("axe", mat -> false);
        SHOVEL = new ItemType("shovel", mat -> false);
        SWORD = new ItemType("sword", mat -> false);
        HOE = new ItemType("hoe", mat -> false);
        SAW = new ItemType("saw", mat -> false);
        HAMMER = new ItemType("hammer", mat -> false);
        HELMET = new ItemType("helmet", mat -> false);
        CHESTPLATE = new ItemType("chestplate", mat -> false);
        LEGGINGS = new ItemType("leggings", mat -> false);
        BOOTS = new ItemType("boots", mat -> false);
        SMALL_DUST = new ItemType("small_dust", mat -> mat instanceof DustMaterial);
        GEM = new ItemType("gem", mat -> mat instanceof GemMaterial);

        //Giving vanilla items material values
        MaterialItems.addItem(IRON, INGOT, Items.IRON_INGOT);
        MaterialItems.addItem(IRON, NUGGET, Items.IRON_NUGGET);
        MaterialBlocks.addBlock(IRON, BLOCK, Blocks.IRON_BLOCK);
        MaterialBlocks.addBlock(IRON, ORE, Blocks.IRON_ORE);

        MaterialItems.addItem(GOLD, INGOT, Items.GOLD_INGOT);
        MaterialItems.addItem(GOLD, NUGGET, Items.GOLD_NUGGET);
        MaterialBlocks.addBlock(GOLD, BLOCK, Blocks.GOLD_BLOCK);
        MaterialBlocks.addBlock(GOLD, ORE, Blocks.GOLD_ORE);

        MaterialItems.addItem(LAPIS, GEM, Items.LAPIS_LAZULI);
        MaterialBlocks.addBlock(LAPIS, BLOCK, Blocks.LAPIS_BLOCK);
        MaterialBlocks.addBlock(LAPIS, ORE, Blocks.LAPIS_ORE);

        MaterialItems.addItem(DIAMOND, GEM, Items.DIAMOND);
        MaterialBlocks.addBlock(DIAMOND, BLOCK, Blocks.DIAMOND_BLOCK);
        MaterialBlocks.addBlock(DIAMOND, ORE, Blocks.DIAMOND_ORE);

        MaterialItems.addItem(EMERALD, GEM, Items.EMERALD);
        MaterialBlocks.addBlock(EMERALD, BLOCK, Blocks.EMERALD_BLOCK);
        MaterialBlocks.addBlock(EMERALD, ORE, Blocks.EMERALD_ORE);

        MaterialItems.addItem(QUARTZ, GEM, Items.QUARTZ);
        MaterialBlocks.addBlock(QUARTZ, BLOCK, Blocks.QUARTZ_BLOCK);

        MaterialItems.addItem(PRISMARINE, GEM, Items.PRISMARINE_CRYSTALS);
        MaterialBlocks.addBlock(PRISMARINE, BLOCK, Blocks.PRISMARINE);

        MaterialItems.addItem(REDSTONE, DUST, Items.REDSTONE);
        MaterialBlocks.addBlock(REDSTONE, BLOCK, Blocks.REDSTONE_BLOCK);
        MaterialBlocks.addBlock(REDSTONE, ORE, Blocks.REDSTONE_ORE);
    }
}