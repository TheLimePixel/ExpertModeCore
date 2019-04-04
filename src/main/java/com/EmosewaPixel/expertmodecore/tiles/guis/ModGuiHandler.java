package com.EmosewaPixel.expertmodecore.tiles.guis;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityAlloyer;
import com.EmosewaPixel.expertmodecore.tiles.TileEntityBlastFurnace;
import com.EmosewaPixel.expertmodecore.tiles.TileEntityCrusher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class ModGuiHandler {
    public static GuiScreen guis(FMLPlayMessages.OpenContainer container) {
        EntityPlayer player = Minecraft.getInstance().player;
        TileEntity tile = player.world.getTileEntity(container.getAdditionalData().readBlockPos());
        switch (container.getId().toString()) {
            case "expertmodecore:alloyer":
                return new GUIAlloyer(player.inventory, (TileEntityAlloyer) tile);
            case "expertmodecore:blast_furnace":
                return new GUIBlastFurnace(player.inventory, (TileEntityBlastFurnace) tile);
            case "expertmodecore:crusher":
                return new GUICrusher(player.inventory, (TileEntityCrusher) tile);
            default:
                return null;
        }
    }
}
