package com.EmosewaPixel.expertmodecore.tiles.containers.interfaces;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityCokeOven;
import com.EmosewaPixel.expertmodecore.tiles.containers.ContainerCokeOven;
import com.EmosewaPixel.pixellib.tiles.containers.interfaces.ContainerMachineFueledInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class ContainerCokeOvenInterface extends ContainerMachineFueledInterface {
    public ContainerCokeOvenInterface(BlockPos pos, ResourceLocation name) {
        super(pos, name);
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
        return new ContainerCokeOven(inventoryPlayer, (TileEntityCokeOven) entityPlayer.world.getTileEntity(pos));
    }
}
