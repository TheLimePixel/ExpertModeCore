package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeAddition {
    public static void registry() {
        RecipeTypes.addBlastFurnaceRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ItemRegistry.STEEL_INGOT));

        RecipeTypes.addAlloyerRecipe(new ItemStack(ItemRegistry.NETHERRACK_DUST), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(Items.NETHER_BRICK));
    }
}
