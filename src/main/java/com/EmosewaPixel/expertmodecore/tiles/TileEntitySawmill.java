package com.EmosewaPixel.expertmodecore.tiles;

import com.EmosewaPixel.expertmodecore.recipes.RecipeTypes;
import com.EmosewaPixel.expertmodecore.recipes.RedstoneBasedRecipe;
import com.EmosewaPixel.pixellib.blocks.BlockMachineActivateable;
import com.EmosewaPixel.pixellib.tiles.AbstractTERecipeBased;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class TileEntitySawmill extends AbstractTERecipeBased<RedstoneBasedRecipe> {
    private int curSignal;
    private static int prevSignals[] = new int[8];

    public TileEntitySawmill() {
        super(ExpertTypes.SAWMILL, RecipeTypes.SAWMILL_RECIPES);
    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            curSignal = world.getRedstonePowerFromNeighbors(pos);
            if (getProgress() > 0) {
                if (!getCurrentRecipe().isEmpty()) {
                    int highestPrev = getHighestPrev();
                    if (getCurrentRecipe().needsHighSignal() == (highestPrev > 8) && highestPrev != 0) {
                        for (int prevSignal : prevSignals)
                            if ((prevSignal == 0) != (curSignal == 0)) {
                                world.setBlockState(pos, world.getBlockState(pos).with(BlockMachineActivateable.ACTIVE, true));
                                subtractProgress(1);
                                break;
                            } else
                                world.setBlockState(pos, world.getBlockState(pos).with(BlockMachineActivateable.ACTIVE, false));
                        if (getProgress() == 0)
                            work();
                    } else
                        setProgress(0);
                } else
                    setProgress(0);
            } else
                startWorking();
            if (getProgress() == 0)
                world.setBlockState(pos, world.getBlockState(pos).with(BlockMachineActivateable.ACTIVE, false));
            pushPrevs();
            markDirty();
        }
    }

    protected void startWorking() {
        if (!getCurrentRecipe().isEmpty()) {
            if (getCurrentRecipe().needsHighSignal() != (getHighestPrev() > 8))
                setCurrentRecipe(getRecipeByInput());

            if (canOutput(getCurrentRecipe(), true))
                setProgress(getCurrentRecipe().getTime() - 1);
            else
                world.setBlockState(pos, world.getBlockState(pos).with(BlockMachineActivateable.ACTIVE, false));
        }
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        NBTTagList prevList = compound.getList("Prev", Constants.NBT.TAG_INT);
        for (int i = 0; i < prevList.size(); i++)
            prevSignals[i] = prevList.getCompound(i).getInt("Prev");
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        NBTTagList prevs = new NBTTagList();
        for (int prev : prevSignals) {
            NBTTagCompound aPrev = new NBTTagCompound();
            aPrev.putInt("Prev", prev);
            prevs.add(aPrev);
        }
        compound.put("PrevSignals", prevs);
        return compound;
    }

    private void pushPrevs() {
        for (int i = prevSignals.length - 1; i > 0; i--)
            prevSignals[i] = prevSignals[i - 1];

        prevSignals[0] = curSignal;
    }

    private int getHighestPrev() {
        int highestSignal = curSignal;
        for (int prevSignal : prevSignals)
            if (prevSignal > highestSignal)
                highestSignal = prevSignal;

        return highestSignal;
    }

    protected RedstoneBasedRecipe getRecipeByInput() {
        if (input.getStackInSlot(0).isEmpty())
            return RedstoneBasedRecipe.EMPTY;

        RedstoneBasedRecipe returnRecipe;
        for (RedstoneBasedRecipe recipe : getRecipeList().getReipes())
            if (recipe.isInputValid(new ItemStack[]{input.getStackInSlot(0)}) && recipe.needsHighSignal() == (getHighestPrev() > 8)) {
                returnRecipe = new RedstoneBasedRecipe(new ItemStack[]{new ItemStack(input.getStackInSlot(0).getItem(), recipe.getCountOfInputItem(input.getStackInSlot(0)))}, recipe.getAllOutputs(), recipe.getTime(), recipe.needsHighSignal());
                return returnRecipe;
            }
        return RedstoneBasedRecipe.EMPTY;
    }
}
