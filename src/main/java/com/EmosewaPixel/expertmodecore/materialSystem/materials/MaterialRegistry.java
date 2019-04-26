package com.EmosewaPixel.expertmodecore.materialSystem.materials;

import com.EmosewaPixel.expertmodecore.items.armor.ExpertMaterials;
import com.EmosewaPixel.expertmodecore.items.tools.ExpertTiers;
import com.EmosewaPixel.expertmodecore.materialSystem.types.BlockType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ItemType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;

public class MaterialRegistry {
    public static TextureType iron, regular, shiny;

    public static Material IRON, GOLD, COPPER, TIN, SILVER, BRONZE, STEEL, ELECTRUM, CHARRED_IRON, CRYSTALLINE, FLINT,
            LAPIS, QUARTZ, DIAMOND, PRISMARINE, MAGMA, STONE, NETHERRACK;

    public static ObjectType INGOT, NUGGET, PLATE, DUST, BLOCK, ORE, PICKAXE, SHOVEL, AXE, SAW, HAMMER, SWORD, HOE, CHESTPLATE, HELMET, BOOTS, LEGGINGS, SMALL_DUST;

    static {
        iron = new TextureType("iron");
        regular = new TextureType("regular");
        shiny = new TextureType("shiny");

        IRON = new IngotMaterial("iron", iron, 0xd8d8d8).doesntHaveBase().hasOre().build();
        GOLD = new IngotMaterial("gold", shiny, 0xfad64a).doesntHaveBase().hasOre().build();
        COPPER = new IngotMaterial("copper", regular, 0xf39500).hasOre().setHarvestTier(HarvestTiers.STONE).build();
        TIN = new IngotMaterial("tin", regular, 0xc1cfcf).hasOre().setHarvestTier(HarvestTiers.STONE).build();
        SILVER = new IngotMaterial("silver", shiny, 0xf0f7f7).hasOre().setHarvestTier(HarvestTiers.IRON).build();
        BRONZE = new IngotMaterial("bronze", regular, 0xd79117).setToolAndArmorMaterial(ExpertTiers.BRONZE, ExpertMaterials.BRONZE).setHarvestTier(HarvestTiers.STONE).build();
        STEEL = new IngotMaterial("steel", iron, 0xb7b7b7).setToolAndArmorMaterial(ExpertTiers.STEEl, ExpertMaterials.STEEL).setHarvestTier(HarvestTiers.IRON).build();
        ELECTRUM = new IngotMaterial("electrum", shiny, 0xfaff3b).setToolAndArmorMaterial(ExpertTiers.ELECTRUM, ExpertMaterials.ELECTRUM).setHarvestTier(HarvestTiers.DIAMOND).build();
        CHARRED_IRON = new IngotMaterial("charred_iron", iron, 0x393939).setHarvestTier(HarvestTiers.IRON).build();
        CRYSTALLINE = new IngotMaterial("crystalline", shiny, 0x76dada).setToolAndArmorMaterial(ExpertTiers.CRYSTALLINE, ExpertMaterials.CRYSTALLINE).setHarvestTier(HarvestTiers.DIAMOND).build();
        FLINT = new Material("flint", regular, 0x222020).setToolAndArmorMaterial(ExpertTiers.FLINT, null).build();
        LAPIS = new DustMaterial("lapis", regular, 0x2351be).build();
        QUARTZ = new DustMaterial("quartz", regular, 0xe8dfd0).build();
        DIAMOND = new DustMaterial("diamond", regular, 0x34ebe3).build();
        PRISMARINE = new DustMaterial("prismarine", regular, 0xa1dacb).build();
        MAGMA = new DustMaterial("magma", regular, 0xffb62e).build();
        STONE = new DustMaterial("stone", regular, 0xcccccc).doesHaveSmallDust().build();
        NETHERRACK = new DustMaterial("netherrack", regular, 0xb33939).build();

        INGOT = new ItemType("ingot", mat -> {
            if (mat instanceof IngotMaterial)
                return mat.doesHaveBase();
            return false;
        });
        NUGGET = new ItemType("nugget", mat -> {
            if (mat instanceof IngotMaterial)
                return mat.doesHaveBase();
            return false;
        });
        PLATE = new ItemType("plate", mat -> mat instanceof IngotMaterial);
        DUST = new ItemType("dust", mat -> mat instanceof DustMaterial);
        BLOCK = new BlockType("block", mat -> {
            if (mat instanceof IngotMaterial && mat.doesHaveBase())
                return ((IngotMaterial) mat).getHarvestTier() != null;
            return false;
        }, Block.Properties.create(net.minecraft.block.material.Material.IRON).sound(SoundType.METAL));
        ORE = new BlockType("ore", mat -> {
            if (mat instanceof IngotMaterial && mat.doesHaveBase() && mat.doesHaveOre())
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
        SMALL_DUST = new ItemType("small_dust", mat -> {
            if (mat instanceof DustMaterial)
                return ((DustMaterial) mat).hasSmallDust();
            return false;
        });
    }
}