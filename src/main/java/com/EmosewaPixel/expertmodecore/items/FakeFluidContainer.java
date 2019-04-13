package com.EmosewaPixel.expertmodecore.items;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FakeFluidContainer extends Item {
    private Item container;

    public FakeFluidContainer(String name, Item container) {
        super(new Properties().group(ExpertModeCore.main).maxStackSize(1));
        setRegistryName(name);
        this.container = container;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(container);
    }
}
