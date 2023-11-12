package Factory;

import Decorator.Character;

public class NotWarriorCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new NotWarrior(name);
    }
}
