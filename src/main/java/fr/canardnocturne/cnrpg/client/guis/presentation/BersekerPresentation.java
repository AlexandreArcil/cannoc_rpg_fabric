package fr.canardnocturne.cnrpg.client.guis.presentation;

import fr.canardnocturne.cnrpg.roles.Roles;
import fr.canardnocturne.cnrpg.roles.component.CNRPGComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

public class BersekerPresentation extends RolePresentation {

    public BersekerPresentation() {
        super(new LiteralText("Berseker"));
    }

    @Override
    public void dressPlayer() {

    }

    @Override
    public void choose() {
        CNRPGComponents.ROLE.get(MinecraftClient.getInstance().player).setRole(Roles.BERSEKER);
    }
}
