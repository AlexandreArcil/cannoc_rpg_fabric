package fr.canardnocturne.cnrpg.roles;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import fr.canardnocturne.cnrpg.roles.component.RoleStatComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;

/**
 * @author CanardNocturne
 */
public class RoleStatMutable extends RoleStat implements RoleStatComponent, AutoSyncedComponent {

    private final PlayerEntity player;

    public RoleStatMutable(int health, int attack, int defense, int speed, int range, PlayerEntity player) {
        super(health, attack, defense, speed, range);
        this.player = player;
    }

    public RoleStatMutable(PlayerEntity player) {
        super(0, 0, 0, 0, 0);
        this.player = player;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense= defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.health = tag.getInt(HEALTH_KEY);
        this.attack = tag.getInt(ATTACK_KEY);
        this.defense = tag.getInt(DEFENSE_KEY);
        this.speed = tag.getInt(SPEED_KEY);
        this.range = tag.getInt(RANGE_KEY);
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt(HEALTH_KEY, this.health);
        tag.putInt(ATTACK_KEY, this.attack);
        tag.putInt(DEFENSE_KEY, this.defense);
        tag.putInt(SPEED_KEY, this.speed);
        tag.putInt(RANGE_KEY, this.range);
    }

    @Override
    public boolean shouldSyncWith(ServerPlayerEntity player) {
        return player.getUuid().equals(this.player.getUuid());
    }
}
