package com.EmosewaPixel.expertmodecore.jei.categories;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.recipes.MachineRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class MachineBaseCategory implements IRecipeCategory<MachineRecipe> {
    private String name;
    private IDrawable icon;
    protected IDrawable backGround;
    private Class<? extends MachineRecipe> recipeClass;

    public MachineBaseCategory(IGuiHelper helper, String name, Item icon, Class<? extends MachineRecipe> recipeClass) {
        this.name = name;
        this.icon = helper.createDrawableIngredient(new ItemStack(icon));
        this.recipeClass = recipeClass;
    }

    @Override
    public ResourceLocation getUid() {
        return new ResourceLocation(ExpertModeCore.ModId, name);
    }

    @Override
    public Class<? extends MachineRecipe> getRecipeClass() {
        return recipeClass;
    }

    @Override
    public String getTitle() {
        return Translator.translateToLocal("gui.jei.category." + name);
    }

    @Override
    public IDrawable getBackground() {
        return backGround;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }


    @Override
    public void setIngredients(MachineRecipe recipe, IIngredients ingredients) {
        ingredients.setInputLists(VanillaTypes.ITEM, recipe.getInputsAsList());
        ingredients.setOutputs(VanillaTypes.ITEM, recipe.getOutputsAsList());
    }
}
