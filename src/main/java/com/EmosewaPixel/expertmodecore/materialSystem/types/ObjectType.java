package com.EmosewaPixel.expertmodecore.materialSystem.types;

import com.EmosewaPixel.expertmodecore.materialSystem.lists.ObjTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;

public class ObjectType {
    private String name;
    private TypeRequirement requirement;

    public ObjectType(String name, TypeRequirement requirement) {
        this.name = name;
        this.requirement = requirement;
        ObjTypes.objTypes.add(this);
    }

    public String getName() {
        return name;
    }

    public boolean isMaterialCompatible(Material mat) {
        return requirement.compatibleMaterial(mat);
    }
}
