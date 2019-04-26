package com.EmosewaPixel.expertmodecore.materialSystem.types;

import net.minecraft.block.Block;

public class BlockType extends ObjectType {
    private Block.Properties properties;

    public BlockType(String name, TypeRequirement requirement, Block.Properties properties) {
        super(name, requirement);
        this.properties=properties;
    }

    public Block.Properties getProperties() {
        return properties;
    }
}
