package com.EmosewaPixel.expertmodecore.items;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.blocks.MaterialBlock;
import com.EmosewaPixel.expertmodecore.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materials.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MaterialItemBlock extends ItemBlock implements IMaterialItem {
    private MaterialBlock block;

    public MaterialItemBlock(MaterialBlock block) {
        super(block, new Item.Properties().group(ExpertModeCore.main));
        this.block = block;
        setRegistryName(block.getRegistryName());
    }

    @Override
    public Material getMaterial() {
        return block.getMaterial();
    }

    @Override
    public String getItemType() {
        return block.getItemType();
    }
}
