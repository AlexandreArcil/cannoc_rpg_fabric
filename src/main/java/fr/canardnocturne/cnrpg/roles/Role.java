package fr.canardnocturne.cnrpg.roles;

import fr.canardnocturne.cnrpg.CNRPG;
import fr.canardnocturne.cnrpg.client.guis.presentation.RolePresentation;
import net.minecraft.util.Identifier;

public class Role {

    private final RoleStat stat;
    private final Identifier identifier;
    private final RolePresentation presentation;

    public Role(RoleStat stat, String path, RolePresentation presentation) {
        this(stat, new Identifier(CNRPG.MOD_ID, path), presentation);
    }

    public Role(RoleStat stat, Identifier identifier, RolePresentation presentation) {
        this.stat = stat;
        this.identifier = identifier;
        this.presentation = presentation;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public RolePresentation getPresentation() {
        return presentation;
    }

    public RoleStat getStat() {
        return stat;
    }
}
