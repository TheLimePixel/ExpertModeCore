package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.ItemStack;

public class MachineRecipe {
    private Object[] input;
    private ItemStack[] output;
    private int time;

    public MachineRecipe(Object[] input, ItemStack[] output, int time) {
        this.input = input;
        this.output = output;
        this.time = time;
    }

    public Object getinput(int index) {
        return input[index];
    }

    public ItemStack getOutput(int index) {
        return output[index];
    }

    public ItemStack[] getAllOutputs() {
        return output;
    }

    public int getTime() {
        return time;
    }

    public boolean isInputValid(ItemStack[] stacks) {
        int matches = 0;

        if (stacks.length != input.length)
            return false;

        for (ItemStack stack : stacks) {
            if (stack.isEmpty())
                return false;
            for (Object stackRec : input) {
                if (stackRec instanceof ItemStack) {
                    if (((ItemStack) stackRec).isEmpty())
                        return false;
                    if (stack.getItem() == ((ItemStack) stackRec).getItem() && stack.getCount() >= ((ItemStack) stackRec).getCount())
                        matches++;
                }
                if (stackRec instanceof TagStack) {
                    if (((TagStack) stackRec).isEmpty())
                        return false;
                    if (((TagStack) stackRec).geTag().contains(stack.getItem()) && stack.getCount() >= ((TagStack) stackRec).getCount())
                        matches++;
                }
            }
        }

        return matches == stacks.length;
    }

    public boolean itemBelongsInRecipe(ItemStack stack) {
        if (stack.isEmpty())
            return false;

        for (Object stackRec : input) {
            if (stackRec instanceof ItemStack) {
                if (((ItemStack) stackRec).getItem() == stack.getItem())
                    return true;
            } else if (((TagStack) stackRec).geTag().contains(stack.getItem()))
                return true;
        }
        return false;
    }
}
