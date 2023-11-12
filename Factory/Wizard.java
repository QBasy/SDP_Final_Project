package Factory;

import Decorator.Character;

public class Wizard extends Human {
    private int HealthPoints = 200;
    private int Mana = 150;
    private int damage = 15;
    private int mageDamage = 85;

    public Wizard(String name) {
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
        return "Wizard";
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

    @Override
    public void giveHeal(Character warrior) {
        setHealthPoints(getHealthPoints());
    }

    @Override
    public void giveMana(Character human) {
        setMana(0);
    }

    @Override
    public int getMana() {
        return Mana;
    }
}
