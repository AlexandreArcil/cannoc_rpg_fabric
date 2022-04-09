package fr.canardnocturne.cnrpg.guis.presentation;

import java.util.ArrayList;
import java.util.List;

public class Presentations {

    public static final List<RolePresentation> ALL = new ArrayList<>();
    public static final RolePresentation ASSASSIN = register(new AssassinPresentation());
    public static final RolePresentation WIZARD = register(new WizardPresentation());
    public static final RolePresentation BERSEKER = register(new BersekerPresentation());

    private static RolePresentation register(RolePresentation rolePresentation) {
        ALL.add(rolePresentation);
        return rolePresentation;
    }

}
