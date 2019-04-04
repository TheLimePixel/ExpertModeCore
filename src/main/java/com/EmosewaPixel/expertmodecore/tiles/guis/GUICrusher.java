package com.EmosewaPixel.expertmodecore.tiles.guis;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityCrusher;
import net.minecraft.inventory.IInventory;

public class GUICrusher extends GUIMachineBase {
    public GUICrusher(IInventory playerInventory, TileEntityCrusher te) {
        super(playerInventory, te, "expertmodecore:textures/gui/container/crusher.png");
    }
}
