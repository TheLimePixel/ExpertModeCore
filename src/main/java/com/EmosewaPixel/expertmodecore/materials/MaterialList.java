package com.EmosewaPixel.expertmodecore.materials;

import com.EmosewaPixel.expertmodecore.items.armor.ExpertMaterials;
import com.EmosewaPixel.expertmodecore.items.tools.ExpertTiers;

import java.util.ArrayList;

public class MaterialList {
    public static ArrayList<Material> materials = new ArrayList<>();

    public static Material IRON, GOLD, COPPER, TIN, SILVER, BRONZE, STEEL, ELECTRUM, CHARRED_IRON, CRYSTALLINE, FLINT,
    LAPIS, QUARTZ, DIAMOND, PRISMARINE;

    public static void registry() {
        IRON = register(new IngotMaterial("iron", TextureType.IRON, 0xd8d8d8).doesntHaveBase());
        GOLD = register(new IngotMaterial("gold", TextureType.SHINY, 0xfad64a).doesntHaveBase());
        COPPER = register(new IngotMaterial("copper", TextureType.REGULAR, 0xe88e00).hasOre().setHarvestTier(HarvestTiers.STONE));
        TIN = register(new IngotMaterial("tin", TextureType.REGULAR, 0xc3d4d4).hasOre().setHarvestTier(HarvestTiers.STONE));
        SILVER = register(new IngotMaterial("silver", TextureType.SHINY, 0xf0f7f7).hasOre().setHarvestTier(HarvestTiers.IRON));
        BRONZE = register(new IngotMaterial("bronze", TextureType.REGULAR, 0xd79117).setToolAndArmorMaterial(ExpertTiers.BRONZE, ExpertMaterials.BRONZE).setHarvestTier(HarvestTiers.STONE));
        STEEL = register(new IngotMaterial("steel", TextureType.IRON, 0xb7b7b7).setToolAndArmorMaterial(ExpertTiers.STEEl, ExpertMaterials.STEEL).setHarvestTier(HarvestTiers.IRON));
        ELECTRUM = register(new IngotMaterial("electrum", TextureType.SHINY, 0xfaff3b).setToolAndArmorMaterial(ExpertTiers.ELECTRUM, ExpertMaterials.ELECTRUM).setHarvestTier(HarvestTiers.DIAMOND));
        CHARRED_IRON = register(new IngotMaterial("charred_iron", TextureType.IRON, 0x393939).setHarvestTier(HarvestTiers.IRON));
        CRYSTALLINE = register(new IngotMaterial("crystalline", TextureType.SHINY, 0x76dada).setToolAndArmorMaterial(ExpertTiers.CRYSTALLINE, ExpertMaterials.CRYSTALLINE).setHarvestTier(HarvestTiers.DIAMOND));
        FLINT = register(new Material("flint", TextureType.REGULAR, 0x222020).setToolAndArmorMaterial(ExpertTiers.FLINT, null));
        LAPIS = register(new DustMaterial("lapis", TextureType.REGULAR, 0x2351be));
        QUARTZ = register(new DustMaterial("quartz", TextureType.REGULAR, 0xe8dfd0));
        DIAMOND = register(new DustMaterial("diamond", TextureType.REGULAR, 0x34ebe3));
        PRISMARINE = register(new DustMaterial("prismarine", TextureType.REGULAR, 0xa1dacb));
    }

    public static Material register(Material material) {
        materials.add(material);
        return material;
    }
}