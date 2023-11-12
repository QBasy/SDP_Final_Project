package StrategyAdapter;

import Interfaces.Character;
import Factory.Warrior;
import Interfaces.AttackType;

public class WarriorAttackAdapter extends Warrior implements Character {
    private AttackType attackType;

    public WarriorAttackAdapter(String name) {
        super(name);
    }
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
