package com.EmosewaPixel.expertmodecore.proxy;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.IWorldReaderBase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IModProxy{
    @Override
    public void enque(InterModEnqueueEvent e) {
        Minecraft.getInstance().getBlockColors().register((IBlockState state, @Nullable IWorldReaderBase reader, @Nullable BlockPos pos, int index) -> reader.getBiome(pos).getFoliageColor(pos), BlockRegistry.RUBBER_LEAVES);
        Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> FoliageColors.getDefault(), BlockRegistry.RUBBER_LEAVES);
        Minecraft.getInstance().getBlockColors().register((IBlockState state, @Nullable IWorldReaderBase reader, @Nullable BlockPos pos, int index) -> reader.getBiome(pos).getFoliageColor(pos), BlockRegistry.IRONWOOD_LEAVES);
        Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> FoliageColors.getDefault(), BlockRegistry.IRONWOOD_LEAVES);
        Minecraft.getInstance().getBlockColors().register((IBlockState state, @Nullable IWorldReaderBase reader, @Nullable BlockPos pos, int index) -> reader.getBiome(pos).getFoliageColor(pos), BlockRegistry.REDWOOD_LEAVES);
        Minecraft.getInstance().getItemColors().register((ItemStack stack, int index) -> FoliageColors.getDefault(), BlockRegistry.REDWOOD_LEAVES);
    }

    @Override
    public void process(InterModProcessEvent e) {

    }
}
