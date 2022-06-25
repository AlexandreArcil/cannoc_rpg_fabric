package fr.canardnocturne.cnrpg.roles;

import fr.canardnocturne.cnrpg.client.guis.presentation.WizardPresentation;

public class Wizard extends Role {
    public Wizard() {
        super(new RoleStat(50, 50, 50, 50, 50), "wizard",  new WizardPresentation());
    }
}
