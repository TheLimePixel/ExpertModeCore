package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materials.Material;
import com.EmosewaPixel.expertmodecore.materials.MaterialItems;
import net.minecraft.item.ItemAxe;

public class MaterialAxe extends ItemAxe implements IMaterialItem {
    private Material material;

    public MaterialAxe(Material mat) {
        super(mat.getItemTier(), 6, -3.4F + mat.getItemTier().getEfficiency() / 2 * 0.1F, (new Properties()).group(ExpertModeCore.main));
        setRegistryName(mat.getName() + "_axe");
        this.material = mat;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public String getItemType() {
        return "axe";
    }
}
