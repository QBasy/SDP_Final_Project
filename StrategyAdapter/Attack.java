package StrategyAdapter;

import Interfaces.Character;
import Interfaces.AttackType;

public class Attack {
    private AttackType attackType;

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
