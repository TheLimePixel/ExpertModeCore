package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class MaterialPick extends ItemPickaxe implements MaterialItem {
    private Material material;

    public MaterialPick(Material mat) {
        super(mat.getItemTier(), 1, -2.8F, (new Item.Properties()).group(ExpertModeCore.main));
        setRegistryName("expertmodecore:" + mat.getName() + "_pickaxe");
        this.material = mat;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return MaterialRegistry.PICKAXE;
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new TextComponentTranslation("itemtype.pickaxe.name", material.getTranslationKey());
    }
}
