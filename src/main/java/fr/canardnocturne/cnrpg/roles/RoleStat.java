package fr.canardnocturne.cnrpg.roles;

public class RoleStat {

    private final float speed;
    private final float health;

    public RoleStat(float speed, float health) {
        this.speed = speed;
        this.health = health;
    }

    public float getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }
}
