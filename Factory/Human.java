package Factory;

import Interfaces.Character;

public abstract class Human implements Character {
    private final String name;
    private boolean status = true;
    public Human(String name) {
        this.name = name;
    }
    public String getStatus() {
        if (!status) {
            return "Dead";
        }
        return "Alive";
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public abstract int getMageCost();
    public abstract int getMageDamage();
    public abstract int getDamage();
    public abstract void giveHeal(Character warrior);
    public abstract void giveMana(Character human);
    public abstract int getMana();
    public abstract int getHealthPoints();
    public abstract void setMageDamage(int mana);
    public abstract void setDamage(int damage);
    public abstract void setMana(int mana);
    public abstract void setHealthPoints(int HealthPoints);
    public abstract String getDescription();
}
