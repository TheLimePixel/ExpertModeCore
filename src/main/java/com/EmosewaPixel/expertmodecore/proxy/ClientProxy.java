package com.EmosewaPixel.expertmodecore.proxy;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import com.EmosewaPixel.pixellib.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.pixellib.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.pixellib.proxy.IModProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTiered;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.IWorldReaderBase;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;

import javax.annotation.Nullable;

public class ClientProxy implements IModProxy {
    @Override
    public void enque(InterModEnqueueEvent e) {
        color();
    }

    @Override
    public void process(InterModProcessEvent e) {

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
        for (Item item : MaterialItems.getAllItems()) {
            if (item instanceof ItemArmor)
                Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> {
                    Item sItem = stack.getItem();
                    if (sItem instanceof IMaterialItem)
                        return ((IMaterialItem) sItem).getMaterial().getColor();
                    return -1;
                }, item);

            if (item instanceof ItemTiered)
                Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> {
                    Item sItem = stack.getItem();
                    if (sItem instanceof IMaterialItem && index == 1)
                        return ((IMaterialItem) sItem).getMaterial().getColor();
                    return -1;
                }, item);
        }
    }
}