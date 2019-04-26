package com.EmosewaPixel.expertmodecore.materialSystem.lists;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class MaterialItems {
    public static ArrayList<MaterialItem> materialItems = new ArrayList<>();

    public static Item getItem(Material material, ObjectType type) {
        for (MaterialItem matItem : materialItems)
            if (matItem.getMaterial() == material && matItem.getObjType().equals(type) && matItem instanceof Item)
                return (Item) matItem;
        return null;
    }
}