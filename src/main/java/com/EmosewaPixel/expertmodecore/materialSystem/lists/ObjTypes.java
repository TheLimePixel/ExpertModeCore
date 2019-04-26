package com.EmosewaPixel.expertmodecore.materialSystem.lists;

import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;

import java.util.ArrayList;

public class ObjTypes {
    public static ArrayList<ObjectType> objTypes = new ArrayList<>();

    public static ObjectType getTypeFromName(String name) {
        for (ObjectType type : objTypes)
            if (type.getName().equals(name))
                return type;
        return null;
    }
}
