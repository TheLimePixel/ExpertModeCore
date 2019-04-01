package com.EmosewaPixel.expertmodecore.tiles.containers;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityBlastFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBlastFurnace extends ContainerMachineBase {
    private IItemHandler itemHandler;

    public ContainerBlastFurnace(IInventory playerInventory, TileEntityBlastFurnace te) {
        super(playerInventory, te);
        te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> itemHandler = handler);
        this.addSlot(new SlotItemHandler(itemHandler, 0, 56, 17));
        this.addSlot(new SlotItemHandler(itemHandler, 1, 56, 53));
        this.addSlot(new SlotItemHandler(itemHandler, 2, 116, 35));
    }
}
