package fr.canardnocturne.cnrpg.roles.component;

import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import fr.canardnocturne.cnrpg.roles.Role;

public interface RoleComponent extends Component, AutoSyncedComponent {

    Role getRole();

    void setRole(Role role);

}
