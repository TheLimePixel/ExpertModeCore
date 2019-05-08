package com.EmosewaPixel.expertmodecore.jei.categories;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.pixellib.jei.MachineBaseCategory;
import com.EmosewaPixel.pixellib.recipes.SimpleMachineRecipe;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class AlloyerCategory extends MachineBaseCategory {
    public AlloyerCategory(IGuiHelper helper) {
        super(helper, "expertmodecore:alloyer", BlockRegistry.ALLOYER.asItem());
        this.backGround = helper.createDrawable(new ResourceLocation("expertmodecore:textures/gui/container/alloyer.png"), 37, 16, 100, 54);
    }

    @Override
    public void setRecipe(IRecipeLayout layout, SimpleMachineRecipe recipe, IIngredients ingredients) {
        List<List<ItemStack>> inputs = recipe.getInputsAsList();
        List<ItemStack> outputs = recipe.getOutputsAsList();

        layout.getItemStacks().init(0, true, 0, 0);
        layout.getItemStacks().set(0, inputs.get(0));

        layout.getItemStacks().init(1, true, 18, 0);
        layout.getItemStacks().set(1, inputs.get(1));

        layout.getItemStacks().init(2, false, 78, 18);
        layout.getItemStacks().set(2, outputs.get(0));
    }

    @Override
    public void draw(SimpleMachineRecipe recipe, double mouseX, double mouseY) {
        arrow.draw(42, 18);
        flame.draw(10, 20);
    }

    @Override
    public Class<? extends SimpleMachineRecipe> getRecipeClass() {
        return recipeClass.class;
    }

    public static class recipeClass extends SimpleMachineRecipe {
        public recipeClass(Object[] input, Object[] output, int time) {
            super(input, output, time);
        }
    }
}