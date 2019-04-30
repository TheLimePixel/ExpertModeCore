package com.EmosewaPixel.expertmodecore.materialSystem.materials;

import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialsAndTextureTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class Material {
    private String name;
    private TextureType textureType;
    private int color;
    private boolean hasOre = false;
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

    public Material setToolAndArmorMaterial(IItemTier itemTier, IArmorMaterial armorMaterial) {
        this.itemTier = itemTier;
        this.armorMaterial = armorMaterial;
        return this;
    }

    public Material build() {
        MaterialsAndTextureTypes.materials.add(this);
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

    public IArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    public IItemTier getItemTier() {
        return itemTier;
    }

    public void setHasOre(boolean hasOre) {
        this.hasOre = hasOre;
    }

    public void setItemTier(IItemTier itemTier) {
        this.itemTier = itemTier;
    }

    public void setArmorMaterial(IArmorMaterial armorMaterial) {
        this.armorMaterial = armorMaterial;
    }

    public ITextComponent getTranslationKey() {
        return new TextComponentTranslation("material." + name + ".name");
    }

    public Tag<Item> getTag(ObjectType type) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", type.getName() + "s/" + name));
    }
}