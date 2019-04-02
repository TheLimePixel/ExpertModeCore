package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.ItemStack;

public class MachineRecipe {
    private ItemStack[] input;
    private ItemStack output;

    public MachineRecipe(ItemStack[] input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public ItemStack getinput(int index) {
        return input[index];
    }

    public ItemStack getOutput() {
        return output;
    }

    public boolean isInputValid(ItemStack[] stacks) {
        int matches = 0;

        if (stacks.length != input.length)
            return false;

        for (ItemStack stack : stacks)
            for (ItemStack stackRec : input) {
                if (stack.isEmpty() || stackRec.isEmpty())
                    return false;
                if (stack.getItem() == stackRec.getItem() && stack.getCount() >= stackRec.getCount())
                    matches++;
            }

        return matches == stacks.length;
    }
}
