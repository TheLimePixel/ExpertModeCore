package com.EmosewaPixel.expertmodecore.items.tools;

import com.EmosewaPixel.expertmodecore.recipes.MachineRecipeAddition;
import net.minecraft.init.Items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum ExpertTiers implements IItemTier {
    FLINT(0, 60, 2, 0, 15, () -> {
        return Ingredient.fromItems(Items.FLINT);
    }),
    BRONZE(1, 172, 4, 1, 5, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_BRONZE);
    }),
    STEEl(2, 320, 6, 2, 14, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_STEEL);
    }),
    CRYSTALLINE(3, 2030, 8, 3, 10, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_CRYSTALLINE);
    }),
    ELECTRUM(1, 96, 12, 0, 22, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_ELECTRUM);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    ExpertTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
