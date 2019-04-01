package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ModHammer extends ItemPickaxe {
    public ModHammer(IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().defaultMaxDamage(tier.getMaxUses()).group(ExpertModeCore.main));
        setRegistryName(tier.toString().toLowerCase() + "_hammer");
        efficiency = tier.getEfficiency() / 4;
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