package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<ItemStack>> getInputsAsList() {
        List<List<ItemStack>> list = new ArrayList<>();
        for (Object stack : input) {
            List<ItemStack> singleList = new ArrayList<>();
            if (stack instanceof ItemStack)
                singleList.add((ItemStack) stack);
            else
                for (Item stackitem : ((TagStack) stack).geTag().getAllElements())
                    singleList.add(new ItemStack(stackitem, ((TagStack) stack).getCount()));
            list.add(singleList);
        }

        return list;
    }

    public List<ItemStack> getOutputsAsList() {
        List<ItemStack> list = new ArrayList<>();
        for (ItemStack stack : output)
            list.add(stack);
        return list;
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
