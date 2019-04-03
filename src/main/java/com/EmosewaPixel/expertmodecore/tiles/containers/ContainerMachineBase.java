package com.EmosewaPixel.expertmodecore.tiles.containers;

import com.EmosewaPixel.expertmodecore.tiles.TileEntityFurnaceBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMachineBase extends Container {
    private TileEntityFurnaceBase te;

    private IItemHandler itemHandler;

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.canInteractWith(playerIn);
    }

    public ContainerMachineBase(IInventory playerInventory, TileEntityFurnaceBase te) {
        this.te = te;

        te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> itemHandler = handler);

        for (int i = 0; i < te.slotCount - 2; i++) {
            this.addSlot(new SlotItemHandler(itemHandler, i, 56 - i * 18, 17));
        }
        this.addSlot(new SlotItemHandler(itemHandler, te.slotCount - 2, 56 - (te.slotCount - 3) * 9, 53));
        this.addSlot(new SlotItemHandler(itemHandler, te.slotCount - 1, 116, 35));

        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < te.slotCount) {
                if (!this.mergeItemStack(itemstack1, te.slotCount, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, te.slotCount, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : listeners) {
            listener.sendWindowProperty(this, 0, te.getProgress());
            listener.sendWindowProperty(this, 1, te.getMaxProgress());
            listener.sendWindowProperty(this, 2, te.getBurnTime());
            listener.sendWindowProperty(this, 3, te.getMaxBurnTime());
        }
    }

    @Override
    public void updateProgressBar(int id, int data) {
        switch (id) {
            case 0:
                te.setProgress(data);
                break;
            case 1:
                te.setMaxProgress(data);
                break;
            case 2:
                te.setBurnTime(data);
                break;
            case 3:
                te.setMaxBurnTime(data);
                break;
        }
    }
}
