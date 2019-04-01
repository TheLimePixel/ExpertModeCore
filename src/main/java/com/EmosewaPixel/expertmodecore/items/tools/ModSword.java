package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemSword;

public class ModSword extends ItemSword {
    public ModSword(IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, (new Properties()).group(ExpertModeCore.main));
        setRegistryName(tier.toString().toLowerCase() + "_sword");
    }
}
