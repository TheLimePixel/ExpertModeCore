package com.EmosewaPixel.expertmodecore.recipes;

import java.util.ArrayList;

public class RecipeTypes {
    public static ArrayList<MachineRecipe> alloyerRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> blastFurnaceRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> cokeOvenRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> crusherRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> explosionRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> infusionRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> pressingRecipes = new ArrayList<>();
    public static ArrayList<MachineRecipe> sawmillRecipes = new ArrayList<>();


    public static class AlloyerRecipe extends MachineRecipe {
        public AlloyerRecipe(Object input1, Object input2, Object output, int time) {
            super(new Object[]{input1, input2}, new Object[]{output}, time);
            alloyerRecipes.add(this);
        }
    }

    public static class BlastFurnaceRecipe extends MachineRecipe {
        public BlastFurnaceRecipe(Object input, Object output, int time) {
            super(new Object[]{input}, new Object[]{output}, time);
            blastFurnaceRecipes.add(this);
        }
    }

    public static class CokeOvenRecipe extends MachineRecipe {
        public CokeOvenRecipe(Object input, Object output, int time) {
            super(new Object[]{input}, new Object[]{output}, time);
            cokeOvenRecipes.add(this);
        }
    }

    public static class CrusherRecipe extends MachineRecipe {
        public CrusherRecipe(Object input, Object output, int time) {
            super(new Object[]{input}, new Object[]{output}, time);
            crusherRecipes.add(this);
        }

        public CrusherRecipe(Object input, Object output1, Object output2, int time) {
            super(new Object[]{input}, new Object[]{output1, output2}, time);
            crusherRecipes.add(this);
        }
    }

    public static class ExplosionRecipe extends MachineRecipe {
        public ExplosionRecipe(Object input, Object output) {
            super(new Object[]{input}, new Object[]{output}, 0);
            explosionRecipes.add(this);
        }
    }

    public static class InfusionRecipe extends MachineRecipe {
        public InfusionRecipe(Object input1, Object input2, Object output, int time) {
            super(new Object[]{input1, input2}, new Object[]{output}, time);
            infusionRecipes.add(this);
        }
    }

    public static class PressingRecipe extends MachineRecipe {
        public PressingRecipe(Object input, Object output) {
            super(new Object[]{input}, new Object[]{output}, 0);
            pressingRecipes.add(this);
        }
    }

    public static class SawmillRecipe extends MachineRecipe {
        private boolean highSignal;

        public SawmillRecipe(Object input, Object output, int time, boolean highSignal) {
            super(new Object[]{input}, new Object[]{output}, time);
            sawmillRecipes.add(this);
            this.highSignal = highSignal;
        }

        public boolean isHighSignal() {
            return highSignal;
        }
    }
}
