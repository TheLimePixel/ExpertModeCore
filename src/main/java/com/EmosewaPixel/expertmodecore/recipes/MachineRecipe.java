package com.EmosewaPixel.expertmodecore.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;
import java.util.List;

public class MachineRecipe implements INBTSerializable<NBTTagCompound> {
    private Object[] input;
    private ItemStack[] output;
    private int time;

    public MachineRecipe(Object[] input, ItemStack[] output, int time) {
        this.input = input;
        this.output = output;
        this.time = time;
    }

    public Object getInput(int index) {
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

    public void setTime(int time) {
        this.time = time;
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

    public int getCountOfInputItem(ItemStack stack) {
        for (Object input : input) {
            if (input instanceof ItemStack)
                if (stack.getItem() == ((ItemStack) input).getItem())
                    return ((ItemStack) input).getCount();
            if (((TagStack) input).geTag().contains(stack.getItem()))
                return ((TagStack) input).getCount();
        }
        return 0;
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

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagList inputList = new NBTTagList();
        for (Object obj : input)
            if (obj instanceof ItemStack) {
                if (!((ItemStack) obj).isEmpty()) {
                    NBTTagCompound itemTag = new NBTTagCompound();
                    itemTag.setString("Type", "Item");
                    ((ItemStack) obj).write(itemTag);
                    inputList.add(itemTag);
                }
            } else {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setString("Type", "Tag");
                ((TagStack) obj).write(itemTag);
                inputList.add(itemTag);
            }
        NBTTagList outputList = new NBTTagList();
        for (ItemStack stack : output)
            if (!stack.isEmpty()) {
                NBTTagCompound itemTag = new NBTTagCompound();
                stack.write(itemTag);
                outputList.add(itemTag);
            }
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInt("Time", time);
        nbt.setTag("Outputs", outputList);
        nbt.setTag("Inputs", inputList);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        setTime(nbt.getInt("Time"));
        NBTTagList tagList = nbt.getList("Outputs", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.size(); i++)
            output[i] = ItemStack.read(tagList.getCompound(i));
        tagList = nbt.getList("Inputs", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.size(); i++) {
            NBTTagCompound thing = tagList.getCompound(i);
            if (thing.getString("Type").equals("Item"))
                input[i] = ItemStack.read(thing);
            if (thing.getString("Type").equals("Tag"))
                input[i] = TagStack.read(thing);
        }
    }
}
