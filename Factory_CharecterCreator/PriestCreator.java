package Factory_CharecterCreator;

public class PriestCreator implements CharecterCreator {
    @Override
    public Human create(String name) {
        return new Priest(name);
    }
}
