package Factory_CharecterCreator;

public class Test {
    public static void main(String[] args) {
        Priest priest = new Priest("priest one");
        Warrior warrior = new Warrior("warrior one");
        Wizard wizard = new Wizard("wizard one");

        priest.giveHeal(warrior);
        wizard.mageAttack(warrior);
    }
}
