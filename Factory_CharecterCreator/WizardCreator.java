package Factory_CharecterCreator;

public class WizardCreator implements CharecterCreator{
    @Override
    public Human create(String name) {
        return new Wizard(name);
    }
}
