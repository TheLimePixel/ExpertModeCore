package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeTypes {
    public static ArrayList<MachineRecipe> alloyerRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> blastFurnaceRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> cokeOvenRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> crusherRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> infusionRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> pressingRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> sawmillRecipes = new ArrayList<>();


    public static class AlloyerRecipe extends MachineRecipe {
        public AlloyerRecipe(Object input1, Object input2, ItemStack output, int time) {
            super(new Object[]{input1, input2}, new ItemStack[]{output}, time);
            alloyerRecipes.add(this);
        }
    }

    public static class BlastFurnaceRecipe extends MachineRecipe {
        public BlastFurnaceRecipe(Object input, ItemStack output, int time) {
            super(new Object[]{input}, new ItemStack[]{output}, time);
            blastFurnaceRecipes.add(this);
        }
    }

    public static class CokeOvenRecipe extends MachineRecipe {
        public CokeOvenRecipe(Object input, ItemStack output, int time) {
            super(new Object[]{input}, new ItemStack[]{output}, time);
            cokeOvenRecipes.add(this);
        }
    }

    public static class CrusherRecipe extends MachineRecipe {
        public CrusherRecipe(Object input, ItemStack output, int time) {
            super(new Object[]{input}, new ItemStack[]{output}, time);
            crusherRecipes.add(this);
        }

        public CrusherRecipe(Object input, ItemStack output1, ItemStack output2, int time) {
            super(new Object[]{input}, new ItemStack[]{output1, output2}, time);
            crusherRecipes.add(this);
        }
    }

    public static class InfusionRecipe extends MachineRecipe {
        public InfusionRecipe(Object input1, Object input2, ItemStack output, int time) {
            super(new Object[]{input1, input2}, new ItemStack[]{output}, time);
            infusionRecipes.add(this);
        }
    }

    public static class PressingRecipe extends MachineRecipe {
        public PressingRecipe(Object input, ItemStack output) {
            super(new Object[]{input}, new ItemStack[]{output}, 0);
            pressingRecipes.add(this);
        }
    }

    public static class SawmillRecipe extends MachineRecipe {
        private boolean highSignal;

        public SawmillRecipe(Object input, ItemStack output, int time, boolean highSignal) {
            super(new Object[]{input}, new ItemStack[]{output}, time);
            sawmillRecipes.add(this);
            this.highSignal=highSignal;
        }

        public boolean inHighSignal() {
            return highSignal;
        }
    }
}
