package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.tiles.TileEntitySawmill;
import com.EmosewaPixel.expertmodecore.tiles.containers.interfaces.ContainerSawmillinterface;
import com.EmosewaPixel.pixellib.blocks.BlockMachineActivateable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockSawmill extends BlockMachineActivateable {
    public BlockSawmill() {
        super("expertmodecore:sawmill", TileEntitySawmill::new);
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote && worldIn.getTileEntity(pos) instanceof TileEntitySawmill) {
            NetworkHooks.openGui((EntityPlayerMP) player, new ContainerSawmillinterface(pos, this.getRegistryName()), pos);
        }

        return true;
    }
}