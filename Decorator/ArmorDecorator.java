package Decorator;

import Factory.Human;
import Interfaces.Character;

public class ArmorDecorator extends CharacterDecorator {
    private Human Decorated;
    public ArmorDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    public void setHealthPoints(Human Decorated) {
        Decorated.setHealthPoints(Decorated.getHealthPoints() + 35);
    }

    public String getDescription(Human Decorated) {
        return super.getDescription() + ",Armor ";
    }
}
