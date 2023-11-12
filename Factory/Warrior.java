package Factory;

import Decorator.Character;

public class Warrior extends Human {
    private int HealthPoints = 300;
    private int Mana = 50;
    private int damage = 75;
    private int mageDamage = 5;

    public Warrior(String name) {
        super(name);
    }

    @Override
    public int getHealthPoints() {
        return HealthPoints;
    }

    @Override
    public void setMageDamage(int damage) {
        this.mageDamage += damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage += damage;
    }

    @Override
    public void setMana(int mana) {
        this.Mana = mana;
    }

    @Override
    public void setHealthPoints(int HealthPoints) {
        this.HealthPoints = HealthPoints;
    }

    @Override
    public String getDescription() {
        return "Warrior" + getName() + "got an equipment: Sword ";
    }

    @Override
    public int getMageCost() {
        return 10;
    }

    @Override
    public int getMageDamage() {
        return mageDamage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void giveHeal(Character warrior) {
        int heal = 0;
        warrior.setHealthPoints(warrior.getHealthPoints() + heal);
    }

    @Override
    public void giveMana(Character human) {
        System.out.println("Warrior can't restore mana, so you just lost your action");
    }

    @Override
    public int getMana() {
        return Mana;
    }
}
