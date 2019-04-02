package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeTypes {
    public static ArrayList<MachineRecipe> blastFurnaceRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> alloyerRecipes = new ArrayList<>();

    public static void addBlastFurnaceRecipe(ItemStack input, ItemStack output) {
        blastFurnaceRecipes.add(new MachineRecipe(new ItemStack[]{input}, output));
    }

    public static void addAlloyerRecipe(ItemStack input1, ItemStack input2, ItemStack output) {
        alloyerRecipes.add(new MachineRecipe(new ItemStack[]{input1, input2}, output));
    }
}
