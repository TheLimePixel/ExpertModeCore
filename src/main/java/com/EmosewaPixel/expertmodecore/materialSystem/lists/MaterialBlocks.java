package com.EmosewaPixel.expertmodecore.materialSystem.lists;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class MaterialBlocks {
    public static ArrayList<MaterialItem> materialBlocks = new ArrayList<>();

    public static Block getBlock(Material material, ObjectType type) {
        for (MaterialItem matItem : materialBlocks)
            if (matItem.getMaterial() == material && matItem.getObjType().equals(type) && matItem instanceof Block)
                return (Block) matItem;
        return null;
    }
}