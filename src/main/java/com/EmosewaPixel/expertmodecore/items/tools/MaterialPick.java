package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materials.Material;
import com.EmosewaPixel.expertmodecore.materials.MaterialItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class MaterialPick extends ItemPickaxe implements IMaterialItem {
    private Material material;

    public MaterialPick(Material mat) {
        super(mat.getItemTier(), 1, -2.8F, (new Item.Properties()).group(ExpertModeCore.main));
        setRegistryName(mat.getName() + "_pickaxe");
        this.material = mat;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public String getItemType() {
        return "pickaxe";
    }
}
