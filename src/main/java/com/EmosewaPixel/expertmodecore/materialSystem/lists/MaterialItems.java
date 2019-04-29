package com.EmosewaPixel.expertmodecore.materialSystem.lists;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;

import java.util.ArrayList;

public class MaterialItems {
    public static ArrayList<IMaterialItem> materialItems = new ArrayList<>();

    public static Item getItem(Material material, ObjectType type) {
        Item item = IRegistry.field_212630_s.func_212608_b(new ResourceLocation("expertmodecore", material.getName() + "_" + type.getName()));
        if (item == null)
            throw new IllegalStateException("Invalid Item requested: " + "expertmodecore:" + material.getName() + "_" + type.getName());
        else
            return item;
    }
}