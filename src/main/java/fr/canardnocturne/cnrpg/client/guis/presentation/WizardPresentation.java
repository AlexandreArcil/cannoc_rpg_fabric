package fr.canardnocturne.cnrpg.client.guis.presentation;

import fr.canardnocturne.cnrpg.roles.Roles;
import fr.canardnocturne.cnrpg.roles.component.CNRPGComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

public class WizardPresentation extends RolePresentation {

    public WizardPresentation() {
        super(new LiteralText("Wizard"));
    }

    @Override
    public void dressPlayer() {

    }

    @Override
    public void choose() {
        CNRPGComponents.ROLE.get(MinecraftClient.getInstance().player).setRole(Roles.WIZARD);
    }

}
