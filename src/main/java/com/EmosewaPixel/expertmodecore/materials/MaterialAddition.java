package com.EmosewaPixel.expertmodecore.materials;

import com.EmosewaPixel.expertmodecore.items.armor.ExpertMaterials;
import com.EmosewaPixel.expertmodecore.items.tools.ExpertTiers;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.pixellib.materialSystem.materials.*;
import com.EmosewaPixel.pixellib.materialSystem.types.ItemType;
import com.EmosewaPixel.pixellib.materialSystem.types.ObjectType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class MaterialAddition {
    public static Material COPPER, TIN, SILVER, BRONZE, STEEL, ELECTRUM, CHARRED_IRON, CRYSTALLINE, FLINT,
            PRISMARINE, MAGMA, NETHERRACK, COKE;

    public static ObjectType PLATE, PICKAXE, SHOVEL, AXE, SAW, HAMMER, SWORD, HOE, CHESTPLATE, HELMET, BOOTS, LEGGINGS, SMALL_DUST;

    static {
        //Materials
        COPPER = new IngotMaterial("copper", MaterialRegistry.REGULAR, 0xf39500, 0).hasOre().build();
        TIN = new IngotMaterial("tin", MaterialRegistry.REGULAR, 0xc1cfcf, 0).hasOre().build();
        SILVER = new IngotMaterial("silver", MaterialRegistry.SHINY, 0xf0f7f7, 1).hasOre().build();
        BRONZE = new IngotMaterial("bronze", MaterialRegistry.REGULAR, 0xd79117, 0).setItemTier(ExpertTiers.BRONZE).setArmorMaterial(ExpertMaterials.BRONZE).build();
        STEEL = new IngotMaterial("steel", MaterialRegistry.ROUGH, 0xb7b7b7, 1).setItemTier(ExpertTiers.STEEl).setArmorMaterial(ExpertMaterials.STEEL).build();
        ELECTRUM = new IngotMaterial("electrum", MaterialRegistry.SHINY, 0xfaff3b, 1).setItemTier(ExpertTiers.ELECTRUM).setArmorMaterial(ExpertMaterials.ELECTRUM).build();
        CHARRED_IRON = new IngotMaterial("charred_iron", MaterialRegistry.ROUGH, 0x393939, 1).build();
        CRYSTALLINE = new IngotMaterial("crystalline", MaterialRegistry.SHINY, 0x76dada, 2).setItemTier(ExpertTiers.CRYSTALLINE).setArmorMaterial(ExpertMaterials.CRYSTALLINE).build();
        FLINT = new Material("flint", MaterialRegistry.SHARP, 0x222020, -1).setItemTier(ExpertTiers.FLINT).build();
        PRISMARINE = new GemMaterial("prismarine", MaterialRegistry.REGULAR, 0xa1dacb, 0).build();
        MAGMA = new Material("magma", MaterialRegistry.REGULAR, 0xffb62e, 0).build();
        NETHERRACK = new Material("netherrack", MaterialRegistry.REGULAR, 0xb33939, 0).build();
        COKE = new GemMaterial("coke", MaterialRegistry.FUEL, 0x7a939b,0).build();

        //Object Types
        PLATE = new ItemType("plate", (mat) -> mat instanceof IngotMaterial);
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
        SMALL_DUST = new ItemType("small_dust", mat -> (mat instanceof DustMaterial && !(mat instanceof GemMaterial)) || mat == MaterialRegistry.STONE || mat == NETHERRACK || mat == MAGMA);

        //Giving vanilla items material values
        MaterialItems.addItem(PRISMARINE, MaterialRegistry.GEM, Items.PRISMARINE_CRYSTALS);
        MaterialBlocks.addBlock(PRISMARINE, MaterialRegistry.BLOCK, Blocks.PRISMARINE);
    }
}