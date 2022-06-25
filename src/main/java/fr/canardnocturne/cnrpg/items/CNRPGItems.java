package fr.canardnocturne.cnrpg.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class CNRPGItems {

    public static final Item KNIFE = new KnifeItem(new FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT));
    public static final Item LONG_SWORD = new LongSwordItem(new FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT));

    public static final ArmorMaterial ASSASSIN_MATERIAL = new AssassinArmorMaterial();
    public static final Item ASSASSIN_BOOTS = new ArmorItem(ASSASSIN_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item ASSASSIN_LEGS = new ArmorItem(ASSASSIN_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item ASSASSIN_CHESTPLATE = new ArmorItem(ASSASSIN_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item ASSASSIN_HELMET = new ArmorItem(ASSASSIN_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));



}
