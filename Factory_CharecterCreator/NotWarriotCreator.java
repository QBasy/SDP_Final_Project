package Factory_CharecterCreator;

public class NotWarriotCreator implements CharecterCreator{
    @Override
    public Human create(String name) {
        return new NotWarrior(name);
    }
}
