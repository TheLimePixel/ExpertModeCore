package com.EmosewaPixel.expertmodecore.recipes;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialsAndTextureTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class RecipeAddition {
    public static void registry() {
        new RecipeTypes.BlastFurnaceRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(STEEL_INGOT), 300);
        new RecipeTypes.BlastFurnaceRecipe(new ItemStack(Blocks.IRON_BLOCK), new ItemStack(STEEL_BLOCK), 9 * 300);
        new RecipeTypes.BlastFurnaceRecipe(new TagStack(PLATES_IRON), new ItemStack(STEEL_DUST), 300);

        new RecipeTypes.AlloyerRecipe(new ItemStack(NETHERRACK_DUST), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(Items.NETHER_BRICK), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(INGOTS_TIN), new TagStack(INGOTS_COPPER, 3), new ItemStack(BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_TIN), new TagStack(DUSTS_COPPER, 3), new ItemStack(BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(INGOTS_TIN), new TagStack(DUSTS_COPPER, 3), new ItemStack(BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_TIN), new TagStack(INGOTS_COPPER, 3), new ItemStack(BRONZE_INGOT, 4), 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(BLOCKS_TIN), new TagStack(BLOCKS_COPPER, 3), new ItemStack(BRONZE_BLOCK, 4), 9 * 200);
        new RecipeTypes.AlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(INGOTS_SILVER), new ItemStack(ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_GOLD), new TagStack(DUSTS_SILVER), new ItemStack(ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(Tags.Items.INGOTS_GOLD), new TagStack(DUSTS_SILVER), new ItemStack(ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(DUSTS_GOLD), new TagStack(INGOTS_SILVER), new ItemStack(ELECTRUM_INGOT, 2), 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(Tags.Items.STORAGE_BLOCKS_GOLD), new TagStack(BLOCKS_SILVER), new ItemStack(ELECTRUM_BLOCK, 2), 9 * 100);
        new RecipeTypes.AlloyerRecipe(new TagStack(ItemTags.SAND), new ItemStack(ItemRegistry.UNFIRED_BRICK), new ItemStack(ItemRegistry.COKE_BRICK), 200);

        new RecipeTypes.CrusherRecipe(new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_POWDER, 2), 100);
        new RecipeTypes.CrusherRecipe(new ItemStack(Blocks.NETHERRACK), new ItemStack(NETHERRACK_DUST, 2), 150);
        new RecipeTypes.CrusherRecipe(new ItemStack(Blocks.MAGMA_BLOCK), new ItemStack(MAGMA_DUST, 2), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_REDSTONE), new ItemStack(Items.REDSTONE, 10), new ItemStack(STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_LAPIS), new ItemStack(Items.LAPIS_LAZULI, 14), new ItemStack(STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_EMERALD), new ItemStack(Items.EMERALD, 2), new ItemStack(STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_DIAMOND), new ItemStack(Items.DIAMOND, 2), new ItemStack(STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_COAL), new ItemStack(Items.COAL, 2), new ItemStack(STONE_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.ORES_QUARTZ), new ItemStack(Items.QUARTZ, 2), new ItemStack(NETHERRACK_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.GEMS_LAPIS), new ItemStack(LAPIS_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.GEMS_DIAMOND), new ItemStack(DIAMOND_DUST), 200);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.GEMS_PRISMARINE), new ItemStack(PRISMARINE_DUST), 150);
        new RecipeTypes.CrusherRecipe(new TagStack(Tags.Items.GEMS_QUARRTZ), new ItemStack(QUARTZ_DUST), 150);
        new RecipeTypes.CrusherRecipe(new ItemStack(Items.PRISMARINE_SHARD), new ItemStack(Items.PRISMARINE_CRYSTALS, 2), 150);

        new RecipeTypes.InfusionRecipe(new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.ENDER_EYE), 4000);
        new RecipeTypes.InfusionRecipe(new ItemStack(Items.APPLE), new TagStack(Tags.Items.INGOTS_GOLD, 8), new ItemStack(Items.GOLDEN_APPLE), 5000);
        new RecipeTypes.InfusionRecipe(new ItemStack(Items.CARROT), new TagStack(Tags.Items.NUGGETS_GOLD, 8), new ItemStack(Items.GOLDEN_CARROT), 3000);
        new RecipeTypes.InfusionRecipe(new ItemStack(Items.SLIME_BALL), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.MAGMA_CREAM), 2000);

        new RecipeTypes.CokeOvenRecipe(new TagStack(ItemTags.LOGS), new ItemStack(Items.CHARCOAL), 1800);
        new RecipeTypes.CokeOvenRecipe(new ItemStack(Items.COAL), new ItemStack(ItemRegistry.COAL_COKE), 1800);

        for (Material material : MaterialsAndTextureTypes.materials)
            if (material instanceof IngotMaterial) {
                new RecipeTypes.PressingRecipe(new TagStack(tag("ingots/" + material.getName())), new ItemStack(MaterialItems.getItem(material, MaterialRegistry.PLATE)));
                new RecipeTypes.CrusherRecipe(new TagStack(tag("ingots/" + material.getName())), new ItemStack(MaterialItems.getItem(material, MaterialRegistry.DUST)), 150);
                new RecipeTypes.CrusherRecipe(new TagStack(tag("plates/" + material.getName())), new ItemStack(MaterialItems.getItem(material, MaterialRegistry.DUST)), 150);
                if (material.doesHaveOre())
                    new RecipeTypes.CrusherRecipe(new TagStack(tag("ores/" + material.getName())), new ItemStack(MaterialItems.getItem(material, MaterialRegistry.DUST), 2), new ItemStack(STONE_DUST), 200);
            }

        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.IRONWOOD_PLANKS), new ItemStack(ItemRegistry.IRONWOOD_STICK, 2), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.REDWOOD_PLANKS), new ItemStack(ItemRegistry.REDWOOD_STICK, 2), 100, true);
        new RecipeTypes.SawmillRecipe(new TagStack(ItemTags.PLANKS), new ItemStack(Items.STICK, 2), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.OAK_PLANKS), new ItemStack(Blocks.OAK_SLAB, 2), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.BIRCH_PLANKS), new ItemStack(Blocks.BIRCH_SLAB, 2), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.SPRUCE_PLANKS), new ItemStack(Blocks.SPRUCE_SLAB, 2), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.JUNGLE_PLANKS), new ItemStack(Blocks.JUNGLE_SLAB, 2), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.ACACIA_PLANKS), new ItemStack(Blocks.ACACIA_SLAB, 2), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.DARK_OAK_PLANKS), new ItemStack(Blocks.DARK_OAK_SLAB, 2), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.OAK_LOG), new ItemStack(Blocks.OAK_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.BIRCH_LOG), new ItemStack(Blocks.BIRCH_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.SPRUCE_LOG), new ItemStack(Blocks.SPRUCE_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.JUNGLE_LOG), new ItemStack(Blocks.JUNGLE_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.ACACIA_LOG), new ItemStack(Blocks.ACACIA_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.DARK_OAK_LOG), new ItemStack(Blocks.DARK_OAK_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.RUBBER_LOG), new ItemStack(BlockRegistry.RUBBER_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.IRONWOOD_LOG), new ItemStack(BlockRegistry.IRONWOOD_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.REDWOOD_LOG), new ItemStack(BlockRegistry.REDWOOD_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.OAK_LOG), new ItemStack(Blocks.STRIPPED_OAK_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.BIRCH_LOG), new ItemStack(Blocks.STRIPPED_BIRCH_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.SPRUCE_LOG), new ItemStack(Blocks.STRIPPED_SPRUCE_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.JUNGLE_LOG), new ItemStack(Blocks.STRIPPED_JUNGLE_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.ACACIA_LOG), new ItemStack(Blocks.STRIPPED_ACACIA_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.DARK_OAK_LOG), new ItemStack(Blocks.STRIPPED_DARK_OAK_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.RUBBER_LOG), new ItemStack(BlockRegistry.STRIPPED_RUBBER_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.IRONWOOD_LOG), new ItemStack(BlockRegistry.STRIPPED_IRONWOOD_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.REDWOOD_LOG), new ItemStack(BlockRegistry.STRIPPED_REDWOOD_LOG), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.OAK_WOOD), new ItemStack(Blocks.OAK_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.BIRCH_WOOD), new ItemStack(Blocks.BIRCH_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.SPRUCE_WOOD), new ItemStack(Blocks.SPRUCE_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.JUNGLE_WOOD), new ItemStack(Blocks.JUNGLE_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.ACACIA_WOOD), new ItemStack(Blocks.ACACIA_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.DARK_OAK_WOOD), new ItemStack(Blocks.DARK_OAK_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.RUBBER_WOOD), new ItemStack(BlockRegistry.RUBBER_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.IRONWOOD_WOOD), new ItemStack(BlockRegistry.IRONWOOD_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.REDWOOD_WOOD), new ItemStack(BlockRegistry.REDWOOD_PLANKS, 4), 100, true);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.OAK_WOOD), new ItemStack(Blocks.STRIPPED_OAK_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.BIRCH_WOOD), new ItemStack(Blocks.STRIPPED_BIRCH_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.SPRUCE_WOOD), new ItemStack(Blocks.STRIPPED_SPRUCE_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.JUNGLE_WOOD), new ItemStack(Blocks.STRIPPED_JUNGLE_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.ACACIA_WOOD), new ItemStack(Blocks.STRIPPED_ACACIA_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(Blocks.DARK_OAK_WOOD), new ItemStack(Blocks.STRIPPED_DARK_OAK_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.RUBBER_WOOD), new ItemStack(BlockRegistry.STRIPPED_RUBBER_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.IRONWOOD_WOOD), new ItemStack(BlockRegistry.STRIPPED_IRONWOOD_WOOD), 200, false);
        new RecipeTypes.SawmillRecipe(new ItemStack(BlockRegistry.REDWOOD_WOOD), new ItemStack(BlockRegistry.STRIPPED_REDWOOD_WOOD), 200, false);

        new RecipeTypes.ExplosionRecipe(new TagStack(DUSTS_CRYSTALLINE), new ItemStack(CRYSTALLINE_INGOT));
        new RecipeTypes.ExplosionRecipe(new TagStack(DUSTS_DIAMOND), new ItemStack(Items.DIAMOND));
        new RecipeTypes.ExplosionRecipe(new TagStack(DUSTS_LAPIS), new ItemStack(Items.LAPIS_LAZULI));
        new RecipeTypes.ExplosionRecipe(new TagStack(DUSTS_PRISMARINE), new ItemStack(Items.PRISMARINE_CRYSTALS));
        new RecipeTypes.ExplosionRecipe(new TagStack(DUSTS_QUARTZ), new ItemStack(Items.QUARTZ));
    }

    public static final ItemTags.Wrapper INGOTS_BRONZE = tag("ingots/bronze");
    public static final ItemTags.Wrapper DUSTS_BRONZE = tag("dusts/bronze");
    public static final ItemTags.Wrapper BLOCKS_COPPER = tag("storage_blocks/copper");
    public static final ItemTags.Wrapper INGOTS_COPPER = tag("ingots/copper");
    public static final ItemTags.Wrapper DUSTS_COPPER = tag("dusts/copper");
    public static final ItemTags.Wrapper INGOTS_CRYSTALLINE = tag("ingots/crystalline");
    public static final ItemTags.Wrapper DUSTS_CRYSTALLINE = tag("dusts/crystalline");
    public static final ItemTags.Wrapper DUSTS_DIAMOND = tag("dusts/diamond");
    public static final ItemTags.Wrapper INGOTS_ELECTRUM = tag("ingots/electrum");
    public static final ItemTags.Wrapper DUSTS_ELECTRUM = tag("dusts/electrum");
    public static final ItemTags.Wrapper DUSTS_GOLD = tag("dusts/gold");
    public static final ItemTags.Wrapper PLATES_IRON = tag("plates/iron");
    public static final ItemTags.Wrapper DUSTS_LAPIS = tag("dusts/lapis");
    public static final ItemTags.Wrapper DUSTS_PRISMARINE = tag("dusts/prismarine");
    public static final ItemTags.Wrapper DUSTS_QUARTZ = tag("dusts/quartz");
    public static final ItemTags.Wrapper BLOCKS_SILVER = tag("storage_blocks/silver");
    public static final ItemTags.Wrapper INGOTS_SILVER = tag("ingots/silver");
    public static final ItemTags.Wrapper DUSTS_SILVER = tag("dusts/silver");
    public static final ItemTags.Wrapper INGOTS_STEEL = tag("ingots/steel");
    public static final ItemTags.Wrapper DUSTS_STEEL = tag("dusts/steel");
    public static final ItemTags.Wrapper BLOCKS_TIN = tag("storage_blocks/tin");
    public static final ItemTags.Wrapper INGOTS_TIN = tag("ingots/tin");
    public static final ItemTags.Wrapper DUSTS_TIN = tag("dusts/tin");

    public static final Block BRONZE_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.BRONZE, MaterialRegistry.BLOCK);
    public static final Item BRONZE_DUST = MaterialItems.getItem(MaterialRegistry.BRONZE, MaterialRegistry.DUST);
    public static final Item BRONZE_INGOT = MaterialItems.getItem(MaterialRegistry.BRONZE, MaterialRegistry.INGOT);
    public static final Item BRONZE_PLATE = MaterialItems.getItem(MaterialRegistry.BRONZE, MaterialRegistry.PLATE);
    public static final Block CHARRED_IRON_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.CHARRED_IRON, MaterialRegistry.BLOCK);
    public static final Item CHARRED_IRON_DUST = MaterialItems.getItem(MaterialRegistry.CHARRED_IRON, MaterialRegistry.DUST);
    public static final Item CHARRED_IRON_INGOT = MaterialItems.getItem(MaterialRegistry.CHARRED_IRON, MaterialRegistry.INGOT);
    public static final Item CHARRED_IRON_PLATE = MaterialItems.getItem(MaterialRegistry.CHARRED_IRON, MaterialRegistry.PLATE);
    public static final Block COPPER_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.COPPER, MaterialRegistry.BLOCK);
    public static final Item COPPER_DUST = MaterialItems.getItem(MaterialRegistry.COPPER, MaterialRegistry.DUST);
    public static final Item COPPER_INGOT = MaterialItems.getItem(MaterialRegistry.COPPER, MaterialRegistry.INGOT);
    public static final Block COPPER_ORE = MaterialBlocks.getBlock(MaterialRegistry.COPPER, MaterialRegistry.ORE);
    public static final Item COPPER_PLATE = MaterialItems.getItem(MaterialRegistry.COPPER, MaterialRegistry.PLATE);
    public static final Block CRYSTALLINE_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.CRYSTALLINE, MaterialRegistry.BLOCK);
    public static final Item CRYSTALLINE_DUST = MaterialItems.getItem(MaterialRegistry.CRYSTALLINE, MaterialRegistry.DUST);
    public static final Item CRYSTALLINE_INGOT = MaterialItems.getItem(MaterialRegistry.CRYSTALLINE, MaterialRegistry.INGOT);
    public static final Item CRYSTALLINE_PLATE = MaterialItems.getItem(MaterialRegistry.CRYSTALLINE, MaterialRegistry.PLATE);
    public static final Item DIAMOND_DUST = MaterialItems.getItem(MaterialRegistry.DIAMOND, MaterialRegistry.DUST);
    public static final Block ELECTRUM_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.ELECTRUM, MaterialRegistry.BLOCK);
    public static final Item ELECTRUM_DUST = MaterialItems.getItem(MaterialRegistry.ELECTRUM, MaterialRegistry.DUST);
    public static final Item ELECTRUM_INGOT = MaterialItems.getItem(MaterialRegistry.ELECTRUM, MaterialRegistry.INGOT);
    public static final Item ELECTRUM_PLATE = MaterialItems.getItem(MaterialRegistry.ELECTRUM, MaterialRegistry.PLATE);
    public static final Item GOLD_DUST = MaterialItems.getItem(MaterialRegistry.GOLD, MaterialRegistry.DUST);
    public static final Item GOLD_PLATE = MaterialItems.getItem(MaterialRegistry.GOLD, MaterialRegistry.PLATE);
    public static final Item IRON_DUST = MaterialItems.getItem(MaterialRegistry.IRON, MaterialRegistry.DUST);
    public static final Item IRON_PLATE = MaterialItems.getItem(MaterialRegistry.IRON, MaterialRegistry.PLATE);
    public static final Item LAPIS_DUST = MaterialItems.getItem(MaterialRegistry.LAPIS, MaterialRegistry.DUST);
    public static final Item MAGMA_DUST = MaterialItems.getItem(MaterialRegistry.MAGMA, MaterialRegistry.DUST);
    public static final Item NETHERRACK_DUST = MaterialItems.getItem(MaterialRegistry.NETHERRACK, MaterialRegistry.DUST);
    public static final Item QUARTZ_DUST = MaterialItems.getItem(MaterialRegistry.QUARTZ, MaterialRegistry.DUST);
    public static final Item PRISMARINE_DUST = MaterialItems.getItem(MaterialRegistry.PRISMARINE, MaterialRegistry.DUST);
    public static final Block SILVER_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.SILVER, MaterialRegistry.BLOCK);
    public static final Item SILVER_DUST = MaterialItems.getItem(MaterialRegistry.SILVER, MaterialRegistry.DUST);
    public static final Item SILVER_INGOT = MaterialItems.getItem(MaterialRegistry.SILVER, MaterialRegistry.INGOT);
    public static final Block SILVER_ORE = MaterialBlocks.getBlock(MaterialRegistry.SILVER, MaterialRegistry.ORE);
    public static final Item SILVER_PLATE = MaterialItems.getItem(MaterialRegistry.SILVER, MaterialRegistry.PLATE);
    public static final Block STEEL_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.STEEL, MaterialRegistry.BLOCK);
    public static final Item STEEL_DUST = MaterialItems.getItem(MaterialRegistry.STEEL, MaterialRegistry.DUST);
    public static final Item STEEL_INGOT = MaterialItems.getItem(MaterialRegistry.STEEL, MaterialRegistry.INGOT);
    public static final Item STEEL_PLATE = MaterialItems.getItem(MaterialRegistry.STEEL, MaterialRegistry.PLATE);
    public static final Item STONE_DUST = MaterialItems.getItem(MaterialRegistry.STONE, MaterialRegistry.DUST);
    public static final Block TIN_BLOCK = MaterialBlocks.getBlock(MaterialRegistry.TIN, MaterialRegistry.BLOCK);
    public static final Item TIN_DUST = MaterialItems.getItem(MaterialRegistry.TIN, MaterialRegistry.DUST);
    public static final Item TIN_INGOT = MaterialItems.getItem(MaterialRegistry.TIN, MaterialRegistry.INGOT);
    public static final Block TIN_ORE = MaterialBlocks.getBlock(MaterialRegistry.TIN, MaterialRegistry.ORE);
    public static final Item TIN_PLATE = MaterialItems.getItem(MaterialRegistry.TIN, MaterialRegistry.PLATE);

    private static ItemTags.Wrapper tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }
}