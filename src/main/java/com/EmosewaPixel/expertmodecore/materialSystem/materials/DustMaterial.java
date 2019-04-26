package com.EmosewaPixel.expertmodecore.materialSystem.materials;

import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;

public class DustMaterial extends Material {
    private boolean hasSmallDust = false;

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

    public DustMaterial doesHaveSmallDust() {
        hasSmallDust = true;
        return this;
    }

    public boolean hasSmallDust() {
        return hasSmallDust;
    }
}