package Factory;

import Interfaces.Character;
import Interfaces.CharacterCreator;

public class WizardCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Wizard(name);
    }
}
