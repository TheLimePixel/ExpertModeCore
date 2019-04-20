package com.EmosewaPixel.expertmodecore.materials;

import net.minecraft.item.Item;

import java.util.ArrayList;

public class MaterialItems {
    public static ArrayList<IMaterialItem> materialItems = new ArrayList<>();

    public static Item getItem(Material material, String itemType) {
        for (IMaterialItem matItem : materialItems)
            if (matItem.getMaterial() == material && matItem.getItemType().equals(itemType) && matItem instanceof Item)
                return (Item) matItem;
        return null;
    }
}