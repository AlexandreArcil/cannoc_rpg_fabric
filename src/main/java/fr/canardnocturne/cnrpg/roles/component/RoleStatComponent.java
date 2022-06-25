package fr.canardnocturne.cnrpg.roles.component;

import dev.onyxstudios.cca.api.v3.component.Component;

public interface RoleStatComponent extends Component {

    int getHealth();

    void setHealth(int health);

    int getAttack();

    void setAttack(int attack);

    int getDefense();

    void setDefense(int defense);

    int getSpeed();

    void setSpeed(int speed);

    int getRange();

    void setRange(int range);

}
