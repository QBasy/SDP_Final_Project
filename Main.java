import Factory_CharecterCreator.*;
import Observer.*;
import Strategy_AttackType.Attack;
import Strategy_AttackType.PhysAttack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Human> allies = new ArrayList<>();
        List<Human> enemy = new ArrayList<>();
        enemy.add(new Wizard("enemy 1"));
        enemy.add(new Warrior("enemy 2"));
        Scanner in = new Scanner(System.in);

        System.out.println("How many Allies you want to create?");
        int n = in.nextInt();
        System.out.println("Who you want to create?");
        for (int i = 0; i < n; i++) {
            System.out.println("1 - Warrior\n2 - Wizard\n3 - Priest");
            allies.add(createCharacter());
        }
        while (true) {
            if (allies.isEmpty()) {
                System.out.println("You Lost!");
                break;
            }
            if (enemy.isEmpty()) {
                System.out.println("You Won!");
                System.exit(0);
            }
            System.out.println("Make your move");
            move(allies, enemy);
            update(allies,enemy);
        }
    }

    public static Human createCharacter() {
        Scanner in = new Scanner(System.in);
        CharecterCreator priestCreator = new PriestCreator();
        CharecterCreator warriorCreator = new WarriorCreator();
        CharecterCreator wizardCreator = new WizardCreator();
        CharecterCreator notWarriorCreator = new NotWarriotCreator();
        switch (in.nextInt()) {
            case 1:
                System.out.println("His/Her name?");
                String name = in.next();
                return warriorCreator.create(name);
            case 2:
                System.out.println("His/Her name?");
                name = in.next();
                return wizardCreator.create(name);
            case 3:
                System.out.println("His/Her name?");
                name = in.next();
                return priestCreator.create(name);
            default:
                return notWarriorCreator.create("Not Warrior");
        }
    }
    public static void move(List<Human> allies, List<Human> enemies) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < allies.size(); i++) {
            System.out.println("choose Action for " + allies.get(i).getName());
            System.out.println("1 - attack\n2 - heal\n3 - give mana\n 4 - skip action");
            int n = in.nextInt();
            boolean loop = true;
            while (loop) {
                int num;
                switch (n) {
                    case 1:
                        Attack attack = new Attack();
                        System.out.println("Choose attack Type: 1 - Physical, 2 - Magical");
                        switch (in.nextInt()) {
                            case 1:
                                attack.setAttackType(new PhysAttack());
                                System.out.println("Which person?");
                                for (int j = 0; j < enemies.size(); j++) {
                                    System.out.println((j+1) + " - " + enemies.get(j).getName());
                                }
                                attack.attack(allies.get(i), enemies.get(in.nextInt() - 1));
                                break;
                        }
                        loop = false;
                        break;
                    case 2:
                        System.out.println("Which person?");
                        for (int j = 0; j < allies.size(); j++) {
                            System.out.println((j+1) + " - " + allies.get(j).getName());
                        }
                        allies.get(i).giveHeal(allies.get(in.nextInt() - 1));
                        loop = false;
                        break;
                    case 3:
                        System.out.println("Which person?");
                        for (int j = 0; j < allies.size(); j++) {
                            System.out.println((j+1) + " - " + allies.get(j).getName());
                        }
                        allies.get(i).giveMana(allies.get(in.nextInt() - 1));
                        loop = false;
                        break;
                    case 4:
                        loop = false;
                    default:
                        System.out.println("FATAL ERROR!!! TRY AGAIN!!!");
                }
            }
        }
    }

    public static void update(List<Human> allies, List<Human> enemy) {
        Observer observer = new ObserverClass();
        for (int i = 0; i < allies.size(); i++) {
            observer.update(allies.get(i));
        }
    }
}
