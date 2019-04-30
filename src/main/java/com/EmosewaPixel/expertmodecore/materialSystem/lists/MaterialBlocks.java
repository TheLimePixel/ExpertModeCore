package com.EmosewaPixel.expertmodecore.materialSystem.lists;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import com.google.common.collect.HashBasedTable;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class MaterialBlocks {
    public static HashBasedTable<Material, ObjectType, Block> materialBlocks = HashBasedTable.create();

    public static Block getBlock(Material material, ObjectType type) {
        return materialBlocks.get(material, type);
    }

    public static boolean contains(Material material, ObjectType type) {
        return getBlock(material, type) != null;
    }

    public static void addBlock(Material mat, ObjectType type, Block item) {
        materialBlocks.put(mat, type, item);
    }

    public static void addBlock(IMaterialItem item) {
        if (item instanceof Block)
            addBlock(item.getMaterial(), item.getObjType(), (Block) item);
    }

    public static List<Block> getMaterialBlocks() {
        List<Block> matBlocks = new ArrayList<>();

        for (Material mat : MaterialsAndTextureTypes.materials)
            for (ObjectType type : ObjTypes.objTypes)
                if (getBlock(mat, type) instanceof IMaterialItem)
                    matBlocks.add(getBlock(mat, type));

        return matBlocks;
    }
}