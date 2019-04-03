package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class RecipeAddition {
    public static void registry() {
        RecipeTypes.addBlastFurnaceRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ItemRegistry.STEEL_INGOT), 300);
        RecipeTypes.addBlastFurnaceRecipe(new ItemStack(Blocks.IRON_BLOCK), new ItemStack(BlockRegistry.STEEL_BLOCK), 9 * 300);

        RecipeTypes.addAlloyerRecipe(new ItemStack(ItemRegistry.NETHERRACK_DUST), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(Items.NETHER_BRICK), 200);
        RecipeTypes.addAlloyerRecipe(new TagStack(INGOT_TIN), new TagStack(INGOT_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_TIN), new TagStack(DUST_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        RecipeTypes.addAlloyerRecipe(new TagStack(INGOT_TIN), new TagStack(DUST_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_TIN), new TagStack(INGOT_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        RecipeTypes.addAlloyerRecipe(new TagStack(BLOCK_TIN), new TagStack(BLOCK_COPPER, 3), new ItemStack(BlockRegistry.BRONZER_BLOCK, 4), 9 * 200);

        RecipeTypes.addAlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(INGOT_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_GOLD), new TagStack(DUST_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        RecipeTypes.addAlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(DUST_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        RecipeTypes.addAlloyerRecipe(new TagStack(DUST_GOLD), new TagStack(INGOT_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        RecipeTypes.addAlloyerRecipe(new TagStack(Tags.Items.STORAGE_BLOCKS_GOLD), new TagStack(BLOCK_SILVER), new ItemStack(BlockRegistry.ELECTRUM_BLOCK, 2), 9 * 100);
    }

    private static final ItemTags.Wrapper BLOCK_TIN = tag("storage_blocks/tin");
    private static final ItemTags.Wrapper INGOT_TIN = tag("ingots/tin");
    private static final ItemTags.Wrapper DUST_TIN = tag("dusts/tin");
    private static final ItemTags.Wrapper BLOCK_COPPER = tag("storage_blocks/copper");
    private static final ItemTags.Wrapper INGOT_COPPER = tag("ingots/copper");
    private static final ItemTags.Wrapper DUST_COPPER = tag("dusts/copper");
    private static final ItemTags.Wrapper BLOCK_SILVER = tag("storage_blocks/silver");
    private static final ItemTags.Wrapper INGOT_SILVER = tag("ingots/silver");
    private static final ItemTags.Wrapper DUST_SILVER = tag("dusts/silver");
    private static final ItemTags.Wrapper DUST_GOLD = tag("dusts/gold");

    private static ItemTags.Wrapper tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }
}