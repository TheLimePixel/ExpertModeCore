package com.EmosewaPixel.expertmodecore.materialSystem.types;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;

import java.util.function.Predicate;

public class ItemType extends ObjectType {
    public ItemType(String name, Predicate<Material> requirement) {
        super(name, requirement);
    }
}
