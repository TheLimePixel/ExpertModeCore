package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeTypes {
    public static ArrayList<MachineRecipe> alloyerRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> blastFurnaceRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> crusherRecipes = new ArrayList<>();

    public static void addAlloyerRecipe(Object input1, Object input2, ItemStack output, int time) {
        alloyerRecipes.add(new MachineRecipe(new Object[]{input1, input2}, new ItemStack[]{output}, time));
    }

    public static void addBlastFurnaceRecipe(ItemStack input, ItemStack output, int time) {
        blastFurnaceRecipes.add(new MachineRecipe(new ItemStack[]{input}, new ItemStack[]{output}, time));
    }

    public static void addCrusherRecipe(Object input, ItemStack output1, ItemStack output2, int time) {
        crusherRecipes.add(new MachineRecipe(new Object[]{input}, new ItemStack[]{output1, output2}, time));
    }

    public static void addCrusherRecipe(Object input, ItemStack output, int time) {
        crusherRecipes.add(new MachineRecipe(new Object[]{input}, new ItemStack[]{output}, time));
    }
}
