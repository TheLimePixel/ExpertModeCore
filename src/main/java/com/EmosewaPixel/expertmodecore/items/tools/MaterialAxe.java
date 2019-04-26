package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.item.ItemAxe;

public class MaterialAxe extends ItemAxe implements MaterialItem {
    private Material material;

    public MaterialAxe(Material mat) {
        super(mat.getItemTier(), 6, -3.4F + mat.getItemTier().getEfficiency() / 2 * 0.1F, (new Properties()).group(ExpertModeCore.main));
        setRegistryName("expertmodecore:" + mat.getName() + "_axe");
        this.material = mat;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return MaterialRegistry.AXE;
    }
}
