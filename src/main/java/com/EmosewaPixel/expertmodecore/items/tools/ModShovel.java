package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemSpade;

public class ModShovel extends ItemSpade {
    public ModShovel(IItemTier tier, float attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, (new Properties()).group(ExpertModeCore.main));
        setRegistryName(tier.toString().toLowerCase() + "_shovel");
    }
}
