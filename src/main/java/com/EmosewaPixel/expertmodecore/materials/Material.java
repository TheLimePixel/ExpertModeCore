package com.EmosewaPixel.expertmodecore.materials;

import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;

public class Material {
    private String name;
    private TextureType textureType;
    private int color;
    private boolean hasOre = false;
    private boolean hasBase = true;
    private IItemTier itemTier = null;
    private IArmorMaterial armorMaterial = null;

    public Material(String name, TextureType textureType, int color) {
        this.name = name;
        this.textureType = textureType;
        this.color = color;
    }

    public Material hasOre() {
        this.hasOre = true;
        return this;
    }

    public Material doesntHaveBase() {
        this.hasBase = false;
        return this;
    }

    public Material setToolAndArmorMaterial(IItemTier itemTier, IArmorMaterial armorMaterial) {
        this.itemTier = itemTier;
        this.armorMaterial = armorMaterial;
        return this;
    }

    public String getName() {
        return name;
    }

    public TextureType getTextureType() {
        return textureType;
    }

    public int getColor() {
        return color;
    }

    public boolean doesHaveOre() {
        return hasOre;
    }

    public boolean doesHaveBase() {
        return hasBase;
    }

    public IArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    public IItemTier getItemTier() {
        return itemTier;
    }

    public void setHasOre(boolean hasOre) {
        this.hasOre = hasOre;
    }

    public void setHasBase(boolean hasBase) {
        this.hasBase = hasBase;
    }

    public void setItemTier(IItemTier itemTier) {
        this.itemTier = itemTier;
    }

    public void setArmorMaterial(IArmorMaterial armorMaterial) {
        this.armorMaterial = armorMaterial;
    }
}