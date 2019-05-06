package com.EmosewaPixel.expertmodecore.jei;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.jei.categories.*;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIPlugIn implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ExpertModeCore.ModId);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration reg) {
        IGuiHelper helper = reg.getJeiHelpers().getGuiHelper();
        reg.addRecipeCategories(new AlloyerCategory(helper), new BlastFurnaceCategory(helper), new CokeOvenCategory(helper), new CrusherCategory(helper), new InfusionCategory(helper), new PressingCategory(helper), new SawmillCategory(helper));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration reg) {
        reg.addRecipeCatalyst(new ItemStack(BlockRegistry.ALLOYER), new ResourceLocation("expertmodecore:alloyer"));
        reg.addRecipeCatalyst(new ItemStack(BlockRegistry.BLAST_FURNACE), new ResourceLocation("expertmodecore:blast_furnace"));
        reg.addRecipeCatalyst(new ItemStack(BlockRegistry.COKE_OVEN), new ResourceLocation("expertmodecore:coke_oven"));
        reg.addRecipeCatalyst(new ItemStack(BlockRegistry.CRUSHER), new ResourceLocation("expertmodecore:crusher"));
        reg.addRecipeCatalyst(new ItemStack(BlockRegistry.INFUSION_TABLE), new ResourceLocation("expertmodecore:infusion"));
        reg.addRecipeCatalyst(new ItemStack(Blocks.PISTON), new ResourceLocation("expertmodecore:pressing"));
        reg.addRecipeCatalyst(new ItemStack(BlockRegistry.SAWMILL), new ResourceLocation("expertmodecore:sawmill"));
    }

    @Override
    public void registerRecipes(IRecipeRegistration reg) {
        reg.addRecipes(RecipeTypes.ALLOYER_RECIPES.getReipes(), new ResourceLocation("expertmodecore:alloyer"));
        reg.addRecipes(RecipeTypes.BLAST_FURNACE_RECIPES.getReipes(), new ResourceLocation("expertmodecore:blast_furnace"));
        reg.addRecipes(RecipeTypes.COKE_OVEN_RECIPES.getReipes(), new ResourceLocation("expertmodecore:coke_oven"));
        reg.addRecipes(RecipeTypes.CRUSHER_RECIPES.getReipes(), new ResourceLocation("expertmodecore:crusher"));
        reg.addRecipes(RecipeTypes.INFUSION_RECIPES.getReipes(), new ResourceLocation("expertmodecore:infusion"));
        reg.addRecipes(RecipeTypes.PRESSING_RECIPES.getReipes(), new ResourceLocation("expertmodecore:pressing"));
        reg.addRecipes(RecipeTypes.SAWMILL_RECIPES.getReipes(), new ResourceLocation("expertmodecore:sawmill"));
    }
}