package com.EmosewaPixel.expertmodecore.materials;

import net.minecraft.block.Block;

import java.util.ArrayList;

public class MaterialBlocks {
    public static ArrayList<IMaterialItem> materialBlocks = new ArrayList<>();

    public static Block getBlock(Material material, String itemType) {
        for (IMaterialItem matItem : materialBlocks)
            if (matItem.getMaterial() == material && matItem.getItemType().equals(itemType) && matItem instanceof Block)
                return (Block) matItem;
        return null;
    }
}