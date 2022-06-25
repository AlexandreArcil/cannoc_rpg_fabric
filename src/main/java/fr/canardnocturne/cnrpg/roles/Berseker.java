package fr.canardnocturne.cnrpg.roles;

import fr.canardnocturne.cnrpg.client.guis.presentation.BersekerPresentation;

public class Berseker extends Role{
    public Berseker() {
        super(new RoleStat(50, 50, 50, 50, 50), "berseker", new BersekerPresentation());
    }
}
