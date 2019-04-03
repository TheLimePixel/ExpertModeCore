package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class MachineRecipe {
    private Object[] input;
    private ItemStack output;

    public MachineRecipe(Object[] input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public Object getinput(int index) {
        return input[index];
    }

    public ItemStack getOutput() {
        return output;
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
                if (stackRec instanceof StringStack) {
                    if (((StringStack) stackRec).isEmpty())
                        return false;
                    if (new ItemTags.Wrapper(new ResourceLocation("forge", ((StringStack) stackRec).getString())).contains(stack.getItem()) && stack.getCount() >= ((StringStack) stackRec).getCount())
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
            } else if (new ItemTags.Wrapper(new ResourceLocation("forge", ((StringStack) stackRec).getString())).contains(stack.getItem()))
                return true;
        }
        return false;
    }
}
