package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemHoe;

public class ModHoe extends ItemHoe {
    public ModHoe(IItemTier tier, float attackDamageIn) {
        super(tier, attackDamageIn, (new Properties()).group(ExpertModeCore.main));
        setRegistryName(tier.toString().toLowerCase() + "_hoe");
    }
}
