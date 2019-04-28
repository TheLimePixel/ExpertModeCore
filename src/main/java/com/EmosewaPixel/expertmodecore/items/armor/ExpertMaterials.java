package com.EmosewaPixel.expertmodecore.items.armor;

import com.EmosewaPixel.expertmodecore.recipes.MachineRecipeAddition;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ExpertMaterials implements IArmorMaterial {
    BRONZE("bronze", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_BRONZE);
    }),
    STEEL("steel", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_STEEL);
    }),
    CRYSTALLINE("crystalline", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_CRYSTALLINE);
    }),
    ELECTRUM("electrum", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, () -> {
        return Ingredient.fromTag(MachineRecipeAddition.INGOTS_ELECTRUM);
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadBase<Ingredient> repairMaterial;

    ExpertMaterials(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadBase(repairMaterial);
    }

    public int getDurability(EntityEquipmentSlot slot) {
        return MAX_DAMAGE_ARRAY[slot.getIndex()] * maxDamageFactor;
    }

    public int getDamageReductionAmount(EntityEquipmentSlot slot) {
        return this.damageReductionAmountArray[slot.getIndex()];
    }

    public int getEnchantability() {
        return enchantability;
    }

    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return name;
    }

    public float getToughness() {
        return toughness;
    }
}
