package com.EmosewaPixel.expertmodecore.materialSystem.materials;

import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;

public class IngotMaterial extends DustMaterial {

    public IngotMaterial(String name, TextureType textureType, int color) {
        super(name, textureType, color);
    }

    public IngotMaterial hasOre() {
        setHasOre(true);
        return this;
    }

    public IngotMaterial setToolAndArmorMaterial(IItemTier itemTier, IArmorMaterial armorMaterial) {
        setItemTier(itemTier);
        setArmorMaterial(armorMaterial);
        return this;
    }

    public IngotMaterial setBlockHarvestTier(IHarvestTier tier) {
        super.setHarvestTier(tier);
        return this;
    }
}