package Factory_CharecterCreator;

public class Test {
    public static void main(String[] args) {
        Priest priest = new Priest();
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        priest.giveHeal(warrior);
    }
}
