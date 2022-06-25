package fr.canardnocturne.cnrpg.client.guis.presentation;

import fr.canardnocturne.cnrpg.items.CNRPGItems;
import fr.canardnocturne.cnrpg.roles.Roles;
import fr.canardnocturne.cnrpg.roles.component.CNRPGComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;

public class AssassinPresentation extends RolePresentation {

    private final ItemStack knife = new ItemStack(CNRPGItems.KNIFE);
    private final ItemStack longSword = new ItemStack(CNRPGItems.LONG_SWORD);
    private final ItemStack boots = new ItemStack(CNRPGItems.ASSASSIN_BOOTS);
    private final ItemStack legs = new ItemStack(CNRPGItems.ASSASSIN_LEGS);
    private final ItemStack chestplate = new ItemStack(CNRPGItems.ASSASSIN_CHESTPLATE);
    private final ItemStack helmet = new ItemStack(CNRPGItems.ASSASSIN_HELMET);

    public AssassinPresentation() {
        super(new LiteralText("Assassin"));
    }

    @Override
    public void dressPlayer() {
        PlayerInventory inventory = MinecraftClient.getInstance().player.getInventory();
        inventory.offHand.set(0, knife);
        inventory.main.set(0, longSword);
        inventory.armor.set(EquipmentSlot.FEET.getEntitySlotId(), boots);
        inventory.armor.set(EquipmentSlot.LEGS.getEntitySlotId(), legs);
        inventory.armor.set(EquipmentSlot.CHEST.getEntitySlotId(), chestplate);
        inventory.armor.set(EquipmentSlot.HEAD.getEntitySlotId(), helmet);
    }

    @Override
    public void choose() {
    }

}
