package Factory;

import Interfaces.Character;

public class Priest extends Human {
    private String warClass = "Priest";
    private boolean status = true;
    private int HealthPoints = 100;
    private int Mana = 200;
    private int damage = 10;
    private int mageDamage = 35;

    public Priest(String name) {
        super(name);
    }

    @Override
    public int getHealthPoints() {
        return HealthPoints;
    }

    @Override
    public void setMageDamage(int mana) {
        this.mageDamage += mana;
    }

    @Override
    public void setDamage(int damage) {
        this.damage += damage;
    }

    @Override
    public void setMana(int mana) {
        this.Mana += mana;
    }

    @Override
    public void setHealthPoints(int HealthPoints) {
        this.HealthPoints = HealthPoints;
    }

    @Override
    public String getDescription() {
        return "Priest";
    }

    @Override
    public int getMageCost() {
        return 15;
    }

    @Override
    public int getMageDamage() {
        return mageDamage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public void giveHeal(Character human) {
        if (status) {
            if (Mana > 0) {
                if (human.getStatus().equals("Alive")) {
                    int HP = human.getHealthPoints();
                    int heal = 45;
                    human.setHealthPoints(HP + heal);
                } else {
                    System.out.println(human.getName() + " is already Dead");
                }
            } else {
                System.out.println(getName() + "don't have enough Mana");
            }
        } else {
            System.out.println(getName() + " is already Dead");
        }
    }
    public void giveMana(Character human) {
        if (status) {
            if (human.getStatus().equals("Alive")) {
                int Mana = human.getMana();
                int mana = 45;
                human.setMana(Mana + mana);
            } else {
                System.out.println(human.getName() + " is already Dead");
            }
        } else {
            System.out.println(getName() + " is already Dead");
        }
    }

    @Override
    public int getMana() {
        return Mana;
    }

    public String getWarClass() {
        return warClass;
    }
}
