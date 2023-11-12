package Factory;

import Interfaces.Character;
import Interfaces.CharacterCreator;

public class WarriorCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Warrior(name);
    }
}
