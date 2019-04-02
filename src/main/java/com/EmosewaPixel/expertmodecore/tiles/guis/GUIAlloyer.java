package com.EmosewaPixel.expertmodecore.tiles.guis;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityAlloyer;
import net.minecraft.inventory.IInventory;

public class GUIAlloyer extends GUIMachineBase {
    public GUIAlloyer(IInventory playerInventory, TileEntityAlloyer te) {
        super(playerInventory, te, "expertmodecore:textures/gui/container/alloyer.png");
    }
}
