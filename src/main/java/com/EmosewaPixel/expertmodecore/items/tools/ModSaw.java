package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ModSaw extends ItemAxe {
    public ModSaw(IItemTier tier, float attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Item.Properties().defaultMaxDamage(tier.getMaxUses() / 3 * 2).group(ExpertModeCore.main));
        setRegistryName(tier.toString().toLowerCase() + "_saw");
        efficiency = tier.getEfficiency() / 2;
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
}
