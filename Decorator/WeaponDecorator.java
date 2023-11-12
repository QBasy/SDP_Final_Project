package Decorator;

import Factory.Human;
import Interfaces.Character;

public class WeaponDecorator extends CharacterDecorator {
    private Human Decorated;

    public WeaponDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    public int getDamage(Human Decorated) {
        Decorated.setDamage(20);
        return super.getDamage() + 20;
    }

    public String getDescription(Human Decorated) {
        return super.getDescription() + ",Katana+ ";
    }
}
