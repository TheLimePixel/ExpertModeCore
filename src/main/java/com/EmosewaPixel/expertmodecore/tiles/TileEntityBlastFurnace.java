package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.pixellib.blocks.BlockMachineFuelBased;
import com.EmosewaPixel.pixellib.tiles.TEFuelBased;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;

public class TileEntityBlastFurnace extends TEFuelBased {
    public TileEntityBlastFurnace() {
        super(ExpertTypes.BLAST_FURNACE, RecipeTypes.BLAST_FURNACE_RECIPES);
        fuel_input = new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return RecipeTypes.blastFurnaceFuels.contains(stack.getItem());
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
        if (RecipeTypes.blastFurnaceFuels.contains(fuel) && canOutput(getCurrentRecipe(), true)) {
            setBurnTime(getItemBurnTime(fuel_input.getStackInSlot(0)));
            setMaxBurnTime(getItemBurnTime(fuel_input.getStackInSlot(0)));
            fuel_input.extractItem(0, 1, false);
        } else
            world.setBlockState(pos, world.getBlockState(pos).with(BlockMachineFuelBased.LIT, false));
    }
}