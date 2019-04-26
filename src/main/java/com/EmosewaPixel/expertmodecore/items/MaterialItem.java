package com.EmosewaPixel.expertmodecore.items;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.item.Item;

public class MaterialItem extends Item implements com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem {
    private Material material;
    private ObjectType type;

    public MaterialItem(Material material, ObjectType type) {
        super(new Item.Properties().group(ExpertModeCore.main));
        setRegistryName("expertmodecore:" + material.getName() + "_" + type.getName());
        this.material = material;
        this.type = type;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return type;
    }
}
