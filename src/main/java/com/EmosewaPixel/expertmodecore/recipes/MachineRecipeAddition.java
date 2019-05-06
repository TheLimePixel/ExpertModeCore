package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import com.EmosewaPixel.expertmodecore.materials.MaterialAddition;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.pixellib.materialSystem.lists.Materials;
import com.EmosewaPixel.pixellib.materialSystem.materials.GemMaterial;
import com.EmosewaPixel.pixellib.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.pixellib.materialSystem.materials.Material;
import com.EmosewaPixel.pixellib.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.pixellib.recipes.TagStack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class MachineRecipeAddition {
    public static void registry() {
        RecipeTypes.BLAST_FURNACE_RECIPES.recipeBuilder().input(new ItemStack(Items.IRON_INGOT)).output(new TagStack(INGOTS_STEEL)).time(300).buildAndRegister();
        RecipeTypes.BLAST_FURNACE_RECIPES.recipeBuilder().input(new ItemStack(Blocks.IRON_BLOCK)).output(new TagStack(BLOCKS_STEEL)).time(9 * 300).buildAndRegister();
        RecipeTypes.BLAST_FURNACE_RECIPES.recipeBuilder().input(new TagStack(PLATES_IRON)).output(new TagStack(DUSTS_STEEL)).time(300).buildAndRegister();

        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(DUSTS_NETHERRACK), new ItemStack(ItemRegistry.UNFIRED_BRICK)).output(new ItemStack(Items.NETHER_BRICK)).time(200).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(INGOTS_TIN), new TagStack(INGOTS_COPPER, 3)).output(new TagStack(INGOTS_BRONZE, 4)).time(200).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(DUSTS_TIN), new TagStack(DUSTS_COPPER, 3)).output(new TagStack(INGOTS_BRONZE, 4)).time(200).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(INGOTS_TIN), new TagStack(DUSTS_COPPER, 3)).output(new TagStack(INGOTS_BRONZE, 4)).time(200).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(DUSTS_TIN), new TagStack(INGOTS_COPPER, 3)).output(new TagStack(INGOTS_BRONZE, 4)).time(200).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(BLOCKS_TIN), new TagStack(BLOCKS_COPPER, 3)).output(new TagStack(BLOCKS_BRONZE, 4)).time(9 * 200).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(INGOTS_SILVER)).output(new TagStack(INGOTS_ELECTRUM, 2)).time(100).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(DUSTS_GOLD), new TagStack(DUSTS_SILVER)).output(new TagStack(INGOTS_ELECTRUM, 2)).time(100).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(DUSTS_SILVER)).output(new TagStack(INGOTS_ELECTRUM, 2)).time(100).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(DUSTS_GOLD), new TagStack(INGOTS_SILVER)).output(new TagStack(INGOTS_ELECTRUM, 2)).time(100).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.STORAGE_BLOCKS_GOLD), new TagStack(BLOCKS_SILVER)).output(new TagStack(BLOCKS_ELECTRUM, 2), 9 * 100).buildAndRegister();
        RecipeTypes.ALLOYER_RECIPES.recipeBuilder().input(new TagStack(ItemTags.SAND), new ItemStack(ItemRegistry.UNFIRED_BRICK)).output(new ItemStack(ItemRegistry.COKE_BRICK)).time(200).buildAndRegister();

        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new ItemStack(Items.BLAZE_ROD)).output(new ItemStack(Items.BLAZE_POWDER, 2)).time(100).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new ItemStack(Blocks.NETHERRACK)).output(new TagStack(DUSTS_NETHERRACK, 2)).time(150).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new ItemStack(Blocks.MAGMA_BLOCK)).output(new ItemStack(MAGMA_DUST, 2)).time(150).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.ORES_REDSTONE)).output(new ItemStack(Items.REDSTONE, 10), new TagStack(DUSTS_STONE)).time(200).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.ORES_LAPIS)).output(new ItemStack(Items.LAPIS_LAZULI, 14), new TagStack(DUSTS_STONE)).time(200).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.ORES_EMERALD)).output(new ItemStack(Items.EMERALD, 2), new TagStack(DUSTS_STONE)).time(200).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.ORES_DIAMOND)).output(new ItemStack(Items.DIAMOND, 2), new TagStack(DUSTS_STONE)).time(200).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.ORES_COAL)).output(new ItemStack(Items.COAL, 2), new TagStack(DUSTS_STONE)).time(200).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(Tags.Items.ORES_QUARTZ)).output(new ItemStack(Items.QUARTZ, 2), new TagStack(DUSTS_NETHERRACK)).time(200).buildAndRegister();
        RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new ItemStack(Items.PRISMARINE_SHARD)).output(new ItemStack(Items.PRISMARINE_CRYSTALS, 2)).time(150).buildAndRegister();

        RecipeTypes.INFUSION_RECIPES.recipeBuilder().input(new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.BLAZE_POWDER)).output(new ItemStack(Items.ENDER_EYE)).time(4000).buildAndRegister();
        RecipeTypes.INFUSION_RECIPES.recipeBuilder().input(new ItemStack(Items.APPLE), new TagStack(Tags.Items.INGOTS_GOLD, 8)).output(new ItemStack(Items.GOLDEN_APPLE)).time(5000).buildAndRegister();
        RecipeTypes.INFUSION_RECIPES.recipeBuilder().input(new ItemStack(Items.CARROT), new TagStack(Tags.Items.NUGGETS_GOLD, 8)).output(new ItemStack(Items.GOLDEN_CARROT)).time(3000).buildAndRegister();
        RecipeTypes.INFUSION_RECIPES.recipeBuilder().input(new ItemStack(Items.SLIME_BALL), new ItemStack(Items.BLAZE_POWDER)).output(new ItemStack(Items.MAGMA_CREAM)).time(2000).buildAndRegister();

        RecipeTypes.COKE_OVEN_RECIPES.recipeBuilder().input(new TagStack(ItemTags.LOGS)).output(new ItemStack(Items.CHARCOAL)).time(1800).buildAndRegister();
        RecipeTypes.COKE_OVEN_RECIPES.recipeBuilder().input(new ItemStack(Items.COAL)).output(new TagStack(MaterialAddition.COKE.getTag(MaterialRegistry.GEM))).time(1800).buildAndRegister();

        for (Material material : Materials.getAll()) {
            if (material instanceof GemMaterial) {
                RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(tag("gems/" + material.getName()))).output(new TagStack(tag("dusts/" + material.getName()))).time(150).buildAndRegister();
                RecipeTypes.EXPLOSION_RECIPES.recipeBuilder().input(new TagStack(tag("dusts/" + material.getName()))).output(new TagStack(tag("gems/" + material.getName()))).buildAndRegister();
            }
            if (material instanceof IngotMaterial) {
                RecipeTypes.PRESSING_RECIPES.recipeBuilder().input(new TagStack(tag("ingots/" + material.getName()))).output(new TagStack(tag("plates/" + material.getName()))).buildAndRegister();
                RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(tag("ingots/" + material.getName()))).output(new TagStack(tag("dusts/" + material.getName()))).time(150).buildAndRegister();
                RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(tag("plates/" + material.getName()))).output(new TagStack(tag("dusts/" + material.getName()))).time(150).buildAndRegister();
                if (material.doesHaveOre())
                    RecipeTypes.CRUSHER_RECIPES.recipeBuilder().input(new TagStack(tag("ores/" + material.getName()))).output(new TagStack(tag("dusts/" + material.getName()), 2), new TagStack(DUSTS_STONE).asItemStack()).time(200).buildAndRegister();
            }
        }

        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.IRONWOOD_PLANKS)).output(new ItemStack(ItemRegistry.IRONWOOD_STICK, 2)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.REDWOOD_PLANKS)).output(new ItemStack(ItemRegistry.REDWOOD_STICK, 2)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new TagStack(ItemTags.PLANKS)).output(new ItemStack(Items.STICK, 2)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.OAK_PLANKS)).output(new ItemStack(Blocks.OAK_SLAB, 2)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.BIRCH_PLANKS)).output(new ItemStack(Blocks.BIRCH_SLAB, 2)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.SPRUCE_PLANKS)).output(new ItemStack(Blocks.SPRUCE_SLAB, 2)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.JUNGLE_PLANKS)).output(new ItemStack(Blocks.JUNGLE_SLAB, 2)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.ACACIA_PLANKS)).output(new ItemStack(Blocks.ACACIA_SLAB, 2)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.DARK_OAK_PLANKS)).output(new ItemStack(Blocks.DARK_OAK_SLAB, 2)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.OAK_LOG)).output(new ItemStack(Blocks.OAK_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.BIRCH_LOG)).output(new ItemStack(Blocks.BIRCH_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.SPRUCE_LOG)).output(new ItemStack(Blocks.SPRUCE_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.JUNGLE_LOG)).output(new ItemStack(Blocks.JUNGLE_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.ACACIA_LOG)).output(new ItemStack(Blocks.ACACIA_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.DARK_OAK_LOG)).output(new ItemStack(Blocks.DARK_OAK_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.RUBBER_LOG)).output(new ItemStack(BlockRegistry.RUBBER_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.IRONWOOD_LOG)).output(new ItemStack(BlockRegistry.IRONWOOD_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.REDWOOD_LOG)).output(new ItemStack(BlockRegistry.REDWOOD_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.OAK_LOG)).output(new ItemStack(Blocks.STRIPPED_OAK_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.BIRCH_LOG)).output(new ItemStack(Blocks.STRIPPED_BIRCH_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.SPRUCE_LOG)).output(new ItemStack(Blocks.STRIPPED_SPRUCE_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.JUNGLE_LOG)).output(new ItemStack(Blocks.STRIPPED_JUNGLE_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.ACACIA_LOG)).output(new ItemStack(Blocks.STRIPPED_ACACIA_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.DARK_OAK_LOG)).output(new ItemStack(Blocks.STRIPPED_DARK_OAK_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.RUBBER_LOG)).output(new ItemStack(BlockRegistry.STRIPPED_RUBBER_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.IRONWOOD_LOG)).output(new ItemStack(BlockRegistry.STRIPPED_IRONWOOD_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.REDWOOD_LOG)).output(new ItemStack(BlockRegistry.STRIPPED_REDWOOD_LOG)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.OAK_WOOD)).output(new ItemStack(Blocks.OAK_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.BIRCH_WOOD)).output(new ItemStack(Blocks.BIRCH_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.SPRUCE_WOOD)).output(new ItemStack(Blocks.SPRUCE_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.JUNGLE_WOOD)).output(new ItemStack(Blocks.JUNGLE_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.ACACIA_WOOD)).output(new ItemStack(Blocks.ACACIA_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.DARK_OAK_WOOD)).output(new ItemStack(Blocks.DARK_OAK_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.RUBBER_WOOD)).output(new ItemStack(BlockRegistry.RUBBER_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.IRONWOOD_WOOD)).output(new ItemStack(BlockRegistry.IRONWOOD_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.REDWOOD_WOOD)).output(new ItemStack(BlockRegistry.REDWOOD_PLANKS, 4)).time(100).highSignal().buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.OAK_WOOD)).output(new ItemStack(Blocks.STRIPPED_OAK_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.BIRCH_WOOD)).output(new ItemStack(Blocks.STRIPPED_BIRCH_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.SPRUCE_WOOD)).output(new ItemStack(Blocks.STRIPPED_SPRUCE_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.JUNGLE_WOOD)).output(new ItemStack(Blocks.STRIPPED_JUNGLE_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.ACACIA_WOOD)).output(new ItemStack(Blocks.STRIPPED_ACACIA_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(Blocks.DARK_OAK_WOOD)).output(new ItemStack(Blocks.STRIPPED_DARK_OAK_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.RUBBER_WOOD)).output(new ItemStack(BlockRegistry.STRIPPED_RUBBER_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.IRONWOOD_WOOD)).output(new ItemStack(BlockRegistry.STRIPPED_IRONWOOD_WOOD)).time(200).buildAndRegister();
        RecipeTypes.SAWMILL_RECIPES.recipeBuilder().input(new ItemStack(BlockRegistry.REDWOOD_WOOD)).output(new ItemStack(BlockRegistry.STRIPPED_REDWOOD_WOOD)).time(200).buildAndRegister();

        RecipeTypes.EXPLOSION_RECIPES.recipeBuilder().input(new TagStack(DUSTS_CRYSTALLINE)).output(new TagStack(INGOTS_CRYSTALLINE)).buildAndRegister();

        RecipeTypes.blastFurnaceFuels.add(Items.CHARCOAL);
        RecipeTypes.blastFurnaceFuels.add(Items.COAL);
        RecipeTypes.blastFurnaceFuels.add(Blocks.COAL_BLOCK.asItem());
        RecipeTypes.blastFurnaceFuels.add(MaterialItems.getItem(MaterialAddition.COKE, MaterialRegistry.GEM));
        RecipeTypes.blastFurnaceFuels.add(MaterialBlocks.getBlock(MaterialAddition.COKE, MaterialRegistry.BLOCK).asItem());
    }

    public static final ItemTags.Wrapper BLOCKS_BRONZE = tag("blocks/bronze");
    public static final ItemTags.Wrapper INGOTS_BRONZE = tag("ingots/bronze");
    public static final ItemTags.Wrapper DUSTS_BRONZE = tag("dusts/bronze");
    public static final ItemTags.Wrapper BLOCKS_COPPER = tag("storage_blocks/copper");
    public static final ItemTags.Wrapper INGOTS_COPPER = tag("ingots/copper");
    public static final ItemTags.Wrapper DUSTS_COPPER = tag("dusts/copper");
    public static final ItemTags.Wrapper INGOTS_CRYSTALLINE = tag("ingots/crystalline");
    public static final ItemTags.Wrapper DUSTS_CRYSTALLINE = tag("dusts/crystalline");
    public static final ItemTags.Wrapper DUSTS_DIAMOND = tag("dusts/diamond");
    public static final ItemTags.Wrapper BLOCKS_ELECTRUM = tag("blocks/bronze");
    public static final ItemTags.Wrapper INGOTS_ELECTRUM = tag("ingots/electrum");
    public static final ItemTags.Wrapper DUSTS_ELECTRUM = tag("dusts/electrum");
    public static final ItemTags.Wrapper DUSTS_GOLD = tag("dusts/gold");
    public static final ItemTags.Wrapper PLATES_IRON = tag("plates/iron");
    public static final ItemTags.Wrapper DUSTS_LAPIS = tag("dusts/lapis");
    public static final ItemTags.Wrapper DUSTS_NETHERRACK = tag("dusts/netherrack");
    public static final ItemTags.Wrapper DUSTS_PRISMARINE = tag("dusts/prismarine");
    public static final ItemTags.Wrapper DUSTS_QUARTZ = tag("dusts/quartz");
    public static final ItemTags.Wrapper BLOCKS_SILVER = tag("storage_blocks/silver");
    public static final ItemTags.Wrapper INGOTS_SILVER = tag("ingots/silver");
    public static final ItemTags.Wrapper DUSTS_SILVER = tag("dusts/silver");
    public static final ItemTags.Wrapper BLOCKS_STEEL = tag("blocks/steel");
    public static final ItemTags.Wrapper INGOTS_STEEL = tag("ingots/steel");
    public static final ItemTags.Wrapper DUSTS_STEEL = tag("dusts/steel");
    public static final ItemTags.Wrapper DUSTS_STONE = tag("dusts/stone");
    public static final ItemTags.Wrapper BLOCKS_TIN = tag("storage_blocks/tin");
    public static final ItemTags.Wrapper INGOTS_TIN = tag("ingots/tin");
    public static final ItemTags.Wrapper DUSTS_TIN = tag("dusts/tin");

    public static final Item CHARRED_IRON_INGOT = MaterialItems.getItem(MaterialAddition.CHARRED_IRON, MaterialRegistry.INGOT);
    public static final Block COPPER_ORE = MaterialBlocks.getBlock(MaterialAddition.COPPER, MaterialRegistry.ORE);
    public static final Item MAGMA_DUST = MaterialItems.getItem(MaterialAddition.MAGMA, MaterialRegistry.DUST);
    public static final Block SILVER_ORE = MaterialBlocks.getBlock(MaterialAddition.SILVER, MaterialRegistry.ORE);
    public static final Block TIN_ORE = MaterialBlocks.getBlock(MaterialAddition.TIN, MaterialRegistry.ORE);

    private static ItemTags.Wrapper tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }
}