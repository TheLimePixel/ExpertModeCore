package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.item.ItemHoe;

public class MaterialHoe extends ItemHoe implements MaterialItem {
    private Material material;

    public MaterialHoe(Material mat) {
        super(mat.getItemTier(), mat.getItemTier().getHarvestLevel() - 3, (new Properties()).group(ExpertModeCore.main));
        setRegistryName("expertmodecore:" + mat.getName() + "_hoe");
        this.material = mat;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return MaterialRegistry.HOE;
    }
}