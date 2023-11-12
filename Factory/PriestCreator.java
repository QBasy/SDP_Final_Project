package Factory;

import Interfaces.Character;
import Interfaces.CharacterCreator;

public class PriestCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Priest(name);
    }
}
