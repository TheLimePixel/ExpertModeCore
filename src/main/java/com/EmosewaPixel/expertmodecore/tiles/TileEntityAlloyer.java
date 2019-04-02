package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nonnull;

public class TileEntityAlloyer extends TileEntityFurnaceBase implements ITickable {
    public TileEntityAlloyer() {
        super(ExpertTypes.ALLOYER, 2, RecipeTypes.alloyerRecipes);

        input = new ItemStackHandler(2) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityAlloyer.this.markDirty();
            }
        };

        fuel_input = new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return getItemBurnTime(stack) > 0;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityAlloyer.this.markDirty();
            }
        };

        output = new ItemStackHandler(1) {
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return false;
            }

            @Override
            protected void onContentsChanged(int slot) {
                TileEntityAlloyer.this.markDirty();
            }
        };

        combinedHandler = new CombinedInvWrapper(input, fuel_input, output);
    }
}