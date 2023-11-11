package Observer;

import Factory_CharecterCreator.Human;

public class ObserverClass implements Observer {
    @Override
    public void update(Human human) {
        System.out.println(human.getName() + " is " + human.getStatus());
        if (human.getStatus().equals("Alive")) {
            System.out.println("HP = " + human.getHealthPoints());
            System.out.println("Mana = " + human.getMana());
        }
    }
}