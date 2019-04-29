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
    public static TextureType ROUGH, REGULAR, SHINY;

    public static Material IRON, GOLD, COPPER, TIN, SILVER, BRONZE, STEEL, ELECTRUM, CHARRED_IRON, CRYSTALLINE, FLINT,
            LAPIS, QUARTZ, DIAMOND, PRISMARINE, MAGMA, STONE, NETHERRACK;

    public static ObjectType INGOT, NUGGET, PLATE, DUST, BLOCK, ORE, PICKAXE, SHOVEL, AXE, SAW, HAMMER, SWORD, HOE, CHESTPLATE, HELMET, BOOTS, LEGGINGS, SMALL_DUST, GEM;

    static {
        ROUGH = new TextureType("rough");
        REGULAR = new TextureType("regular");
        SHINY = new TextureType("shiny");

        IRON = new IngotMaterial("iron", ROUGH, 0xd8d8d8).doesntHaveBase().hasOre().build();
        GOLD = new IngotMaterial("gold", SHINY, 0xfad64a).doesntHaveBase().hasOre().build();
        COPPER = new IngotMaterial("copper", REGULAR, 0xf39500).hasOre().setBlockHarvestTier(HarvestTiers.STONE).build();
        TIN = new IngotMaterial("tin", REGULAR, 0xc1cfcf).hasOre().setBlockHarvestTier(HarvestTiers.STONE).build();
        SILVER = new IngotMaterial("silver", SHINY, 0xf0f7f7).hasOre().setBlockHarvestTier(HarvestTiers.IRON).build();
        BRONZE = new IngotMaterial("bronze", REGULAR, 0xd79117).setToolAndArmorMaterial(ExpertTiers.BRONZE, ExpertMaterials.BRONZE).setBlockHarvestTier(HarvestTiers.STONE).build();
        STEEL = new IngotMaterial("steel", ROUGH, 0xb7b7b7).setToolAndArmorMaterial(ExpertTiers.STEEl, ExpertMaterials.STEEL).setBlockHarvestTier(HarvestTiers.IRON).build();
        ELECTRUM = new IngotMaterial("electrum", SHINY, 0xfaff3b).setToolAndArmorMaterial(ExpertTiers.ELECTRUM, ExpertMaterials.ELECTRUM).setBlockHarvestTier(HarvestTiers.DIAMOND).build();
        CHARRED_IRON = new IngotMaterial("charred_iron", ROUGH, 0x393939).setBlockHarvestTier(HarvestTiers.IRON).build();
        CRYSTALLINE = new IngotMaterial("crystalline", SHINY, 0x76dada).setToolAndArmorMaterial(ExpertTiers.CRYSTALLINE, ExpertMaterials.CRYSTALLINE).setBlockHarvestTier(HarvestTiers.DIAMOND).build();
        FLINT = new Material("flint", REGULAR, 0x222020).setToolAndArmorMaterial(ExpertTiers.FLINT, null).build();
        LAPIS = new GemMaterial("lapis", REGULAR, 0x2351be).doesntHaveBase().build();
        QUARTZ = new GemMaterial("quartz", REGULAR, 0xe8dfd0).doesntHaveBase().build();
        DIAMOND = new GemMaterial("diamond", REGULAR, 0x34ebe3).doesntHaveBase().build();
        PRISMARINE = new GemMaterial("prismarine", REGULAR, 0xa1dacb).doesntHaveBase().build();
        MAGMA = new DustMaterial("magma", REGULAR, 0xffb62e).build();
        STONE = new DustMaterial("stone", REGULAR, 0xcccccc).doesHaveSmallDust().build();
        NETHERRACK = new DustMaterial("netherrack", REGULAR, 0xb33939).build();

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
        BLOCK = new BlockType("storage_block", mat -> {
            if (mat instanceof DustMaterial && mat.doesHaveBase())
                return ((DustMaterial) mat).getHarvestTier() != null;
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
        GEM = new ItemType("gem", mat -> {
            if (mat instanceof GemMaterial)
                return mat.doesHaveBase();
            return false;
        });
    }
}