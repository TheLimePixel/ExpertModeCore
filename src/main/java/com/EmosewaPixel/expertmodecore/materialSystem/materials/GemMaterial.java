package com.EmosewaPixel.expertmodecore.materialSystem.materials;

import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;

public class GemMaterial extends DustMaterial {

    public GemMaterial(String name, TextureType textureType, int color) {
        super(name, textureType, color);
    }

    public GemMaterial hasOre() {
        setHasOre(true);
        return this;
    }

    public GemMaterial doesntHaveBase() {
        setHasBase(false);
        return this;
    }

    public GemMaterial setToolAndArmorMaterial(IItemTier itemTier, IArmorMaterial armorMaterial) {
        setItemTier(itemTier);
        setArmorMaterial(armorMaterial);
        return this;
    }

    public GemMaterial setBlockHarvestTier(IHarvestTier tier) {
        super.setHarvestTier(tier);
        return this;
    }
}