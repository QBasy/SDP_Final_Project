import Decorator.ArmorDecorator;
import Interfaces.Character;
import Decorator.MagicStickDecorator;
import Decorator.WeaponDecorator;
import Factory.*;
import Interfaces.CharacterCreator;
import ObserverSingleton.Observer;
import ObserverSingleton.ObserverClass;
import StrategyAdapter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Observer observer = ObserverClass.getInstance();
        Scanner in = new Scanner(System.in);

        List<Character> allies = new ArrayList<>();
        List<Character> enemy = new ArrayList<>();

        enemy.add(createEnemy());
        enemy.add(createEnemy());

        System.out.println("How many Allies you want to create?");
        int n;
        while (true) {
            n = in.nextInt();
            if (n > 3) {
                System.out.println("Allies can't be more than 3");
            } else {
                break;
            }
        }

        System.out.println("Who you want to create?");
        for (int i = 0; i < n; i++) {
            System.out.println("1 - Warrior\n2 - Wizard\n3 - Priest");
            allies.add(createCharacter());
        }
        System.out.println("You can spend your own Mana Points to get something from inventory, you can get something 1");
        System.out.println("1 - Yes\n (any other number) - No");
        if (in.nextInt() == 1) {
            System.out.println("Ok");
            System.out.println("For who?");
            for (int i = 0; i < allies.size(); i++) {
                System.out.print((i + 1) + " - " + allies.get(i).getName());
            }
            inventory(allies, (in.nextInt() - 1));
        } else {
            System.out.println("Ok");
        }

        while (true) {
            if (allies.isEmpty()) {
                System.out.println("You Lost!");
                break;
            }
            if (enemy.isEmpty()) {
                System.out.println("You Won!");
                break;
            }
            System.out.println("Make your move");
            move(allies, enemy);
            enemyMove(enemy, allies);
            observer.update(allies,enemy);
        }
    }
    public static void inventory(List<Character> human, int index) {
        Scanner in = new Scanner(System.in);

        System.out.println("Which One?");
        System.out.println("1 - Armor, 2 - Magic Wand, 3 - Katana");

        switch (in.nextInt()) {
            case 1:
                Character Armored = new ArmorDecorator(human.get(index));
                human.remove(index);
                human.add(index, Armored);
                break;
            case 2:
                Character MagicStick = new MagicStickDecorator(human.get(index));
                human.remove(index);
                human.add(index, MagicStick);
                break;
            case 3:
                Character Weapon = new WeaponDecorator(human.get(index));
                human.remove(index);
                human.add(index, Weapon);
                break;
            default:
                System.out.println("You chose nothing(((");
                break;
        }
    }
    public static void enemyMove(List<Character> enemy, List<Character> allies) {
        System.out.println("Now wait for Enemy move");
        for (Character character : enemy) {
            int gettingPerson = (int) ((Math.random() * (allies.size() - 1)));
            int move = (int) ((Math.random() * (5 - 1)));
            switch (move) {
                case 1:
                    Attack physAttack = new Attack();
                    physAttack.setAttackType(new PhysAttack());
                    physAttack.attack(character, allies.get(gettingPerson));
                    System.out.println();
                    break;
                case 2:
                    Attack magicAttack = new Attack();
                    magicAttack.setAttackType(new MageAttack());
                    magicAttack.attack(character, allies.get(gettingPerson));
                    System.out.println();
                    break;
                case 3:
                    character.giveHeal(enemy.get(gettingPerson));
                    System.out.println();
                    break;
                case 4:
                    character.giveMana(enemy.get(gettingPerson));
                    System.out.println();
                    break;
            }
        }
    }
    public static void move(List<Character> allies, List<Character> enemies) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < allies.size(); i++) {
            if (allies.get(i).getStatus().equals("Dead")) {
                i++;
            }
            System.out.println("choose Action for " + allies.get(i).getName());
            System.out.println("1 - attack\n2 - heal\n3 - give mana\n 4 - skip action");
            int n = in.nextInt();
            boolean loop = true;
            while (loop) {
                switch (n) {
                    case 1:
                        String warClass = allies.get(i).getWarClass();
                        String characterName = allies.get(i).getName();
                        switch (warClass) {
                            case "Warrior":
                                allies.remove(i);
                                var warrior = new WarriorAttackAdapter(characterName);
                                warrior.setAttackType(new PhysAttack());
                                allies.add(i, warrior);
                                System.out.println("Which person?");
                                for (int j = 0; j < enemies.size(); j++) {
                                    System.out.println((j+1) + " - " + enemies.get(j).getName());
                                }
                                warrior.attack(allies.get(i), enemies.get(in.nextInt() - 1));
                                System.out.println();
                                break;
                            case "Wizard":
                                allies.remove(i);
                                var wizard = new WizardAttackAdapter(characterName);
                                wizard.setAttackType(new MageAttack());
                                allies.add(i, wizard);
                                System.out.println("Which person?");
                                for (int j = 0; j < enemies.size(); j++) {
                                    System.out.println((j+1) + " - " + enemies.get(j).getName());
                                }
                                wizard.attack(allies.get(i), enemies.get(in.nextInt() - 1));
                                System.out.println();
                                break;
                            case "Priest":
                                System.out.println("Which person?");
                                for (int j = 0; j < enemies.size(); j++) {
                                    System.out.println((j+1) + " - " + enemies.get(j).getName());
                                }
                                String enemyName = enemies.get(in.nextInt()).getName();
                                System.out.println("Priest tries to attack " + enemyName + ", but GOD doesn't allows that");
                                break;
                            case "NotWarrior":
                                System.out.println("Which person?");
                                for (int j = 0; j < enemies.size(); j++) {
                                    System.out.println((j+1) + " - " + enemies.get(j).getName());
                                }
                                in.nextInt();
                                System.out.println("He doesn't even tries to hit, he is not Warrior");
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
                        System.out.println();
                        loop = false;
                        break;
                    case 3:
                        System.out.println("Which person?");
                        for (int j = 0; j < allies.size(); j++) {
                            System.out.println((j+1) + " - " + allies.get(j).getName());
                        }
                        allies.get(i).giveMana(allies.get(in.nextInt() - 1));
                        System.out.println();
                        loop = false;
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                        System.out.println("FATAL ERROR!!! TRY AGAIN!!!");
                        System.out.println();
                        break;
                }
            }
        }
    }
    public static Character createCharacter() {
        Scanner in = new Scanner(System.in);

        CharacterCreator priestCreator = new PriestCreator();
        CharacterCreator warriorCreator = new WarriorCreator();
        CharacterCreator wizardCreator = new WizardCreator();
        CharacterCreator notWarriorCreator = new NotWarriorCreator();

        int choice = in.nextInt();
        System.out.println("His/Her name?");

        String name = in.next();

        return switch (choice) {
            case 1 -> warriorCreator.create(name);
            case 2 -> wizardCreator.create(name);
            case 3 -> priestCreator.create(name);
            default -> notWarriorCreator.create("Not Warrior");
        };
    }
    public static Character createEnemy() {
        CharacterCreator enemyCreator = new WarriorCreator();
        return enemyCreator.create("Enemy");
    }
}
