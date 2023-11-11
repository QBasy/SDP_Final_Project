package Factory_CharecterCreator;

public class WarriorCreator implements CharecterCreator {
    @Override
    public Human create(String name) {
        return new Warrior(name);
    }
}
