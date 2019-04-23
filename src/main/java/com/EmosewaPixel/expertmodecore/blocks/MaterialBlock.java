package com.EmosewaPixel.expertmodecore.blocks;

import com.EmosewaPixel.expertmodecore.materials.IMaterialItem;
import com.EmosewaPixel.expertmodecore.materials.IngotMaterial;
import com.EmosewaPixel.expertmodecore.materials.Material;
import com.EmosewaPixel.expertmodecore.materials.MaterialBlocks;
import net.minecraft.util.BlockRenderLayer;

public class MaterialBlock extends ModBlock implements IMaterialItem {
    private IngotMaterial material;
    private String type;

    public MaterialBlock(Properties properties, IngotMaterial mat, String type) {
        super(properties.hardnessAndResistance(mat.getHarvestTier().getHardness(), mat.getHarvestTier().getResistance()), mat.getName() + "_" + type, mat.getHarvestTier().getHarvestLevel());
        this.material = mat;
        this.type = type;
        MaterialBlocks.materialBlocks.add(this);
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public String getItemType() {
        return type;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}