package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialBlocks;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IngotMaterial;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materialSystem.types.BlockType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class MaterialBlock extends ModBlock implements IMaterialItem {
    private IngotMaterial material;
    private ObjectType type;

    public MaterialBlock(IngotMaterial mat, BlockType type) {
        super(type.getProperties().hardnessAndResistance(mat.getHarvestTier().getHardness(), mat.getHarvestTier().getResistance()), mat.getName() + "_" + type.getName(), mat.getHarvestTier().getHarvestLevel());
        this.material = mat;
        this.type = type;
        MaterialBlocks.materialBlocks.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public ObjectType getObjType() {
        return type;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public ITextComponent getNameTextComponent() {
        return new TextComponentTranslation("blocktype." + type.getName() + ".name", material.getTranslationKey());
    }
}