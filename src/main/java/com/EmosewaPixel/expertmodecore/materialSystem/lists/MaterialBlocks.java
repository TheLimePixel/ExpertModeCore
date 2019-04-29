package com.EmosewaPixel.expertmodecore.materialSystem.lists;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;

import java.util.ArrayList;

public class MaterialBlocks {
    public static ArrayList<IMaterialItem> materialBlocks = new ArrayList<>();

    public static Block getBlock(Material material, ObjectType type) {
        Block block = IRegistry.field_212618_g.get(new ResourceLocation("expertmodecore", material.getName() + "_" + type.getName()));
        if (block == null)
            throw new IllegalStateException("Invalid Block requested: " + "expertmodecore:" + material.getName() + "_" + type.getName());
        else
            return block;
    }
}