package Decorator;

import Factory.Human;

public abstract class CharacterDecorator implements Character {
    private Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    public String getDescription() {
         return decoratedCharacter.getDescription();
    }
    public int getHealthPoints() {
        return decoratedCharacter.getHealthPoints();
    }
    public int getDamage() {
        return decoratedCharacter.getDamage();
    }
    public int getMageCost() {
        return decoratedCharacter.getMageCost();
    }
    public int getMageDamage() {
        return decoratedCharacter.getMageDamage();
    }
    public int getMana() {
        return decoratedCharacter.getMana();
    }
    public String getStatus() {
        return decoratedCharacter.getStatus();
    }
    public String getName() {
        return decoratedCharacter.getName();
    }
    public void setMana(int mana) {
        decoratedCharacter.setMana(mana);
    }
    public void setHealthPoints(int HP) {
        decoratedCharacter.setHealthPoints(HP);
    }
    public void setStatus(boolean status) {
        decoratedCharacter.setStatus(status);
    }
    public void giveMana(Character human) {
        decoratedCharacter.giveMana(human);
    }
    public void giveHeal(Character human) {
        decoratedCharacter.giveMana(human);
    }
    public String getWarClass() {
        return decoratedCharacter.getWarClass();
    }
}
