package com.EmosewaPixel.expertmodecore;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import com.EmosewaPixel.expertmodecore.items.tools.MaterialHammer;
import com.EmosewaPixel.expertmodecore.materials.MaterialAddition;
import com.EmosewaPixel.expertmodecore.proxy.ClientProxy;
import com.EmosewaPixel.expertmodecore.proxy.ServerProxy;
import com.EmosewaPixel.expertmodecore.recipes.MachineRecipeAddition;
import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.expertmodecore.resourceAddition.DataAddition;
import com.EmosewaPixel.expertmodecore.tiles.ExpertTypes;
import com.EmosewaPixel.expertmodecore.tiles.guis.ModGuiHandler;
import com.EmosewaPixel.expertmodecore.world.OreGen;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.pixellib.materialSystem.lists.Materials;
import com.EmosewaPixel.pixellib.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.pixellib.materialSystem.materials.Material;
import com.EmosewaPixel.pixellib.materialSystem.materials.MaterialRegistry;
import com.EmosewaPixel.pixellib.proxy.IModProxy;
import com.EmosewaPixel.pixellib.recipes.SimpleMachineRecipe;
import com.EmosewaPixel.pixellib.recipes.TagStack;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
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
    public static final Logger LOGGER = LogManager.getLogger();
    private static IModProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ItemGroup main = new ItemGroup("expert_mode_main") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockRegistry.COKE_OVEN);
        }
    };

    public ExpertModeCore() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> ModGuiHandler::guis);

        MinecraftForge.EVENT_BUS.register(this);

        new MaterialAddition();
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGen.addOres();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        MachineRecipeAddition.registry();
        proxy.enque(event);
    }

    private void processIMC(final InterModProcessEvent event) {
        proxy.process(event);
        DataAddition.register();
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
            e.getRegistry().register(ExpertTypes.SAWMILL);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = ModId)
    public static class GameEvents {
        @SubscribeEvent
        public static void fuelTime(FurnaceFuelBurnTimeEvent e) {
            if (e.getItemStack().getItem() == MaterialItems.getItem(MaterialAddition.COKE, MaterialRegistry.GEM))
                e.setBurnTime(3200);
            if (e.getItemStack().getItem() == MaterialBlocks.getBlock(MaterialAddition.COKE, MaterialRegistry.BLOCK).asItem())
                e.setBurnTime(32000);
            if (e.getItemStack().getItem() == ItemRegistry.CREOSOTE_BUCKET)
                e.setBurnTime(6400);
            if (e.getItemStack().getItem() == ItemRegistry.CREOSOTE_BOTTLE)
                e.setBurnTime(3200);
            if (e.getItemStack().getItem() == ItemRegistry.TREATED_STICK)
                e.setBurnTime(800);
        }

        @SubscribeEvent
        public static void onClick(PlayerInteractEvent.RightClickBlock e) {
            World world = e.getWorld();
            IBlockState state = world.getBlockState(e.getPos());
            if (e.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemAxe && ((ItemAxe) e.getEntityPlayer().getHeldItemMainhand().getItem()).getTier().getHarvestLevel() >= state.getBlock().getHarvestLevel(state)) {
                if (state.getBlock() == BlockRegistry.RUBBER_LOG) {
                    world.playSound(e.getEntityPlayer(), e.getPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    e.getEntityPlayer().getHeldItemMainhand().damageItem(1, e.getEntityLiving());
                    world.setBlockState(e.getPos(), BlockRegistry.STRIPPED_RUBBER_LOG.getDefaultState().with(BlockRotatedPillar.AXIS, state.get(BlockRotatedPillar.AXIS)));
                }
                if (state.getBlock() == BlockRegistry.RUBBER_WOOD) {
                    world.playSound(e.getEntityPlayer(), e.getPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    e.getEntityPlayer().getHeldItemMainhand().damageItem(1, e.getEntityLiving());
                    world.setBlockState(e.getPos(), BlockRegistry.STRIPPED_RUBBER_WOOD.getDefaultState().with(BlockRotatedPillar.AXIS, state.get(BlockRotatedPillar.AXIS)));
                }
                if (state.getBlock() == BlockRegistry.IRONWOOD_LOG) {
                    world.playSound(e.getEntityPlayer(), e.getPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    e.getEntityPlayer().getHeldItemMainhand().damageItem(1, e.getEntityLiving());
                    world.setBlockState(e.getPos(), BlockRegistry.STRIPPED_IRONWOOD_LOG.getDefaultState().with(BlockRotatedPillar.AXIS, state.get(BlockRotatedPillar.AXIS)));
                }
                if (state.getBlock() == BlockRegistry.IRONWOOD_WOOD) {
                    world.playSound(e.getEntityPlayer(), e.getPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    e.getEntityPlayer().getHeldItemMainhand().damageItem(1, e.getEntityLiving());
                    world.setBlockState(e.getPos(), BlockRegistry.STRIPPED_IRONWOOD_WOOD.getDefaultState().with(BlockRotatedPillar.AXIS, state.get(BlockRotatedPillar.AXIS)));
                }
                if (state.getBlock() == BlockRegistry.REDWOOD_LOG) {
                    world.playSound(e.getEntityPlayer(), e.getPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    e.getEntityPlayer().getHeldItemMainhand().damageItem(1, e.getEntityLiving());
                    world.setBlockState(e.getPos(), BlockRegistry.STRIPPED_REDWOOD_LOG.getDefaultState().with(BlockRotatedPillar.AXIS, state.get(BlockRotatedPillar.AXIS)));
                }
                if (state.getBlock() == BlockRegistry.REDWOOD_WOOD) {
                    world.playSound(e.getEntityPlayer(), e.getPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    e.getEntityPlayer().getHeldItemMainhand().damageItem(1, e.getEntityLiving());
                    world.setBlockState(e.getPos(), BlockRegistry.STRIPPED_REDWOOD_WOOD.getDefaultState().with(BlockRotatedPillar.AXIS, state.get(BlockRotatedPillar.AXIS)));
                }
            }
        }

        @SubscribeEvent
        public static void onExplosion(ExplosionEvent.Detonate e) {
            Iterator<Entity> iterator = e.getAffectedEntities().iterator();
            while (iterator.hasNext()) {
                Entity entity = iterator.next();
                if (entity instanceof EntityItem) {
                    EntityItem item = (EntityItem) entity;
                    for (SimpleMachineRecipe recipe : RecipeTypes.EXPLOSION_RECIPES.getReipes())
                        if (recipe.isInputValid(new ItemStack[]{item.getItem()})) {
                            item.setItem(new ItemStack(recipe.getOutput(0).getItem(), item.getItem().getCount()));
                            iterator.remove();
                            break;
                        }
                }
            }
        }

        @SubscribeEvent
        public static void onBreak(BlockEvent.BreakEvent e) {
            if (new ItemTags.Wrapper(new ResourceLocation("forge:ores")).contains(e.getState().getBlock().asItem()) && !(e.getPlayer().getHeldItemMainhand().getItem() instanceof MaterialHammer))
                e.setExpToDrop(0);

            if (e.getState().getBlock() == Blocks.REDSTONE_ORE && e.getPlayer().getHeldItemMainhand().getItem() == MaterialItems.getItem(MaterialAddition.BRONZE, MaterialAddition.HAMMER)) {
                e.getWorld().spawnEntity(new EntityItem(e.getWorld().getWorld(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), new ItemStack(Items.REDSTONE, 3)));
                e.getWorld().spawnEntity(new EntityItem(e.getWorld().getWorld(), e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), new TagStack(MachineRecipeAddition.DUSTS_STONE).asItemStack()));
            }
        }

        @SubscribeEvent
        public static void onGeneralBlockEvent(BlockEvent e) {
            if (e.getState() == Blocks.PISTON_HEAD.getDefaultState().with(BlockPistonBase.FACING, EnumFacing.DOWN)) {
                BlockPos pos = e.getPos();
                List<EntityItem> items = e.getWorld().getWorld().getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY(), pos.getZ() + 1));
                for (EntityItem item : items)
                    for (SimpleMachineRecipe recipe : RecipeTypes.PRESSING_RECIPES.getReipes())
                        if (recipe.itemBelongsInRecipe(item.getItem()))
                            item.setItem(new ItemStack(recipe.getOutput(0).getItem(), item.getItem().copy().getCount()));
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
                    item.setItem(new ItemStack(MachineRecipeAddition.CHARRED_IRON_INGOT, item.getItem().getCount()));
            }
        }

        @SubscribeEvent
        public static void onDimTravel(EntityTravelToDimensionEvent e) {
            if (e.getEntity() instanceof EntityPlayerMP)
                if (e.getDimension() == DimensionType.NETHER && !((EntityPlayerMP) e.getEntity()).getAdvancements().getProgress(new AdvancementManager().getAdvancement(new ResourceLocation("minecraft:story/smelt_iron"))).isDone())
                    e.setCanceled(true);
        }

        @SubscribeEvent
        public static void onDrop(BlockEvent.HarvestDropsEvent e) {
            Item item = e.getState().getBlock().asItem();
            if (e.getState().getBlock() instanceof BlockLeaves && e.getWorld().getRandom().nextInt(100) < 25) {
                e.getDrops().add(new ItemStack(Items.STICK));
            }
            if (e.getHarvester() != null) {
                if (e.getState().getBlock() instanceof BlockLog) {
                    if (!(e.getHarvester().getHeldItemMainhand().getItem() instanceof ItemAxe)) {
                        e.getDrops().removeAll(e.getDrops());
                        e.getWorld().getWorld().setBlockState(e.getPos(), e.getState());
                    } else if (((ItemAxe) e.getHarvester().getHeldItemMainhand().getItem()).getTier().getHarvestLevel() < e.getState().getBlock().getHarvestLevel(e.getState())) {
                        e.getDrops().removeAll(e.getDrops());
                        e.getWorld().getWorld().setBlockState(e.getPos(), e.getState());
                    }
                }
                if (tag("ores").contains(item) && !e.getDrops().contains(new ItemStack(e.getState().getBlock())) && !(e.getHarvester().getHeldItemMainhand().getItem() instanceof MaterialHammer)) {
                    e.getDrops().removeAll(e.getDrops());
                    e.getDrops().add(new ItemStack(e.getState().getBlock()));
                }
                if (e.getHarvester().getHeldItemMainhand().getItem() instanceof MaterialHammer) {
                    if (tag("ores").contains(item)) {
                        for (Material mat : Materials.getAll())
                            if (mat.hasTag(MaterialRegistry.HAS_ORE) && mat instanceof IngotMaterial)
                                if (tag("ores/" + mat.getName()).contains(item)) {
                                    e.getDrops().removeAll(e.getDrops());
                                    e.getDrops().add(new TagStack(tag("dusts/" + mat.getName())).asItemStack());
                                }
                        e.getDrops().add(new TagStack(MachineRecipeAddition.DUSTS_STONE).asItemStack());
                    }
                    if (e.getState().getBlock() == Blocks.MAGMA_BLOCK) {
                        e.getDrops().remove(0);
                        e.getDrops().add(new ItemStack(MachineRecipeAddition.MAGMA_DUST, 2));
                    }
                    if (e.getState().getBlock() == Blocks.NETHERRACK) {
                        e.getDrops().remove(0);
                        e.getDrops().add(new TagStack(MachineRecipeAddition.DUSTS_NETHERRACK, 2).asItemStack());
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