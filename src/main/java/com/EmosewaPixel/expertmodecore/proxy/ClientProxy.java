package com.EmosewaPixel.expertmodecore.proxy;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.MaterialItem;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTiered;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.IWorldReaderBase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IModProxy {
    @Override
    public void enque(InterModEnqueueEvent e) {
        color();
    }

    @Override
    public void process(InterModProcessEvent e) {

    }

    @SubscribeEvent
    public static void onModelBaking(ModelBakeEvent e) {
        for (MaterialItem item : MaterialItems.materialItems)
            if (item instanceof Item)
                e.getModelRegistry().put(new ModelResourceLocation(((Item) item).getRegistryName(), "inventory"), e.getModelRegistry().get(new ModelResourceLocation("expertmodecore:" + item.getMaterial().getTextureType().toString() + "_" + item.getObjType().getName(), "inventory")));

        for (MaterialItem block : MaterialBlocks.materialBlocks)
            if (block instanceof Block) {
                e.getModelRegistry().put(new ModelResourceLocation(((Block) block).getRegistryName(), ""), e.getModelRegistry().get(new ModelResourceLocation("expertmodecore:" + block.getMaterial().getTextureType().toString() + "_" + block.getObjType().getName(), "")));
                e.getModelRegistry().put(new ModelResourceLocation(((Block) block).getRegistryName(), "inventory"), e.getModelRegistry().get(new ModelResourceLocation("expertmodecore:" + block.getMaterial().getTextureType().toString() + "_" + block.getObjType().getName(), "inventory")));
            }
    }

    private void color() {
        //Leaves
        Minecraft.getInstance().getBlockColors().register((IBlockState state, @Nullable IWorldReaderBase reader, @Nullable BlockPos pos, int index) -> reader.getBiome(pos).getFoliageColor(pos), BlockRegistry.RUBBER_LEAVES);
        Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> FoliageColors.getDefault(), BlockRegistry.RUBBER_LEAVES);
        Minecraft.getInstance().getBlockColors().register((IBlockState state, @Nullable IWorldReaderBase reader, @Nullable BlockPos pos, int index) -> reader.getBiome(pos).getFoliageColor(pos), BlockRegistry.IRONWOOD_LEAVES);
        Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> FoliageColors.getDefault(), BlockRegistry.IRONWOOD_LEAVES);
        Minecraft.getInstance().getBlockColors().register((IBlockState state, @Nullable IWorldReaderBase reader, @Nullable BlockPos pos, int index) -> reader.getBiome(pos).getFoliageColor(pos), BlockRegistry.REDWOOD_LEAVES);
        Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> FoliageColors.getDefault(), BlockRegistry.REDWOOD_LEAVES);

        //Material Items
        for (MaterialItem item : MaterialItems.materialItems) {
            if (item instanceof Item && !(item instanceof ItemTiered))
                Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> {
                    Item sItem = stack.getItem();
                    if (sItem instanceof MaterialItem)
                        return ((MaterialItem) sItem).getMaterial().getColor();
                    return -1;
                }, (Item) item);

            if (item instanceof ItemTiered)
                Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> {
                    Item sItem = stack.getItem();
                    if (sItem instanceof MaterialItem && index == 1)
                        return ((MaterialItem) sItem).getMaterial().getColor();
                    return -1;
                }, (Item) item);
        }

        for (MaterialItem block : MaterialBlocks.materialBlocks)
            if (block instanceof Block) {
                Minecraft.getInstance().getBlockColors().register((IBlockState state, @Nullable IWorldReaderBase reader, @Nullable BlockPos pos, int index) -> {
                    Block sBlock = state.getBlock();
                    if (sBlock instanceof MaterialItem && index == 0)
                        return ((MaterialItem) sBlock).getMaterial().getColor();
                    return -1;
                }, ((Block) block));

                Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> {
                    Block sBlock = Block.getBlockFromItem(stack.getItem());
                    if (sBlock instanceof MaterialItem && index == 0)
                        return ((MaterialItem) sBlock).getMaterial().getColor();
                    return -1;
                }, Item.getItemFromBlock((Block) block).asItem());
            }
    }
}