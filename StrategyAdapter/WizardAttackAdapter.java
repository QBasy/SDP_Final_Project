package StrategyAdapter;

import Decorator.Character;
import Factory.Wizard;

public class WizardAttackAdapter extends Wizard implements Character {
    private AttackType attackType;

    public WizardAttackAdapter(String name) {
        super(name);
    }
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
