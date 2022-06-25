package fr.canardnocturne.cnrpg.roles;

public class RoleStat { //TODO RoleStatMuable impl Component plutot ?

    protected static final String HEALTH_KEY = "health";
    protected static final String ATTACK_KEY = "attack";
    protected static final String DEFENSE_KEY = "defense";
    protected static final String SPEED_KEY = "speed";
    protected static final String RANGE_KEY = "range";

    protected int health;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int range;
//    protected final PlayerEntity player;

    public RoleStat(int health, int attack, int defense, int speed, int range/*, PlayerEntity player*/) {
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.health = health;
        this.range = range;
//        this.player = player;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRange() {
        return range;
    }

    /*public PlayerEntity getPlayer() {
        return player;
    }*/


}
