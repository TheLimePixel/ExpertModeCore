package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.pixellib.recipes.SimpleRecipeList;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class RecipeTypes {
    public static ArrayList<Item> blastFurnaceFuels = new ArrayList<>();

    public static SimpleRecipeList ALLOYER_RECIPES = new SimpleRecipeList(2, 1);
    public static SimpleRecipeList BLAST_FURNACE_RECIPES = new SimpleRecipeList(1, 1);
    public static SimpleRecipeList COKE_OVEN_RECIPES = new SimpleRecipeList(1, 1);
    public static SimpleRecipeList CRUSHER_RECIPES = new SimpleRecipeList(1, 2);
    public static SimpleRecipeList EXPLOSION_RECIPES = new SimpleRecipeList(1, 1);
    public static SimpleRecipeList INFUSION_RECIPES = new SimpleRecipeList(2, 1);
    public static SimpleRecipeList PRESSING_RECIPES = new SimpleRecipeList(1, 1);
    public static RedstoneBasedRecipeList SAWMILL_RECIPES = new RedstoneBasedRecipeList(1, 1);
}
