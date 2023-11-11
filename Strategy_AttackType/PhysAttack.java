package Strategy_AttackType;

import Factory_CharecterCreator.Human;

public class PhysAttack implements AttackType {
    @Override
    public void attack(Human allie, Human enemy) {
        if (enemy.getStatus().equals("Alive")) {
            int HP = enemy.getHealthPoints();
            enemy.setHealthPoints(HP - allie.getDamage());
            if (enemy.getHealthPoints() <= 0) {
                enemy.setStatus(false);
            }
            System.out.println(allie.getName() + " attacking " + enemy.getName());
            System.out.println(enemy.getName() + " lose " + (allie.getDamage()) + " and have " + enemy.getHealthPoints() + " HP\n");
        } else {
            System.out.println(enemy.getName() + " is ALREADY Dead!!!");
        }
    }
}
