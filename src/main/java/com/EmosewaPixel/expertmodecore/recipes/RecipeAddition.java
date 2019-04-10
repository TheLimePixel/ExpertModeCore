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
        new RecipeTypes.BlastFurnaceRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ItemRegistry.STEEL_INGOT), 300);
        new RecipeTypes.BlastFurnaceRecipe(new ItemStack(Blocks.IRON_BLOCK), new ItemStack(BlockRegistry.STEEL_BLOCK), 9 * 300);
        new RecipeTypes.BlastFurnaceRecipe(new TagStack(PLATES_IRON), new ItemStack(ItemRegistry.STEEL_PLATE), 300);

        new RecipeTypes.AlloyerRecipe(new ItemStack(ItemRegistry.NETHERRACK_DUST), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(Items.NETHER_BRICK), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(INGOTS_TIN), new TagStack(INGOTS_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_TIN), new TagStack(DUSTS_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(INGOTS_TIN), new TagStack(DUSTS_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_TIN), new TagStack(INGOTS_COPPER, 3), new ItemStack(ItemRegistry.BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(BLOCKS_TIN), new TagStack(BLOCKS_COPPER, 3), new ItemStack(BlockRegistry.BRONZER_BLOCK, 4), 9 * 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(INGOTS_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_GOLD), new TagStack(DUSTS_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(DUSTS_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_GOLD), new TagStack(INGOTS_SILVER), new ItemStack(ItemRegistry.ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(Tags.Items.STORAGE_BLOCKS_GOLD), new TagStack(BLOCKS_SILVER), new ItemStack(BlockRegistry.ELECTRUM_BLOCK, 2), 9 * 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(ItemTags.SAND), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(ItemRegistry.COKE_BRICK), 200);

        new RecipeTypes.CrusherRecipe(new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_POWDER, 2), 100);
        new RecipeTypes.CrusherRecipe(new ItemStack(Blocks.NETHERRACK), new ItemStack(ItemRegistry.NETHERRACK_DUST, 2), 150);
        new RecipeTypes.CrusherRecipe(new ItemStack(Blocks.MAGMA_BLOCK), new ItemStack(ItemRegistry.CRUSHED_MAGMA_BLOCK, 2), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_IRON), new ItemStack(ItemRegistry.IRON_DUST, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_GOLD), new ItemStack(ItemRegistry.GOLD_DUST, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_REDSTONE), new ItemStack(Items.REDSTONE, 10), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_LAPIS), new ItemStack(Items.LAPIS_LAZULI, 14), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_EMERALD), new ItemStack(Items.EMERALD, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_DIAMOND), new ItemStack(Items.DIAMOND, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_COAL), new ItemStack(Items.COAL, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(ORES_COPPER), new ItemStack(ItemRegistry.COPPER_DUST, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(ORES_SILVER), new ItemStack(ItemRegistry.SILVER_DUST, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(ORES_TIN), new ItemStack(ItemRegistry.TIN_DUST, 2), new ItemStack(ItemRegistry.STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_QUARTZ), new ItemStack(Items.QUARTZ, 2), new ItemStack(ItemRegistry.NETHERRACK_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.INGOTS_IRON), new ItemStack(ItemRegistry.IRON_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new ItemStack(ItemRegistry.GOLD_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(INGOTS_BRONZE), new ItemStack(ItemRegistry.BRONZE_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(INGOTS_COPPER), new ItemStack(ItemRegistry.COPPER_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(INGOTS_ELECTRUM), new ItemStack(ItemRegistry.ELECTRUM_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(INGOTS_SILVER), new ItemStack(ItemRegistry.SILVER_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(INGOTS_STEEL), new ItemStack(ItemRegistry.STEEl_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(INGOTS_TIN), new ItemStack(ItemRegistry.TIN_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_IRON), new ItemStack(ItemRegistry.IRON_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_GOLD), new ItemStack(ItemRegistry.GOLD_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_BRONZE), new ItemStack(ItemRegistry.BRONZE_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_COPPER), new ItemStack(ItemRegistry.COPPER_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_ELECTRUM), new ItemStack(ItemRegistry.ELECTRUM_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_SILVER), new ItemStack(ItemRegistry.SILVER_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_STEEL), new ItemStack(ItemRegistry.STEEl_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(PLATES_TIN), new ItemStack(ItemRegistry.TIN_DUST), 150);

        new RecipeTypes.InfusionRecipe(new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.ENDER_EYE), 4000);
        new RecipeTypes.InfusionRecipe(new ItemStack(Items.APPLE), new TagStack(Tags.Items.INGOTS_GOLD, 8), new ItemStack(Items.GOLDEN_APPLE), 5000);
        new RecipeTypes.InfusionRecipe(new ItemStack(Items.CARROT), new TagStack(Tags.Items.NUGGETS_GOLD, 8), new ItemStack(Items.GOLDEN_CARROT), 3000);
        new RecipeTypes.InfusionRecipe(new ItemStack(Items.SLIME_BALL), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.MAGMA_CREAM), 2000);

        new RecipeTypes.CokeOvenRecipe(new TagStack(ItemTags.LOGS), new ItemStack(Items.CHARCOAL), 1800);
        new RecipeTypes.CokeOvenRecipe(new ItemStack(Items.COAL), new ItemStack(ItemRegistry.COKE_COKE), 1800);

        new RecipeTypes.PressingRecipe(new TagStack(Tags.Items.INGOTS_IRON), new ItemStack(ItemRegistry.IRON_PLATE));
        new RecipeTypes.PressingRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new ItemStack(ItemRegistry.GOLD_PLATE));
        new RecipeTypes.PressingRecipe(new TagStack(INGOTS_BRONZE), new ItemStack(ItemRegistry.BRONZE_PLATE));
        new RecipeTypes.PressingRecipe(new TagStack(INGOTS_COPPER), new ItemStack(ItemRegistry.COPPER_PLATE));
        new RecipeTypes.PressingRecipe(new TagStack(INGOTS_ELECTRUM), new ItemStack(ItemRegistry.ELECTRUM_PLATE));
        new RecipeTypes.PressingRecipe(new TagStack(INGOTS_SILVER), new ItemStack(ItemRegistry.SILVER_PLATE));
        new RecipeTypes.PressingRecipe(new TagStack(INGOTS_STEEL), new ItemStack(ItemRegistry.STEEL_PLATE));
        new RecipeTypes.PressingRecipe(new TagStack(INGOTS_TIN), new ItemStack(ItemRegistry.TIN_PLATE));
        new RecipeTypes.PressingRecipe(new ItemStack(ItemRegistry.CHARRED_IRON_INGOT), new ItemStack(ItemRegistry.CHARRED_IRON_PLATE));
    }

    public static final ItemTags.Wrapper INGOTS_BRONZE = tag("ingots/bronze");
    public static final ItemTags.Wrapper DUSTS_BRONZE = tag("dusts/bronze");
    public static final ItemTags.Wrapper BLOCKS_COPPER = tag("storage_blocks/copper");
    public static final ItemTags.Wrapper PLATES_BRONZE = tag("plates/bronze");
    public static final ItemTags.Wrapper INGOTS_COPPER = tag("ingots/copper");
    public static final ItemTags.Wrapper DUSTS_COPPER = tag("dusts/copper");
    public static final ItemTags.Wrapper ORES_COPPER = tag("ores/copper");
    public static final ItemTags.Wrapper PLATES_COPPER = tag("plates/copper");
    public static final ItemTags.Wrapper INGOTS_ELECTRUM = tag("ingots/electrum");
    public static final ItemTags.Wrapper DUSTS_ELECTRUM = tag("dusts/electrum");
    public static final ItemTags.Wrapper PLATES_ELECTRUM = tag("plates/electrum");
    public static final ItemTags.Wrapper DUSTS_GOLD = tag("dusts/gold");
    public static final ItemTags.Wrapper PLATES_GOLD = tag("plates/gold");
    public static final ItemTags.Wrapper PLATES_IRON = tag("plates/iron");
    public static final ItemTags.Wrapper BLOCKS_SILVER = tag("storage_blocks/silver");
    public static final ItemTags.Wrapper INGOTS_SILVER = tag("ingots/silver");
    public static final ItemTags.Wrapper DUSTS_SILVER = tag("dusts/silver");
    public static final ItemTags.Wrapper ORES_SILVER = tag("ores/silver");
    public static final ItemTags.Wrapper PLATES_SILVER = tag("plates/silver");
    public static final ItemTags.Wrapper INGOTS_STEEL = tag("ingots/steel");
    public static final ItemTags.Wrapper DUSTS_STEEL = tag("dusts/steel");
    public static final ItemTags.Wrapper PLATES_STEEL = tag("plates/steel");
    public static final ItemTags.Wrapper BLOCKS_TIN = tag("storage_blocks/tin");
    public static final ItemTags.Wrapper INGOTS_TIN = tag("ingots/tin");
    public static final ItemTags.Wrapper DUSTS_TIN = tag("dusts/tin");
    public static final ItemTags.Wrapper ORES_TIN = tag("ores/tin");
    public static final ItemTags.Wrapper PLATES_TIN = tag("plates/tin");

    private static ItemTags.Wrapper tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }
}