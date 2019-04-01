package com.EmosewaPixel.expertmodecore.tiles.guis;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityFurnaceBase;
import com.EmosewaPixel.expertmodecore.tiles.containers.ContainerMachineBase;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GUIMachineBase extends GuiContainer {
    private TileEntityFurnaceBase te;
    private String backGround;

    public GUIMachineBase(IInventory playerInventory, TileEntityFurnaceBase te, String backGround) {
        super(new ContainerMachineBase(playerInventory, te));
        this.te = te;
        this.backGround=backGround;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(new ResourceLocation(backGround));
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        int progress;
        if (te.getBurnTime() > 0) {
            progress = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - progress, 176, 12 - progress, 14, progress + 1);
        }

        progress = getProgressLeftScaled(24);
        this.drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, progress + 1, 16);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.render(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);

    }

    private int getProgressLeftScaled(int scale) {
        int progress = te.getProgress();
        if (progress == 0)
            progress = 200;


        return (int) (scale - (float) progress / 200 * scale);
    }

    private int getBurnLeftScaled(int scale) {
        return (int) ((float) te.getBurnTime() / te.getMaxBurnTime() * scale);
    }
}
