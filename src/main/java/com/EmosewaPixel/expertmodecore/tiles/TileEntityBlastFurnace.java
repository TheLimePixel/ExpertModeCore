package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;

public class TileEntityBlastFurnace extends TileEntityFurnaceBase implements ITickable {
    public TileEntityBlastFurnace() {
        super(ExpertTypes.BLAST_FURNACE, 1, RecipeTypes.blastFurnaceRecipes);
        fuel_input = new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() == Items.COAL || stack.getItem() == Items.CHARCOAL || stack.getItem() == Blocks.COAL_BLOCK.asItem();
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityBlastFurnace.this.markDirty();
            }
        };

        combinedHandler = new CombinedInvWrapper(input, fuel_input, output);
    }

    @Override
    protected void consumeFuel() {
        Item fuel = fuel_input.getStackInSlot(0).getItem();
        if ((fuel == Items.COAL || fuel == Items.CHARCOAL || fuel == Blocks.COAL_BLOCK.asItem()) && getRecipeByInput() != null) {
            setBurnTime(getItemBurnTime(fuel_input.getStackInSlot(0)));
            setMaxBurnTime(getItemBurnTime(fuel_input.getStackInSlot(0)));
            fuel_input.extractItem(0, 1, false);
        }
    }
}