package com.EmosewaPixel.expertmodecore.resourceAddition;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeInjector {
    private RecipeManager recipeManager;

    public RecipeInjector(RecipeManager manager) {
        recipeManager = manager;
    }


    private static ArrayList<IRecipe> RECIPES = new ArrayList<>();

    public void injectRecipes(IResourceManager manager) {
        for (IRecipe recipe : RECIPES)
            recipeManager.addRecipe(recipe);
    }

    public static void addShapelessRecipe(ResourceLocation name, ItemStack output, @Nonnull Ingredient... inputs) {
        NonNullList<Ingredient> input = NonNullList.create();
        for (Ingredient ingredient : inputs)
            input.add(ingredient);

        RECIPES.add(new ShapelessRecipe(name, "", output, input));
    }

    public static void addShapelessRecipe(String name, ItemStack output, @Nonnull Ingredient... inputs) {
        addShapelessRecipe(new ResourceLocation("expertmodecore", name), output, inputs);
    }

    public static void addShapedRecipe(ResourceLocation name, ItemStack output, @Nonnull Object... shape) {
        int height = 0;
        int width = 0;
        HashMap<Character, Ingredient> ingredients = new HashMap<>();
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < shape.length; i++) {
            if (shape[i] instanceof String) {
                height++;
                if (((String) shape[i]).length() > width)
                    width = ((String) shape[i]).length();
                for (Character character : ((String) shape[i]).toCharArray())
                    charList.add(character);
            }
            if (shape[i] instanceof Character && shape[i + 1] instanceof Ingredient) {
                ingredients.put((char) shape[i], (Ingredient) shape[i + 1]);
                i++;
            }
        }
        ingredients.put(' ', Ingredient.EMPTY);
        ;
        if (height > 3 || width > 3)
            return;
        NonNullList<Ingredient> inputs = NonNullList.create();
        for (Character character : charList) {
            for (Map.Entry<Character, Ingredient> entry : ingredients.entrySet())
                if (character == entry.getKey()) {
                    inputs.add(entry.getValue());
                    break;
                }
        }

        RECIPES.add(new ShapedRecipe(name, "", width, height, inputs, output));
    }

    public static void addShapedRecipe(String name, ItemStack output, @Nonnull Object... shape) {
        addShapedRecipe(new ResourceLocation("expertmodecore", name), output, shape);
    }
}
