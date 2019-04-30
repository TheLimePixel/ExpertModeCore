package com.EmosewaPixel.expertmodecore.materialSystem.types;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import net.minecraft.block.Block;

import java.util.function.Predicate;

public class BlockType extends ObjectType {
    private Block.Properties properties;

    public BlockType(String name, Predicate<Material> requirement, Block.Properties properties) {
        super(name, requirement);
        this.properties=properties;
    }

    public Block.Properties getProperties() {
        return properties;
    }
}