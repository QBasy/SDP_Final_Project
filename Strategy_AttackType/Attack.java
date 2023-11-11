package Strategy_AttackType;

import Factory_CharecterCreator.Human;

public class Attack {
    private AttackType attackType;

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Human allie, Human enemy) {
        attackType.attack(allie, enemy);
    }
}
