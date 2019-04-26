package com.EmosewaPixel.expertmodecore.materialSystem.types;

import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;

@FunctionalInterface
public interface TypeRequirement {
    boolean compatibleMaterial(Material mat);
}