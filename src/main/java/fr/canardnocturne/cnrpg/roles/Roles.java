package fr.canardnocturne.cnrpg.roles;

import fr.canardnocturne.cnrpg.CNRPG;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CanardNocturne
 */
public class Roles {

    private static final Map<Identifier, Role> roles = new HashMap<>();

    public static final Role ASSASSIN = register(new Assassin());
    public static final Role WIZARD = register(new Wizard());
    public static final Role BERSEKER = register(new Berseker());

    private static Role register(Role role) {
        roles.put(role.getIdentifier(), role);
        return role;
    }

    public static Role getById(String name) {
        return getById(new Identifier(CNRPG.MOD_ID, name));
    }

    public static Role getById(Identifier identifier) {
        return roles.get(identifier);
    }

    public static Collection<Role> getRoles() {
        return roles.values();
    }

}
