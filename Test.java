import Factory_CharecterCreator.Human;
import Factory_CharecterCreator.Priest;
import Factory_CharecterCreator.Warrior;
import Factory_CharecterCreator.Wizard;
import Strategy_AttackType.Attack;
import Strategy_AttackType.MageAttack;
import Strategy_AttackType.PhysAttack;

public class Test {
    public static void main(String[] args) {
        Human priest = new Priest("priest one");
        Human warrior = new Warrior("warrior one");
        Human wizard = new Wizard("wizard one");

        Attack Wizard_attack = new Attack();
        Attack Warrior_attack = new Attack();
        Wizard_attack.setAttackType(new MageAttack());
        Warrior_attack.setAttackType(new PhysAttack());
        System.out.println(warrior.getHealthPoints());
        System.out.println(wizard.getHealthPoints());
        Wizard_attack.attack(wizard, warrior);
        Warrior_attack.attack(warrior, wizard);
        priest.giveHeal(warrior);

    }
}
