package Factory;

import Decorator.Character;

public class NotWarrior extends Human{
    private int HealthPoints;
    private int Mana;
    private int damage;
    private int mageDamage;
    private int heal;
    private int mageCost;

    public NotWarrior(String name) {
        super(name);
    }

    @Override
    public int getHealthPoints() {
        return HealthPoints;
    }

    @Override
    public void setMageDamage(int mana) {
        this.mageDamage = 0;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = 0;
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
        return ("He is not Warrior and... that's off)))");
    }

    @Override
    public int getMageCost() {
        return mageCost;
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
        System.out.println("He can't even attack, what are you thinking?");
    }

    @Override
    public void giveMana(Character human) {
        System.out.println("He can't even attack, what are you thinking?");
    }

    @Override
    public int getMana() {
        return Mana;
    }
}
