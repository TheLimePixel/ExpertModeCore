package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class MaterialSaw extends ItemAxe implements MaterialItem {
    private Material material;

    public MaterialSaw(Material mat) {
        super(mat.getItemTier(), 3, 3.4F - mat.getItemTier().getEfficiency() / 2 * 0.1F, new Item.Properties().defaultMaxDamage(mat.getItemTier().getMaxUses() / 3 * 2).group(ExpertModeCore.main));
        setRegistryName("expertmodecore:" + mat.getName() + "_saw");
        efficiency = mat.getItemTier().getEfficiency() / 2;
        this.material = mat;
        MaterialItems.materialItems.add(this);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        container.setDamage(container.getDamage() + 2);
        if (container.getDamage() < container.getMaxDamage())
            return container;
        else
            return ItemStack.EMPTY;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return MaterialRegistry.SAW;
    }
}
