package com.EmosewaPixel.expertmodecore.blocks.trees;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRedwoodLeaves extends BlockLeaves {
    public BlockRedwoodLeaves() {
        super(Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).needsRandomTick().sound(SoundType.PLANT));
        setRegistryName("expertmodecore:redwood_leaves");
    }

    @Override
    public void getDrops(IBlockState state, net.minecraft.util.NonNullList<ItemStack> drops, World worldIn, BlockPos pos, int fortune) {
        int i = 100;
        if (fortune > 0) {
            i -= 2 << fortune;
            if (i < 10) {
                i = 10;
            }
        }

        if (worldIn.rand.nextInt(i) == 0)
            drops.add(new ItemStack(BlockRegistry.REDWOOD_SAPLING));

        captureDrops(true);
        drops.addAll(captureDrops(false));
    }
}
