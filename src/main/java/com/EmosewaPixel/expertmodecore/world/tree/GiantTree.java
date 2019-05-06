package com.EmosewaPixel.expertmodecore.world.tree;

import com.EmosewaPixel.expertmodecore.blocks.BlockRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.HugeTreesFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;

public class GiantTree extends HugeTreesFeature<NoFeatureConfig> {
    private static final IBlockState TRUNK = BlockRegistry.REDWOOD_LOG.getDefaultState();
    private static final IBlockState LEAF = BlockRegistry.REDWOOD_LEAVES.getDefaultState();

    public GiantTree(boolean notify) {
        super(notify, 30, 15, TRUNK, LEAF);
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorld worldIn, Random rand, BlockPos position) {
        int i = this.getHeight(rand);
        if (!this.func_203427_a(worldIn, position, i)) {
            return false;
        } else {
            this.createCrown(worldIn, position.getX(), position.getZ(), position.getY() + i, 0, rand);

            for (int j = 0; j < i; ++j) {
                IBlockState iblockstate = worldIn.getBlockState(position.up(j));
                if (iblockstate.isAir(worldIn, position.up(j)) || iblockstate.isIn(BlockTags.LEAVES)) {
                    this.setLogState(changedBlocks, worldIn, position.up(j), this.trunk);
                }

                if (j < i - 1) {
                    iblockstate = worldIn.getBlockState(position.add(1, j, 0));
                    if (iblockstate.isAir(worldIn, position.add(1, j, 0)) || iblockstate.isIn(BlockTags.LEAVES)) {
                        this.setLogState(changedBlocks, worldIn, position.add(1, j, 0), this.trunk);
                    }

                    iblockstate = worldIn.getBlockState(position.add(1, j, 1));
                    if (iblockstate.isAir(worldIn, position.add(1, j, 1)) || iblockstate.isIn(BlockTags.LEAVES)) {
                        this.setLogState(changedBlocks, worldIn, position.add(1, j, 1), this.trunk);
                    }

                    iblockstate = worldIn.getBlockState(position.add(0, j, 1));
                    if (iblockstate.isAir(worldIn, position.add(0, j, 1)) || iblockstate.isIn(BlockTags.LEAVES)) {
                        this.setLogState(changedBlocks, worldIn, position.add(0, j, 1), this.trunk);
                    }
                }
            }

            return true;
        }
    }

    private void createCrown(IWorld worldIn, int x, int z, int y, int p_150541_5_, Random rand) {
        int i = rand.nextInt(5) + this.baseHeight;
        int j = 0;

        for (int k = y - i; k <= y; ++k) {
            int l = y - k;
            int i1 = p_150541_5_ + MathHelper.floor((float) l / (float) i * 3.5F);
            this.growLeavesLayerStrict(worldIn, new BlockPos(x, k, z), i1 + (l > 0 && i1 == j && (k & 1) == 0 ? 1 : 0));
            j = i1;
        }
    }
}