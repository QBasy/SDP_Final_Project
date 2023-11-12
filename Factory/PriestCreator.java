package Factory;

import Decorator.Character;

public class PriestCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Priest(name);
    }
}
