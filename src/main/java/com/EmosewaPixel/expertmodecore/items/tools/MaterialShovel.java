package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materials.MaterialAddition;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.pixellib.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.pixellib.materialSystem.materials.Material;
import com.EmosewaPixel.pixellib.materialSystem.types.ObjectType;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class MaterialShovel extends ItemSpade implements IMaterialItem {
    private Material material;

    public MaterialShovel(Material mat) {
        super(mat.getItemTier(), 1.5F, -3, (new Properties()).group(ExpertModeCore.main));
        setRegistryName("expertmodecore:" + mat.getName() + "_shovel");
        this.material = mat;
        MaterialItems.addItem(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return MaterialAddition.SHOVEL;
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new TextComponentTranslation("itemtype.shovel.name", material.getTranslationKey());
    }
}
