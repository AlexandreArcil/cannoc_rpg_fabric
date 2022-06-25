package fr.canardnocturne.cnrpg.roles.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import fr.canardnocturne.cnrpg.CNRPG;
import fr.canardnocturne.cnrpg.roles.RolePlayer;
import fr.canardnocturne.cnrpg.roles.RoleStatMutable;
import net.minecraft.util.Identifier;

/**
 * @author CanardNocturne
 */
public class CNRPGComponents implements EntityComponentInitializer {

    public static final ComponentKey<RoleStatComponent> ROLE_STAT = ComponentRegistry.getOrCreate(new Identifier(CNRPG.MOD_ID, "role_stat"), RoleStatComponent.class);
    public static final ComponentKey<RoleComponent> ROLE = ComponentRegistry.getOrCreate(new Identifier(CNRPG.MOD_ID, "role"), RoleComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(ROLE_STAT, RoleStatMutable::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerForPlayers(ROLE, RolePlayer::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}
