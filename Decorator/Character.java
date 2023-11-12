package Decorator;

public interface Character {
    int getHealthPoints();
    int getDamage();
    int getMageCost();
    int getMageDamage();
    int getMana();
    String getStatus();
    String getName();
    String getDescription();
    void setStatus(boolean status);
    void setMana(int mana);
    void setHealthPoints(int HP);
    void giveMana(Character human);
    void giveHeal(Character human);
}
