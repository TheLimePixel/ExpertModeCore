package com.EmosewaPixel.expertmodecore.tiles.containers.interfaces;

import com.EmosewaPixel.expertmodecore.tiles.TileEntitySawmill;
import com.EmosewaPixel.pixellib.tiles.containers.ContainerMachineRecipeBased;
import com.EmosewaPixel.pixellib.tiles.containers.interfaces.ContainerMachineFueledInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class ContainerSawmillinterface extends ContainerMachineFueledInterface {
    public ContainerSawmillinterface(BlockPos pos, ResourceLocation name) {
        super(pos, name);
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
        return new ContainerMachineRecipeBased<>(inventoryPlayer, (TileEntitySawmill) entityPlayer.world.getTileEntity(pos));
    }
}