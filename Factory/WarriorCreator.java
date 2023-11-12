package Factory;

import Decorator.Character;

public class WarriorCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Warrior(name);
    }
}
