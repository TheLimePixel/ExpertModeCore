package com.EmosewaPixel.expertmodecore.tiles.guis;

import com.EmosewaPixel.expertmodecore.tiles.*;
import com.EmosewaPixel.pixellib.tiles.TEFuelBased;
import com.EmosewaPixel.pixellib.tiles.TERecipeBased;
import com.EmosewaPixel.pixellib.tiles.guis.GUIFuelBasedMachine;
import com.EmosewaPixel.pixellib.tiles.guis.GUIRecipeBasedMachine;
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
                return new GUIFuelBasedMachine(player.inventory, (TEFuelBased) tile, "expertmodecore:textures/gui/container/alloyer.png");
            case "expertmodecore:blast_furnace":
                return new GUIFuelBasedMachine(player.inventory, (TEFuelBased) tile, "textures/gui/container/furnace.png");
            case "expertmodecore:coke_oven":
                return new GUICokeOven(player.inventory, (TileEntityCokeOven) tile);
            case "expertmodecore:crusher":
                return new GUIFuelBasedMachine(player.inventory, (TEFuelBased) tile, "expertmodecore:textures/gui/container/crusher.png");
            case "expertmodecore:infusion_table":
                return new GUIRecipeBasedMachine<>(player.inventory, (TERecipeBased) tile, "expertmodecore:textures/gui/container/infusion_table.png");
            case "expertmodecore:sawmill":
                return new GUIRecipeBasedMachine<>(player.inventory, (TileEntitySawmill) tile, "expertmodecore:textures/gui/container/sawmill.png");
            default:
                return null;
        }
    }
}
