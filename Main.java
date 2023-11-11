import Factory_CharecterCreator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Human> allies = new ArrayList<>();
        List<Human> enemy = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("How many Allies you want to create?");
        int n = in.nextInt();
        System.out.println("Who you want to create?");
        for (int i = 0; i < n; i++) {
            System.out.println("1 - Warrior\n2 - Wizard\n3 - Priest");
            allies.add(createCharacter());
        }
        System.out.println("Which level of Enemies you want to choose?");
        n = in.nextInt();
        for (int i = 0; n < 6; i++) {

        }
        while (true) {
            for (int i = 0; i < allies.size(); i++) {
                if (allies.get(i).getStatus().equals("Dead")) {
                    allies.remove(i);
                }
            }
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getStatus().equals("Dead")) {
                    enemy.remove(i);
                }
            }
            if (allies.isEmpty()) {
                System.out.println("You Lost!");
                System.exit(0);
            }
            if (enemy.isEmpty()) {
                System.out.println("You Lost!");
                System.exit(0);
            }
            System.out.println("Make your move");
        }
    }

    public static Human createCharacter() {
        Scanner in = new Scanner(System.in);
        CharecterCreator priestCreator = new PriestCreator();
        CharecterCreator warriorCreator = new WarriorCreator();
        CharecterCreator wizardCreator = new WizardCreator();
        CharecterCreator notWarriotCreator = new NotWarriotCreator();
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
                return notWarriotCreator.create("Not Warrior");
        }
    }
}
