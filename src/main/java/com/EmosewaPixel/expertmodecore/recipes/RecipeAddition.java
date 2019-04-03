package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class RecipeAddition {
    public static void registry() {
        RecipeTypes.addBlastFurnaceRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ItemRegistry.STEEL_INGOT));

        RecipeTypes.addAlloyerRecipe(new ItemStack(ItemRegistry.NETHERRACK_DUST), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(Items.NETHER_BRICK));
        RecipeTypes.addAlloyerRecipe(new TagStack(INGOT_TIN), new TagStack(INGOT_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_TIN), new TagStack(DUST_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new TagStack(INGOT_TIN), new TagStack(DUST_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_TIN), new TagStack(INGOT_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4));
        RecipeTypes.addAlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(INGOT_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_GOLD), new TagStack(DUST_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
        RecipeTypes.addAlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(DUST_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_GOLD), new TagStack(INGOT_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2));
    }

    private static final ItemTags.Wrapper INGOT_TIN = tag("ingots/tin");
    private static final ItemTags.Wrapper DUST_TIN = tag("dusts/tin");
    private static final ItemTags.Wrapper INGOT_COPPER = tag("ingots/copper");
    private static final ItemTags.Wrapper DUST_COPPER = tag("dusts/copper");
    private static final ItemTags.Wrapper INGOT_SILVER = tag("ingots/silver");
    private static final ItemTags.Wrapper DUST_SILVER = tag("dusts/silver");
    private static final ItemTags.Wrapper DUST_GOLD = tag("dusts/gold");

    private static ItemTags.Wrapper tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }
}