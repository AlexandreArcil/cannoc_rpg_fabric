package fr.canardnocturne.cnrpg.roles;

import fr.canardnocturne.cnrpg.client.guis.presentation.AssassinPresentation;

public class Assassin extends Role {
    public Assassin() {
        super(new RoleStat(50, 50, 50, 50, 50), "assassin", new AssassinPresentation());
    }
}
