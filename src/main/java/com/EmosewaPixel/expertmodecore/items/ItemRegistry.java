package com.EmosewaPixel.expertmodecore.items;

import com.EmosewaPixel.expertmodecore.ExpertModeCore;
import com.EmosewaPixel.expertmodecore.items.armor.MaterialArmor;
import com.EmosewaPixel.expertmodecore.items.tools.*;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialItems;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.MaterialsAndTextureTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.lists.ObjTypes;
import com.EmosewaPixel.expertmodecore.materialSystem.materials.Material;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ItemType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.ObjectType;
import com.EmosewaPixel.expertmodecore.materialSystem.types.TextureType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class ItemRegistry {
    public static Item BRICK_MOLD;
    public static Item COKE_BRICK;
    public static Item COAL_COKE;
    public static Item CREOSOTE_BUCKET;
    public static Item CREOSOTE_BOTTLE;
    public static Item IRONWOOD_STICK;
    public static Item PEBBLE;
    public static Item REDWOOD_STICK;
    public static Item RUBBER_DROP;
    public static Item TREATED_STICK;
    public static Item UNFIRED_BRICK;
    public static Item UNFIRED_COKE_BRICK;
    public static Item UNLIT_TORCH;

    public static void registry(RegistryEvent.Register<Item> e) {
        for (Material mat : MaterialsAndTextureTypes.materials) {
            for (ObjectType type : ObjTypes.objTypes)
                if (type instanceof ItemType && type.isMaterialCompatible(mat))
                    if (!MaterialItems.contains(mat, type))
                        register(new MaterialItem(mat, type), e);

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

        for (ObjectType objT : ObjTypes.objTypes)
            if (objT instanceof ItemType)
                for (TextureType textureT : MaterialsAndTextureTypes.textureTypes)
                    register(new Item(new Item.Properties()).setRegistryName("expertmodecore:" + textureT.toString() + "_" + objT.getName()), e);

        BRICK_MOLD = register(new SelfContainerItem("brick_mold"), e);
        COKE_BRICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:coke_brick"), e);
        COAL_COKE = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:coke_coal"), e);
        CREOSOTE_BUCKET = register(new FakeFluidContainer("creosote_bucket", Items.BUCKET), e);
        CREOSOTE_BOTTLE = register(new FakeFluidContainer("creosote_bottle", Items.GLASS_BOTTLE), e);
        IRONWOOD_STICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:ironwood_stick"), e);
        PEBBLE = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:pebble"), e);
        REDWOOD_STICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:redwood_stick"), e);
        RUBBER_DROP = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:rubber_drop"), e);
        TREATED_STICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:treated_stick"), e);
        UNFIRED_BRICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:unfired_brick"), e);
        UNFIRED_COKE_BRICK = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:unfired_coke_brick"), e);
        UNLIT_TORCH = register(new Item(new Item.Properties().group(ExpertModeCore.main)).setRegistryName("expertmodecore:unlit_torch"), e);
    }

    private static Item register(Item item, RegistryEvent.Register<Item> e) {
        e.getRegistry().register(item);
        return item;
    }
}
