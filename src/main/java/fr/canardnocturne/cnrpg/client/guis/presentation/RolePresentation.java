package fr.canardnocturne.cnrpg.client.guis.presentation;

import net.minecraft.text.Text;

public abstract class RolePresentation {

    private final Text name;

    public RolePresentation(Text name) {
        this.name = name;
    }

    public abstract void dressPlayer();

    public abstract void choose();

    public Text getName() {
        return name;
    }

}
