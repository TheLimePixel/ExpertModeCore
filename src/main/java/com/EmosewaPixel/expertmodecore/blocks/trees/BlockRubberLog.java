package com.EmosewaPixel.expertmodecore.blocks.trees;

import com.EmosewaPixel.expertmodecore.items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRubberLog extends ModLog {
    public static final BooleanProperty HAS_SAP = BooleanProperty.create("has_sap");

    public BlockRubberLog() {
        super("rubber_log", 0, 2);
        setDefaultState(getDefaultState().with(AXIS, EnumFacing.Axis.Y).with(HAS_SAP, false));
    }

    @Override
    public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
        drops.add(new ItemStack(this));
        if (state.get(HAS_SAP))
            drops.add(new ItemStack(ItemRegistry.RUBBER_DROP, fortune <= 0 ? 1 : 1 + world.rand.nextInt(fortune)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(AXIS);
        builder.add(HAS_SAP);
    }

    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(AXIS, context.getFace().getAxis()).with(HAS_SAP, false);
    }
}
