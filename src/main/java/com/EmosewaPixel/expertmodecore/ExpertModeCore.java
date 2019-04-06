package com.EmosewaPixel.expertmodecore;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.blocks.OreGen;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import com.EmosewaPixel.expertmodecore.items.tools.ModHammer;
import com.EmosewaPixel.expertmodecore.recipes.RecipeAddition;
import com.EmosewaPixel.expertmodecore.tiles.ExpertTypes;
import com.EmosewaPixel.expertmodecore.tiles.guis.ModGuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExpertModeCore.ModId)
public class ExpertModeCore {
    public static final String ModId = "expertmodecore";

    public static ItemGroup main = new ItemGroup("expert_mode_main") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.FLINT_PICK);
        }
    };

    public ExpertModeCore() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> ModGuiHandler::guis);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGen.addOres();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        RecipeAddition.registry();
    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ModId)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {
            BlockRegistry.registry(e);
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
            ItemRegistry.registry(e);
            BlockRegistry.itemRegistry(e);
        }

        @SubscribeEvent
        public static void onTERegistry(final RegistryEvent.Register<TileEntityType<?>> e) {
            e.getRegistry().register(ExpertTypes.ALLOYER);
            e.getRegistry().register(ExpertTypes.BLAST_FURNACE);
            e.getRegistry().register(ExpertTypes.COKE_OVEN);
            e.getRegistry().register(ExpertTypes.CRUSHER);
            e.getRegistry().register(ExpertTypes.INFUSION_TABLE);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = ModId)
    public static class GameEvents {
        @SubscribeEvent
        public static void fuelTime(FurnaceFuelBurnTimeEvent e) {
            if (e.getItemStack().getItem() == ItemRegistry.COKE_COKE)
                e.setBurnTime(3200);
            if (e.getItemStack().getItem() == ItemRegistry.CREOSOTE_BUCKET)
                e.setBurnTime(6400);
        }

        @SubscribeEvent
        public static void onBreak(BlockEvent.BreakEvent e) {
            if (new ItemTags.Wrapper(new ResourceLocation("forge:ores")).contains(e.getState().getBlock().asItem()) && !(e.getPlayer().getHeldItemMainhand().getItem() instanceof ModHammer))
                e.setExpToDrop(0);

            if (e.getState().getBlock() == Blocks.REDSTONE_ORE && e.getPlayer().getHeldItemMainhand().getItem() == ItemRegistry.BRONZE_HAMMER) {
                e.getWorld().spawnEntity(new EntityItem(e.getWorld().getWorld(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), new ItemStack(Items.REDSTONE, 3)));
                e.getWorld().spawnEntity(new EntityItem(e.getWorld().getWorld(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), new ItemStack(ItemRegistry.STONE_DUST)));
            }
        }

        @SubscribeEvent
        public static void onDrop(BlockEvent.HarvestDropsEvent e) {
            Item item = e.getState().getBlock().asItem();
            if (e.getState().getBlock() instanceof BlockLeaves && e.getWorld().getRandom().nextInt(100) < 25) {
                e.getDrops().add(new ItemStack(Items.STICK));
            }
            if (e.getHarvester() != null) {
                if (e.getState().getBlock() instanceof BlockLog && !(e.getHarvester().getHeldItemMainhand().getItem() instanceof ItemAxe)) {
                    e.getDrops().remove(0);
                    e.getWorld().getWorld().setBlockState(e.getPos(), e.getState());
                }
                if (tag("forge:ores").contains(item) && !e.getDrops().contains(new ItemStack(e.getState().getBlock())) && !(e.getHarvester().getHeldItemMainhand().getItem() instanceof ModHammer)) {
                    e.getDrops().removeAll(e.getDrops());
                    e.getDrops().add(new ItemStack(e.getState().getBlock()));
                }
                if (e.getHarvester().getHeldItemMainhand().getItem() instanceof ModHammer) {
                    if (tag("forge:ores").contains(item)) {
                        if (Tags.Items.ORES_IRON.contains(item)) {
                            e.getDrops().removeAll(e.getDrops());
                            e.getDrops().add(new ItemStack(ItemRegistry.IRON_DUST));
                        }
                        if (RecipeAddition.ORES_COPPER.contains(item)) {
                            e.getDrops().removeAll(e.getDrops());
                            e.getDrops().add(new ItemStack(ItemRegistry.GOLD_DUST));
                        }
                        if (RecipeAddition.ORES_TIN.contains(item)) {
                            e.getDrops().removeAll(e.getDrops());
                            e.getDrops().add(new ItemStack(ItemRegistry.TIN_DUST));
                        }
                        if (RecipeAddition.ORES_SILVER.contains(item)) {
                            e.getDrops().removeAll(e.getDrops());
                            e.getDrops().add(new ItemStack(ItemRegistry.SILVER_DUST));
                        }
                        if (Tags.Items.ORES_GOLD.contains(item)) {
                            e.getDrops().removeAll(e.getDrops());
                            e.getDrops().add(new ItemStack(ItemRegistry.GOLD_DUST));
                        }
                        e.getDrops().add(new ItemStack(ItemRegistry.STONE_DUST));
                    }
                    if (e.getState().getBlock() == Blocks.MAGMA_BLOCK) {
                        e.getDrops().remove(0);
                        e.getDrops().add(new ItemStack(ItemRegistry.CRUSHED_MAGMA_BLOCK, 2));
                    }
                    if (e.getState().getBlock() == Blocks.NETHERRACK) {
                        e.getDrops().remove(0);
                        e.getDrops().add(new ItemStack(ItemRegistry.NETHERRACK_DUST, 2));
                    }
                }
            }
        }

        private static ItemTags.Wrapper tag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation(name));
        }
    }
}