package com.EmosewaPixel.expertmodecore.resourceAddition;

import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialsAndTextureTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DataAddition {
    public static void register() {
        for (Item item : MaterialItems.getMaterialItems())
            TagMaps.addItemToTag((IMaterialItem) item);
        for (Block block : MaterialBlocks.getMaterialBlocks())
            TagMaps.addItemToTag((IMaterialItem) block);

        for (Material mat : MaterialsAndTextureTypes.materials) {
            if (mat instanceof IngotMaterial) {
                if (MaterialBlocks.getBlock(mat, MaterialRegistry.BLOCK) instanceof IMaterialItem)
                    RecipeInjector.addShapedRecipe(mat.getName() + "_block", new ItemStack(MaterialBlocks.getBlock(mat, MaterialRegistry.BLOCK)), "III", "III", "III", 'I', mat.getTag(MaterialRegistry.INGOT));
                if (MaterialItems.getItem(mat, MaterialRegistry.INGOT) instanceof IMaterialItem) {
                    RecipeInjector.addShapelessRecipe(mat.getName() + "_ingot_from_block", mat.getName() + "_ingot", new ItemStack(MaterialItems.getItem(mat, MaterialRegistry.INGOT), 9), mat.getTag(MaterialRegistry.BLOCK));
                    RecipeInjector.addShapedRecipe(mat.getName() + "ingot_from_nuggets", mat.getName() + "_ingot", new ItemStack(MaterialItems.getItem(mat, MaterialRegistry.INGOT)), "NNN", "NNN", "NNN", 'N', mat.getTag(MaterialRegistry.NUGGET));
                }
                if (MaterialItems.getItem(mat, MaterialRegistry.NUGGET) instanceof IMaterialItem)
                    RecipeInjector.addShapelessRecipe(mat.getName() + "_nuggets", new ItemStack(MaterialItems.getItem(mat, MaterialRegistry.NUGGET), 9), mat.getTag(MaterialRegistry.INGOT));
                if (mat != MaterialRegistry.CRYSTALLINE) {
                    if (MaterialItems.getItem(mat, MaterialRegistry.INGOT) instanceof IMaterialItem)
                        RecipeInjector.addFurnaceRecipe(mat.getName() + "_ingot", mat.getTag(MaterialRegistry.DUST), new ItemStack(MaterialItems.getItem(mat, MaterialRegistry.INGOT)));
                    RecipeInjector.addShapedRecipe(mat.getName() + "_plate", new ItemStack(MaterialItems.getItem(mat, MaterialRegistry.PLATE)), "H", "I", 'H', MaterialRegistry.HAMMER.getTag(), 'I', mat.getTag(MaterialRegistry.INGOT));
                }
            }
        }
    }
}