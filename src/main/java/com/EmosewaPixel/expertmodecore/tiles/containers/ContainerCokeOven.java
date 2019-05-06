package com.EmosewaPixel.expertmodecore.tiles.containers;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityCokeOven;
import com.EmosewaPixel.pixellib.tiles.containers.ContainerMachineFuelBased;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;

import java.util.Iterator;

public class ContainerCokeOven extends ContainerMachineFuelBased {
    private TileEntityCokeOven te;

    public ContainerCokeOven(IInventory playerInventory, TileEntityCokeOven te) {
        super(playerInventory, te);
        this.te = te;
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        Iterator var1 = this.listeners.iterator();

        while (var1.hasNext()) {
            IContainerListener listener = (IContainerListener) var1.next();
            listener.sendWindowProperty(this, 4, this.te.getCreosoteAmount());
        }
    }

    public void updateProgressBar(int id, int data) {
        super.updateProgressBar(id, data);
        if (id == 4)
            te.setCreosoteAmount(data);
    }
}