package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.pixellib.recipes.SimpleRecipeList;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class RecipeTypes {
    public static ArrayList<Item> blastFurnaceFuels = new ArrayList<>();

    public static SimpleRecipeList ALLOYER_RECIPES = new SimpleRecipeList(location("alloy_smelter"), 2, 1);
    public static SimpleRecipeList BLAST_FURNACE_RECIPES = new SimpleRecipeList(location("blast_furnace"), 1, 1);
    public static SimpleRecipeList COKE_OVEN_RECIPES = new SimpleRecipeList(location("coke_oven"), 1, 1);
    public static SimpleRecipeList CRUSHER_RECIPES = new SimpleRecipeList(location("crusher"), 1, 2);
    public static SimpleRecipeList EXPLOSION_RECIPES = new SimpleRecipeList(location("explosion"), 1, 1);
    public static SimpleRecipeList INFUSION_RECIPES = new SimpleRecipeList(location("infusion"), 2, 1);
    public static SimpleRecipeList PRESSING_RECIPES = new SimpleRecipeList(location("pressing"), 1, 1);
    public static RedstoneBasedRecipeList SAWMILL_RECIPES = new RedstoneBasedRecipeList(location("sawmill"), 1, 1);

    private static ResourceLocation location(String name) {
        return new ResourceLocation("expertmodecore", name);
    }
}