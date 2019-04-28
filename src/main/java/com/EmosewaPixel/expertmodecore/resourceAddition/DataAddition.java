package com.EmosewaPixel.expertmodecore.resourceAddition;

import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialsAndTextureTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class DataAddition {
    public static void register() {
        for (MaterialItem item : MaterialItems.materialItems)
            TagMaps.addItemToTag(item);
        for (MaterialItem item : MaterialBlocks.materialBlocks)
            TagMaps.addItemToTag(item);

        for (Material mat : MaterialsAndTextureTypes.materials) {
            if (mat.doesHaveBase() && mat instanceof IngotMaterial) {
                RecipeInjector.addShapedRecipe(mat.getName() + "_block", new ItemStack(MaterialBlocks.getBlock(mat, MaterialRegistry.BLOCK)), "III", "III", "III", 'I', Ingredient.fromTag(mat.getTag(MaterialRegistry.INGOT)));
                RecipeInjector.addShapelessRecipe(mat.getName() + "_ingot_from_block", new ItemStack(MaterialItems.getItem(mat, MaterialRegistry.INGOT), 9), Ingredient.fromTag(mat.getTag(MaterialRegistry.BLOCK)));
            }
        }
    }
}
