package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeAddition {
    public static void registry() {
        RecipeTypes.addBlastFurnaceRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ItemRegistry.STEEL_INGOT));

        RecipeTypes.addAlloyerRecipe(new ItemStack(ItemRegistry.NETHERRACK_DUST), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(Items.NETHER_BRICK));
        RecipeTypes.addAlloyerRecipe(new StringStack("ingots/tin"), new StringStack("ingots/copper", 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new StringStack("dusts/tin"), new StringStack("dusts/copper", 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new StringStack("ingots/tin"), new StringStack("dusts/copper", 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new StringStack("dusts/tin"), new StringStack("ingots/copper", 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new StringStack("ingots/gold"), new StringStack("ingots/silver"), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
        RecipeTypes.addAlloyerRecipe(new StringStack("dusts/gold"), new StringStack("dusts/silver"), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
        RecipeTypes.addAlloyerRecipe(new StringStack("ingots/gold"), new StringStack("dusts/silver"), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
        RecipeTypes.addAlloyerRecipe(new StringStack("dusts/gold"), new StringStack("ingots/silver"), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
    }
}