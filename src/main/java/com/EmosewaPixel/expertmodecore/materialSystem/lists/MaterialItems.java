package com.EmosewaPixel.expertmodecore.materialSystem.lists;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import com.google.common.collect.HashBasedTable;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class MaterialItems {
    private static HashBasedTable<Material, ObjectType, Item> materialItems = HashBasedTable.create();

    public static Item getItem(Material material, ObjectType type) {
        return materialItems.get(material, type);
    }

    public static boolean contains(Material material, ObjectType type) {
        return getItem(material, type) != null;
    }

    public static void addItem(Material mat, ObjectType type, Item item) {
        materialItems.put(mat, type, item);
    }

    public static void addItem(IMaterialItem item) {
        if (item instanceof Item)
            addItem(item.getMaterial(), item.getObjType(), (Item) item);
    }


    public static List<Item> getMaterialItems() {
        List<Item> matItems = new ArrayList<>();

        for (Material mat : MaterialsAndTextureTypes.materials)
            for (ObjectType type : ObjTypes.objTypes)
                if (getItem(mat, type) instanceof IMaterialItem)
                    matItems.add(getItem(mat, type));

        return matItems;
    }
}