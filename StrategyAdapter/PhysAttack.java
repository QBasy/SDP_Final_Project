package StrategyAdapter;

import Interfaces.Character;
import Interfaces.AttackType;

public class PhysAttack implements AttackType {
    @Override
    public void attack(Character allie, Character enemy) {
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
