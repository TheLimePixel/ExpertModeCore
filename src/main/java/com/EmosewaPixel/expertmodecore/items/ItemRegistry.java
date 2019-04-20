package com.EmosewaPixel.expertmodecore.items;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.items.armor.MaterialArmor;
import com.EmosewaPixel.expertmodecore.items.tools.*;
import com.EmosewaPixel.expertmodecore.materials.DustMaterial;
import com.EmosewaPixel.expertmodecore.materials.IngotMaterial;
import com.EmosewaPixel.expertmodecore.materials.Material;
import com.EmosewaPixel.expertmodecore.materials.MaterialList;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class ItemRegistry {
    public static Item BRICK_MOLD;
    public static Item COKE_BRICK;
    public static Item COKE_COKE;
    public static Item CREOSOTE_BUCKET;
    public static Item CREOSOTE_BOTTLE;
    public static Item CRUSHED_MAGMA_BLOCK;
    public static Item IRONWOOD_STICK;
    public static Item NETHERRACK_DUST;
    public static Item PEBBLE;
    public static Item REDWOOD_STICK;
    public static Item RUBBER_DROP;
    public static Item STONE_DUST;
    public static Item SMALL_STONE_DUST;
    public static Item TREATED_STICK;
    public static Item UNFIRED_BRICK;
    public static Item UNFIRED_COKE_BRICK;

    public static void registry(RegistryEvent.Register<Item> e) {
        for (Material mat : MaterialList.materials) {
            if (mat instanceof IngotMaterial) {
                if (mat.doesHaveBase()) {
                    register(new MaterialItem(mat, "ingot"), e);
                    register(new MaterialItem(mat, "nugget"), e);
                }
                register(new MaterialItem(mat, "plate"), e);
            }

            if (mat instanceof DustMaterial)
                register(new MaterialItem(mat, "dust"), e);

            if (mat.getArmorMaterial() != null)
                for (EntityEquipmentSlot slot : new EntityEquipmentSlot[]{EntityEquipmentSlot.CHEST, EntityEquipmentSlot.FEET, EntityEquipmentSlot.HEAD, EntityEquipmentSlot.LEGS})
                    register(new MaterialArmor(mat, slot), e);

            if (mat.getItemTier() != null) {
                register(new MaterialAxe(mat), e);
                register(new MaterialHoe(mat), e);
                register(new MaterialHammer(mat), e);
                register(new MaterialPick(mat), e);
                register(new MaterialSaw(mat), e);
                register(new MaterialShovel(mat), e);
                register(new MaterialSword(mat), e);
            }
        }

        BRICK_MOLD = register(new SelfContainerItem("brick_mold"), e);
        COKE_BRICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("coke_brick"), e);
        COKE_COKE = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("coke_coal"), e);
        CREOSOTE_BUCKET = register(new FakeFluidContainer("creosote_bucket", Items.BUCKET), e);
        CREOSOTE_BOTTLE = register(new FakeFluidContainer("creosote_bottle", Items.GLASS_BOTTLE), e);
        CRUSHED_MAGMA_BLOCK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("crushed_magma_cream"), e);
        IRONWOOD_STICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("ironwood_stick"), e);
        NETHERRACK_DUST = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("netherrack_dust"), e);
        PEBBLE = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("pebble"), e);
        REDWOOD_STICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("redwood_stick"), e);
        RUBBER_DROP = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("rubber_drop"), e);
        SMALL_STONE_DUST = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("small_stone_dust"), e);
        STONE_DUST = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("stone_dust"), e);
        TREATED_STICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("treated_stick"), e);
        UNFIRED_BRICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("unfired_brick"), e);
        UNFIRED_COKE_BRICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("unfired_coke_brick"), e);
    }

    private static Item register(Item item, RegistryEvent.Register<Item> e) {
        e.getRegistry().register(item);
        return item;
    }
}
