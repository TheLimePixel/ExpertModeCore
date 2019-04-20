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
        COPPER = register(new IngotMaterial("copper", TextureType.REGULAR, 0xd48300).hasOre().setHarvestTier(HarvestTiers.STONE));
        TIN = register(new IngotMaterial("tin", TextureType.REGULAR, 0xaec0c5).hasOre().setHarvestTier(HarvestTiers.STONE));
        SILVER = register(new IngotMaterial("silver", TextureType.SHINY, 0xc6cbcb).hasOre().setHarvestTier(HarvestTiers.IRON));
        BRONZE = register(new IngotMaterial("bronze", TextureType.REGULAR, 0xb97d14).setToolAndArmorMaterial(ExpertTiers.BRONZE, ExpertMaterials.BRONZE).setHarvestTier(HarvestTiers.STONE));
        STEEL = register(new IngotMaterial("steel", TextureType.IRON, 0x848484).setToolAndArmorMaterial(ExpertTiers.STEEl, ExpertMaterials.STEEL).setHarvestTier(HarvestTiers.IRON));
        ELECTRUM = register(new IngotMaterial("electrum", TextureType.SHINY, 0xebef42).setToolAndArmorMaterial(ExpertTiers.ELECTRUM, ExpertMaterials.ELECTRUM).setHarvestTier(HarvestTiers.DIAMOND));
        CHARRED_IRON = register(new IngotMaterial("charred_iron", TextureType.IRON, 0x393939).setHarvestTier(HarvestTiers.IRON));
        CRYSTALLINE = register(new IngotMaterial("crystalline", TextureType.SHINY, 0x7daeae).setToolAndArmorMaterial(ExpertTiers.CRYSTALLINE, ExpertMaterials.CRYSTALLINE).setHarvestTier(HarvestTiers.DIAMOND));
        FLINT = register(new Material("flint", null, 0x222020).setToolAndArmorMaterial(ExpertTiers.FLINT, null));
        LAPIS = register(new DustMaterial("lapis", null, 0x1a3d8f));
        QUARTZ = register(new DustMaterial("quartz", null, 0xddd4c6));
        DIAMOND = register(new DustMaterial("diamond", null, 0x2ce0d8));
        PRISMARINE = register(new DustMaterial("prismarine", null, 0x91c5b7));
    }

    public static Material register(Material material) {
        materials.add(material);
        return material;
    }
}