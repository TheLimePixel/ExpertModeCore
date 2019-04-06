package com.EmosewaPixel.expertmodecore.items.armor;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ModArmor extends ItemArmor {
    public ModArmor(IArmorMaterial materialIn, EntityEquipmentSlot slot) {
        super(materialIn, slot, new Item.Properties().group(ExpertModeCore.main));
        String type = "";
        switch (slot.getName()) {
            case "head":
                type = "helmet";
                break;
            case "chest":
                type = "chestplate";
                break;
            case "legs":
                type = "leggings";
                break;
            case "feet":
                type = "boots";
        }
        setRegistryName(materialIn.toString().toLowerCase() + "_" + type);
    }
}
