package fr.canardnocturne.cnrpg.roles;

import fr.canardnocturne.cnrpg.roles.component.CNRPGComponents;
import fr.canardnocturne.cnrpg.roles.component.RoleComponent;
import fr.canardnocturne.cnrpg.roles.component.RoleStatComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

/**
 * @author CanardNocturne
 */
public class RolePlayer implements RoleComponent {

    private static final String key = "role";

    private Role role;
    private final PlayerEntity player;

    public RolePlayer(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public Role getRole() {
        return this.role;
    }

    @Override
    public void setRole(Role role) {
        if(this.role == null) {
            this.role = role;
            CNRPGComponents.ROLE.sync(this.player);

            RoleStat stat = this.role.getStat();
            RoleStatComponent statComp = CNRPGComponents.ROLE_STAT.get(this.player);
            statComp.setHealth(stat.getHealth());
            statComp.setAttack(stat.getAttack());
            statComp.setDefense(stat.getDefense());
            statComp.setSpeed(stat.getSpeed());
            statComp.setRange(stat.getRange());
            CNRPGComponents.ROLE_STAT.sync(this.player);

        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        System.out.println("READ FROM NBT: "+tag);
        if(tag.contains(key))
            this.role = Roles.getById(new Identifier(tag.getString(key)));
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        System.out.println("ROLE NULL: "+ (this.role==null));
        if(this.role != null)
            tag.putString(key, this.role.getIdentifier().toString());
        System.out.println("WRITE FROM NBT: "+tag);
    }

    @Override
    public boolean shouldSyncWith(ServerPlayerEntity player) {
        return player.equals(this.player);
    }

}
