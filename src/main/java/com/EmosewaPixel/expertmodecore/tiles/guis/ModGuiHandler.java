package com.EmosewaPixel.expertmodecore.tiles.guis;

import com.EmosewaPixel.expertmodecore.tiles.*;
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
            case "expertmodecore:coke_oven":
                return new GUICokeOven(player.inventory, (TileEntityCokeOven) tile);
            case "expertmodecore:crusher":
                return new GUICrusher(player.inventory, (TileEntityCrusher) tile);
            case "expertmodecore:infusion_table":
                return new GUIInfusionTable(player.inventory, (TileEntityInfusionTable) tile);
            default:
                return null;
        }
    }
}
