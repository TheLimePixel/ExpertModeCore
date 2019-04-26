package com.EmosewaPixel.expertmodecore.materialSystem.materials;

import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;

public class IngotMaterial extends DustMaterial {
    private HarvestTier harvestTier = null;

    public IngotMaterial(String name, TextureType textureType, int color) {
        super(name, textureType, color);
    }

    public IngotMaterial hasOre() {
        setHasOre(true);
        return this;
    }

    public IngotMaterial doesntHaveBase() {
        setHasBase(false);
        return this;
    }

    public IngotMaterial setToolAndArmorMaterial(IItemTier itemTier, IArmorMaterial armorMaterial) {
        setItemTier(itemTier);
        setArmorMaterial(armorMaterial);
        return this;
    }

    public IngotMaterial setHarvestTier(HarvestTier tier) {
        this.harvestTier = tier;
        return this;
    }

    public HarvestTier getHarvestTier() {
        return harvestTier;
    }
}