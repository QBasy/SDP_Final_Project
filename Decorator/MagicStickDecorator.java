package Decorator;

import Factory.Human;
import Interfaces.Character;

public class MagicStickDecorator extends CharacterDecorator{
    private Human Decorated;
    public MagicStickDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    public int getMageDamage(Human Decorated) {
        Decorated.setMageDamage(15);
        return super.getMageDamage() + 15;
    }

    public String getDescription(Human Decorated) {
        return super.getDescription() + ", Magic Stick";
    }
}
