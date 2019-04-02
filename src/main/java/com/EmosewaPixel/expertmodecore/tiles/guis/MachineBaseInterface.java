package com.EmosewaPixel.expertmodecore.tiles.guis;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityFurnaceBase;
import com.EmosewaPixel.expertmodecore.tiles.containers.ContainerMachineBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;

import javax.annotation.Nullable;

public class MachineBaseInterface implements IInteractionObject {
    private BlockPos pos;
    private String name;

    public MachineBaseInterface(BlockPos pos, String name) {
        this.pos = pos;
        this.name = name;
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
        return new ContainerMachineBase(inventoryPlayer, (TileEntityFurnaceBase) entityPlayer.world.getTileEntity(pos));
    }

    @Override
    public String getGuiID() {
        return "expertmodecore:" + name;
    }

    @Override
    public ITextComponent getName() {
        return new TextComponentTranslation("block.skyresourcesclassic." + name, new Object[0]);
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Nullable
    @Override
    public ITextComponent getCustomName() {
        return null;
    }
}
