package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeTypes {
    public static ArrayList<MachineRecipe> blastFurnaceRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> alloyerRecipes = new ArrayList<>();

    public static void addBlastFurnaceRecipe(ItemStack input, ItemStack output, int time) {
        blastFurnaceRecipes.add(new MachineRecipe(new ItemStack[]{input}, output, time));
    }

    public static void addAlloyerRecipe(Object input1, Object input2, ItemStack output, int time) {
        alloyerRecipes.add(new MachineRecipe(new Object[]{input1, input2}, output, time));
    }
}
