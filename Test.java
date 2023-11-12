import Factory.Human;
import Factory.Priest;
import Factory.Warrior;
import Factory.Wizard;
import Strategy.Attack;
import Strategy.MageAttack;
import Strategy.PhysAttack;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(0, 1);
        list.add(0,2);
        System.out.println(list.get(1));
        list.add(1,2);
        list.remove(0);
        list.add(0, 3);
        System.out.println(list.get(0) + " " + list.get(1));
    }
}
