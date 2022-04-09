package fr.canardnocturne.cnrpg.guis.presentation;

import fr.canardnocturne.cnrpg.roles.Role;

public abstract class RolePresentation {

    private final Role role;

    public RolePresentation(Role role) {
        this.role = role;
    }

    public abstract void dressPlayer();

    public Role getRole() {
        return role;
    }
}
