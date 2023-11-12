package Factory;

import Interfaces.Character;
import Interfaces.CharacterCreator;

public class NotWarriorCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new NotWarrior(name);
    }
}
