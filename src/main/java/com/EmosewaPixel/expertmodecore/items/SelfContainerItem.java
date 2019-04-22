package com.EmosewaPixel.expertmodecore.items;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SelfContainerItem extends Item {
    public SelfContainerItem(String name) {
        super(new Item.Properties().group(ExpertModeCore.main));
        setRegistryName("expertmodecore:" + name);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(this);
    }
}
