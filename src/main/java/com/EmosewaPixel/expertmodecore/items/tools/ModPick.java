package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ModPick extends ItemPickaxe {
    public ModPick(IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, (new Item.Properties()).group(ExpertModeCore.main));
        setRegistryName(tier.toString().toLowerCase() + "_pickaxe");
    }
}
