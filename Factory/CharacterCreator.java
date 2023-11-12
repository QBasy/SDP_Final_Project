package Factory;

import Decorator.Character;

public interface CharacterCreator {
    Character create(String name);
}
