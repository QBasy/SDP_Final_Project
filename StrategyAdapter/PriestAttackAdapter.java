package StrategyAdapter;

import Decorator.Character;
import Factory.Priest;

public class PriestAttackAdapter extends Priest implements Character {
    private AttackType attackType;

    public PriestAttackAdapter(String name) {
        super(name);
    }
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
