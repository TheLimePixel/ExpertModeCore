package com.EmosewaPixel.expertmodecore.items.armor;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.ObjTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class MaterialArmor extends ItemArmor implements MaterialItem {
    private Material material;
    private String type;

    public MaterialArmor(Material material, EntityEquipmentSlot slot) {
        super(material.getArmorMaterial(), slot, new Item.Properties().group(ExpertModeCore.main));
        this.material = material;
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
        this.type = type;
        setRegistryName("expertmodecore:" + material.getName() + "_" + type);
        MaterialItems.materialItems.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return ObjTypes.getTypeFromName(type);
    }
}
