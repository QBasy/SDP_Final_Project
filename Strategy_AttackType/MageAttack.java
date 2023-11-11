package Strategy_AttackType;

import Factory_CharecterCreator.Human;

public class MageAttack implements AttackType{
    public void attack(Human allie, Human enemy) {
        if (enemy.getStatus().equals("Alive")) {
            if (allie.getMana() > 0) {
                allie.setMana(allie.getMana() - allie.getMageCost());
                int HP = enemy.getHealthPoints();
                enemy.setHealthPoints(HP - allie.getMageDamage());
                if (enemy.getHealthPoints() <= 0) {
                    enemy.setStatus(false);
                }
                System.out.println(allie.getName() + " attacking " + enemy.getName());
                System.out.println(enemy.getName() + " lose " + (allie.getMageDamage()) + " and have " + enemy.getHealthPoints() + " HP\n");
            } else {
                System.out.println(allie.getName() + " needs to get Mana");
            }
        } else {
            System.out.println(allie.getName() + " is ALREADY Dead!!!");
        }
    }
}
