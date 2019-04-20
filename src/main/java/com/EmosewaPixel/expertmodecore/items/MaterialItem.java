package com.EmosewaPixel.expertmodecore.items;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materials.Material;
import com.EmosewaPixel.expertmodecore.materials.MaterialItems;
import net.minecraft.item.Item;

public class MaterialItem extends Item implements IMaterialItem {
    private Material material;
    private String type;

    public MaterialItem(Material material, String type) {
        super(new Item.Properties().group(ExpertModeCore.main));
        setRegistryName(material.getName() + "_" + type);
        this.material = material;
        this.type = type;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public String getItemType() {
        return type;
    }
}
