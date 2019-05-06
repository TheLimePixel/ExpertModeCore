package com.EmosewaPixel.expertmodecore.resourceAddition;

import com.EmosewaPixel.expertmodecore.materials.MaterialAddition;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.pixellib.materialSystem.lists.Materials;
import com.EmosewaPixel.pixellib.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.pixellib.materialSystem.materials.Material;
import com.EmosewaPixel.pixellib.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.pixellib.resourceAddition.RecipeInjector;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class DataAddition {
    public static void register() {
        for (Material mat : Materials.getAll()) {
            if (mat instanceof IngotMaterial)
                if (((IngotMaterial) mat).hasSimpleProcessing())
                    RecipeInjector.addShapedRecipe(location(mat.getName() + "_plate"), new ItemStack(MaterialItems.getItem(mat, MaterialAddition.PLATE)), "H", "I", 'H', MaterialAddition.HAMMER.getTag(), 'I', mat.getTag(MaterialRegistry.INGOT));
            if (MaterialItems.contains(mat, MaterialRegistry.DUST) && MaterialItems.contains(mat, MaterialAddition.SMALL_DUST))
                RecipeInjector.addShapedRecipe(location(mat.getName() + "_dust_from_small_dust"), new ItemStack(MaterialItems.getItem(mat, MaterialRegistry.DUST)), "DD", "DD", 'D', mat.getTag(MaterialAddition.SMALL_DUST));
        }

    }

    private static ResourceLocation location(String name) {
        return new ResourceLocation("expertmodecore", name);
    }
}