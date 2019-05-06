package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityCokeOven;
import com.EmosewaPixel.expertmodecore.tiles.containers.interfaces.ContainerCokeOvenInterface;
import com.EmosewaPixel.pixellib.blocks.BlockMachineFuelBased;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockCokeOven extends BlockMachineFuelBased {
    public BlockCokeOven() {
        super(new ResourceLocation("expertmodecore:coke_oven"));
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote && worldIn.getTileEntity(pos) instanceof TileEntityCokeOven) {
            NetworkHooks.openGui((EntityPlayerMP) player, new ContainerCokeOvenInterface(pos, this.getRegistryName()), pos);
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityCokeOven();
    }
}
