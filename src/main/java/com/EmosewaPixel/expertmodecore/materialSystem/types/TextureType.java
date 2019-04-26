package com.EmosewaPixel.expertmodecore.materialSystem.types;

import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialsAndTextureTypes;

public class TextureType {
    private String name;

    public TextureType(String name) {
        this.name = name;
        MaterialsAndTextureTypes.textureTypes.add(this);
    }

    public String toString() {
        return name;
    }
}
