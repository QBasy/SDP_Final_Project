import Factory_CharecterCreator.*;
import Singleton_Window.GameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLogic gl = GameLogic.getInstance();
        Scanner in = new Scanner(System.in);

        List<Human> allies = new ArrayList<>();
        List<Human> enemy = new ArrayList<>();

        enemy.add(gl.createEnemy());
        enemy.add(gl.createEnemy());

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
            allies.add(gl.createCharacter());
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
            gl.move(allies, enemy);
            gl.update(allies,enemy);
        }
    }
}
