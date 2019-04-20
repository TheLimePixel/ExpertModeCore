package com.EmosewaPixel.expertmodecore.materials;

import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;

public class DustMaterial extends Material {
    public DustMaterial(String name, TextureType textureType, int color) {
        super(name, textureType, color);
    }

    public DustMaterial hasOre() {
        setHasOre(true);
        return this;
    }

    public DustMaterial doesntHaveBase() {
        setHasOre(false);
        return this;
    }

    public DustMaterial setToolAndArmorMaterial(IItemTier itemTier, IArmorMaterial armorMaterial) {
        setItemTier(itemTier);
        setArmorMaterial(armorMaterial);
        return this;
    }
}