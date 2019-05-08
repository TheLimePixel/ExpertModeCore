package com.EmosewaPixel.expertmodecore.tiles.containers;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityCokeOven;
import com.EmosewaPixel.pixellib.tiles.containers.ContainerMachineFuelBased;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.items.SlotItemHandler;

import java.util.Iterator;

public class ContainerCokeOven extends ContainerMachineFuelBased {
    public ContainerCokeOven(IInventory playerInventory, TileEntityCokeOven te) {
        super(playerInventory, te);
    }

    @Override
    protected void addMachineSlots() {
        super.addMachineSlots();

        this.addSlot(new SlotItemHandler(itemHandler, 2, 146, 17));
        this.addSlot(new SlotItemHandler(itemHandler, 3, 146, 53));
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        Iterator var1 = listeners.iterator();

        while (var1.hasNext()) {
            IContainerListener listener = (IContainerListener) var1.next();
            listener.sendWindowProperty(this, 4, ((TileEntityCokeOven) te).getCreosoteAmount());
        }
    }

    public void updateProgressBar(int id, int data) {
        super.updateProgressBar(id, data);
        if (id == 4)
            ((TileEntityCokeOven) te).setCreosoteAmount(data);
    }
}