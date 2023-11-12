package Factory;

import Decorator.Character;

public class WizardCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Wizard(name);
    }
}
