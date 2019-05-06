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

public class CokeOvenCategory extends MachineBaseCategory {
    public CokeOvenCategory(IGuiHelper helper) {
        super(helper, "coke_oven", BlockRegistry.COKE_OVEN.asItem());
        this.backGround = helper.createDrawable(new ResourceLocation("expertmodecore:textures/gui/jei/coke_oven.png"), 0, 0, 106, 54);
    }

    @Override
    public void setRecipe(IRecipeLayout layout, SimpleMachineRecipe recipe, IIngredients ingredients) {
        List<List<ItemStack>> inputs = recipe.getInputsAsList();
        List<ItemStack> outputs = recipe.getOutputsAsList();

        layout.getItemStacks().init(0, true, 0, 0);
        layout.getItemStacks().set(0, inputs.get(0));

        layout.getItemStacks().init(1, false, 60, 18);
        layout.getItemStacks().set(1, outputs.get(0));
    }

    @Override
    public void draw(SimpleMachineRecipe recipe, double mouseX, double mouseY) {
        arrow.draw(24, 18);
        flame.draw(1, 20);
    }
}