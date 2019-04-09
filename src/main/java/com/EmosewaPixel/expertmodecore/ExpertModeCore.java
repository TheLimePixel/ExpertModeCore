package com.EmosewaPixel.expertmodecore;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.blocks.OreGen;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import com.EmosewaPixel.expertmodecore.items.tools.ModHammer;
import com.EmosewaPixel.expertmodecore.recipes.RecipeAddition;
import com.EmosewaPixel.expertmodecore.tiles.ExpertTypes;
import com.EmosewaPixel.expertmodecore.tiles.guis.ModGuiHandler;
import net.minecraft.block.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod(ExpertModeCore.ModId)
public class ExpertModeCore {
    public static final String ModId = "expertmodecore";
    private static final Logger LOGGER = LogManager.getLogger();

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
        public static void onGeneralBlockEvent(BlockEvent e) {
            if (e.getState() == Blocks.PISTON_HEAD.getDefaultState().with(BlockPistonBase.FACING, EnumFacing.DOWN)) {
                BlockPos pos = e.getPos();
                List<EntityItem> items = e.getWorld().getWorld().getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY(), pos.getZ() + 1));
                for (EntityItem item : items)
                    if (tag("ingots").contains(item.getItem().getItem())) {
                        if (Tags.Items.INGOTS_IRON.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.IRON_PLATE, item.getItem().copy().getCount()));
                        if (Tags.Items.INGOTS_GOLD.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.GOLD_PLATE, item.getItem().copy().getCount()));
                        if (RecipeAddition.INGOTS_BRONZE.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.BRONZE_PLATE, item.getItem().copy().getCount()));
                        if (RecipeAddition.INGOTS_COPPER.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.COPPER_PLATE, item.getItem().copy().getCount()));
                        if (RecipeAddition.INGOTS_ELECTRUM.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.ELECTRUM_PLATE, item.getItem().copy().getCount()));
                        if (RecipeAddition.INGOTS_SILVER.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.SILVER_PLATE, item.getItem().copy().getCount()));
                        if (RecipeAddition.INGOTS_STEEL.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.STEEL_PLATE, item.getItem().copy().getCount()));
                        if (RecipeAddition.INGOTS_TIN.contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.TIN_PLATE, item.getItem().copy().getCount()));
                        if (tag("ingots/charred_iron").contains(item.getItem().getItem()))
                            item.setItem(new ItemStack(ItemRegistry.CHARRED_IRON_PLATE, item.getItem().copy().getCount()));
                    }
            }
        }

        private static List<EntityItem> ironIngots = new ArrayList<>();

        @SubscribeEvent
        public static void onJoin(EntityJoinWorldEvent e) {
            if (e.getEntity() instanceof EntityItem)
                if (((EntityItem) e.getEntity()).getItem().getItem() == Items.IRON_INGOT)
                    ironIngots.add((EntityItem) e.getEntity());
        }

        @SubscribeEvent
        public static void onTick(TickEvent.WorldTickEvent e) {
            for (Iterator<EntityItem> iterator = ironIngots.iterator(); iterator.hasNext(); ) {
                EntityItem item = iterator.next();
                if (item.removed) {
                    iterator.remove();
                    continue;
                }

                if (item.getItem().getItem() != Items.IRON_INGOT) {
                    iterator.remove();
                    continue;
                }

                for (BlockPos pos : new BlockPos[]{item.getPosition().down(), item.getPosition().west(), item.getPosition().east(), item.getPosition().north(), item.getPosition().south()})
                    if (e.world.getBlockState(pos).getBlock() instanceof BlockFire)
                        item.attackEntityFrom(DamageSource.IN_FIRE, -100);

                if (e.world.getBlockState(item.getPosition()).getBlock() instanceof BlockFire)
                    item.setItem(new ItemStack(ItemRegistry.CHARRED_IRON_INGOT, item.getItem().getCount()));
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
                if (tag("ores").contains(item) && !e.getDrops().contains(new ItemStack(e.getState().getBlock())) && !(e.getHarvester().getHeldItemMainhand().getItem() instanceof ModHammer)) {
                    e.getDrops().removeAll(e.getDrops());
                    e.getDrops().add(new ItemStack(e.getState().getBlock()));
                }
                if (e.getHarvester().getHeldItemMainhand().getItem() instanceof ModHammer) {
                    if (tag("ores").contains(item)) {
                        if (Tags.Items.ORES_IRON.contains(item)) {
                            e.getDrops().removeAll(e.getDrops());
                            e.getDrops().add(new ItemStack(ItemRegistry.IRON_DUST));
                        }
                        if (RecipeAddition.ORES_COPPER.contains(item)) {
                            e.getDrops().removeAll(e.getDrops());
                            e.getDrops().add(new ItemStack(ItemRegistry.COPPER_DUST));
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

            if (e.getState().getBlock() == Blocks.GRASS && e.getWorld().getRandom().nextInt(100) < 10)
                e.getDrops().add(new ItemStack(Items.WHEAT_SEEDS));
        }

        private static ItemTags.Wrapper tag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    }
}