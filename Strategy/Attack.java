package Strategy;

import Decorator.Character;
import Factory.Human;

public class Attack {
    private AttackType attackType;

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
