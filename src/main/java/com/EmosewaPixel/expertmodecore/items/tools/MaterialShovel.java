package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materials.Material;
import com.EmosewaPixel.expertmodecore.materials.MaterialItems;
import net.minecraft.item.ItemSpade;

public class MaterialShovel extends ItemSpade implements IMaterialItem {
    private Material material;

    public MaterialShovel(Material mat) {
        super(mat.getItemTier(), 1.5F, -3, (new Properties()).group(ExpertModeCore.main));
        setRegistryName(mat.getName() + "_shovel");
        this.material = mat;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public String getItemType() {
        return "shovel";
    }
}
