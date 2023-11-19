# Software Design Patterns Final Project 

# From SE-2215

# Sayat Adilkhanov & Alikhan Dochshanov

---


Project Overview:   
 
1) Our project is a representative of RPG game with 3 in-game classes, amount of which can be extended in the future. Characters can have armor and weapons. Attacks can deal two types of damage: physical and magic.   
 
2) Idea behind the project is to try to implement studied material into things we like – games. Gaining some experience in this field wouldn’t be a bad thing for us.   
 
3) The purpose of our project is to create an engaging RPG game that not only can be entertaiable, but also would serve as a practical application of the theoretical knowledge we've acquired during studying.  We aim to develop a project that showcases our skills in game design, programming, and creative thinking.   
 
4) Game Mechanics Implementation:   
 
One of our primary objectives is to successfully implement various game mechanics, including character classes, armor, weapons, and a dual-damage system (physical and magic).  
  
Learning and Skill Development:   
 
Beyond the immediate goal of creating a game, we see this project as an opportunity for personal and professional growth. We aim to enhance our skills in teamwork, problem-solving, and game development, ultimately contributing to our overall academic development.


---



# Main

## main(String[] args)
``` The main function ```
``` It contains basic simple logic for the game ```

```java
public class Main {
    public static void main(String[] args) {
        Observer observer = ObserverClass.getInstance(); // Creating Observer by using Singleton's getInstance(), For the notifications in future during the battle.

        Scanner in = new Scanner(System.in); // Creating Scanner Object for the future elections

        List<Character> allies = new ArrayList<>(); // Dynamic Array to contain Players Characters
        List<Character> enemy = new ArrayList<>(); // Dynamic Array to contain Players Enemy 

        enemy.add(createEnemy()); // Creates Warriors as an enemy
        enemy.add(createEnemy()); // Creates Warriors as an enemy

        int n; // A variable initialized for future elections

        System.out.println("How many Allies you want to create? (Not more than 3)");

        while (true) { // Infinite loop, so that the user does not choose the wrong number
            n = in.nextInt();
            if (n > 3) {
                System.out.println("Allies can't be more than 3");
            } else if (n < 1) {
                System.out.println("Allies can't be less than 1");
            } else {
                break;
            }
        }

        System.out.println("Who you want to create?");

        for (int i = 0; i < n; i++) {         // This loop used to create Players Team
            System.out.println("1 - Warrior\n2 - Wizard\n3 - Priest");
            allies.add(createCharacter());
        }

        System.out.println("You can spend your own Mana Points to get something from inventory, you can get something 1");
        System.out.println("1 - Yes\n (any other number) - No");

        // Player can Choose one of the Special Items, or decline the deal.
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

        // An infinite loop, also this part of the code can be called the battle itself
        while (true) {
            // Checks if allies or enemies are all dead, and print result.
            // If both teams in a moment are Dead, it will be Draw
            if (allies.isEmpty() && enemy.isEmpty()) {
                System.out.println("Draw!");
                break;
            }
            if (allies.isEmpty()) {
                System.out.println("You Lost!");
                break;
            }
            if (enemy.isEmpty()) {
                System.out.println("You Won!");
                break;
            }

            System.out.println("Make your move");

            move(allies, enemy); // Players Move
            enemyMove(enemy, allies); // AI move
            observer.update(allies,enemy); // Observer Writes notifications, also removes dead Characters.
        }
    }

    /*Other helpful functions*/

}
```

## inventory(List<Character> human, int index)

``` This function uses the decorator pattern, ```
``` so that the player can select one special item. ```

```java
public static void inventory(List<Character> human, int index) {
        Scanner in = new Scanner(System.in);

        System.out.println("Which One?");
        System.out.println("1 - Armor, 2 - Magic Wand, 3 - Katana");

        // (Switch - Case) Choice tp choose an Item from Decorator.
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
```

## enemyMove(List<Character> enemy, List<Character> allies)

``` Simple AI for Enemies of Player ```
``` using Random numbers to choose random actions for enemy team. ```
``` Also uses Strategy and Adapter Patterns to give damage ``` 

```java
public static void enemyMove(List<Character> enemy, List<Character> allies) {
        System.out.println("Now wait for Enemy move");
        for (Character character : enemy) {
            int gettingPerson = (int) ((Math.random() * (allies.size() - 1))); // Getting random Player Character.
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
                    character.giveHeal(enemy.get((int) ((Math.random() * (enemy.size() - 1)))));
                    System.out.println();
                    break;
            }
        }
    }
```

## move(List<Character> allies, List<Character> enemies)

``` This function accepts Two Dynamic Arrays, the first is the player's heroes, the second is the opponent. ```
``` Created for the player to accept the actions of the characters. ```
``` Also uses Strategy and Adapter Patterns to give damage ``` 

```java
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
```

## createCharacter()

``` This function using Factory Pattern by using simple (switch - case) and return chosen character ```

```java
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
```

## createEnemy()

``` creating Warrior as an enemies, also uses Factory pattern```

```java
public static Character createEnemy() {
        CharacterCreator enemyCreator = new WarriorCreator();
        return enemyCreator.create("Enemy");
}
```
---

# Signleton

``` Here the pattern of a Singleton is used for a single Observer call ```

```java
public class ObserverClass implements Observer {
    private static ObserverClass instance;
    private ObserverClass() {}

    public static ObserverClass getInstance() {
        if (instance == null) {
            return new ObserverClass();
        } else {
            return instance;
        }
    }

    /*Observer*/

}
```



---



# Observer

``` This pattern is used during the battle after each full turn of the loop in order to display information about each of the Characters ```
``` Also used to remove Dead Characters ```

```java
public class ObserverClass implements Observer {

    /*Singleton*/

    // Realisation of Interface and the main function of Observer
    @Override
    public void update(List<Character> allies, List<Character> enemy) {
        for (Character human : allies) {
            System.out.println(human.getName() + " is " + human.getStatus());
            if (human.getStatus().equals("Alive")) {
                System.out.println("HP = " + human.getHealthPoints());
                System.out.println("Mana = " + human.getMana() + "\n");
            }
        }
        for (Character human : enemy) {
            System.out.println(human.getName() + " is " + human.getStatus());
            if (human.getStatus().equals("Alive")) {
                System.out.println("HP = " + human.getHealthPoints());
                System.out.println("Mana = " + human.getMana() + "\n");
            }
        }
        removeDead(allies, enemy);
    }

    // This function remove dead characters in both teams, if there are any.
    private void removeDead(List<Character> allies, List<Character> enemies) {
        for (int i = 0; i < allies.size(); i++) {
            if (allies.get(i).getStatus().equals("Dead")) {
                allies.remove(i);
            }
        }
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getStatus().equals("Dead")) {
                enemies.remove(i);
            }
        }
    }
}

``` Interface of Observer itself ```
public interface Observer {
    void update(List<Character> allies, List<Character> enemy);
}
```



---



# Factory

## Product

```java
public interface Character {
    int getHealthPoints();
    int getDamage();
    int getMageCost();
    int getMageDamage();
    int getMana();
    String getStatus();
    String getName();
    String getDescription();
    void setStatus(boolean status);
    void setMana(int mana);
    void setHealthPoints(int HP);
    void giveMana(Character human);
    void giveHeal(Character human);
    String getWarClass();
}
```

```java
public abstract class Human implements Character {
    private final String name;
    private boolean status = true;
    public Human(String name) {
        this.name = name;
    }
    public String getStatus() {
        if (!status) {
            return "Dead";
        }
        return "Alive";
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public abstract int getMageCost();
    public abstract int getMageDamage();
    public abstract int getDamage();
    public abstract void giveHeal(Character warrior);
    public abstract void giveMana(Character human);
    public abstract int getMana();
    public abstract int getHealthPoints();
    public abstract void setMageDamage(int mana);
    public abstract void setDamage(int damage);
    public abstract void setMana(int mana);
    public abstract void setHealthPoints(int HealthPoints);
    public abstract String getDescription();
}
```

## ConcreteProduct

```java
public class Priest extends Human {
    private String warClass = "Priest";
    private boolean status = true;
    private int HealthPoints = 100;
    private int Mana = 200;
    private int damage = 10;
    private int mageDamage = 35;

    public Priest(String name) {
        super(name);
    }

    @Override
    public int getHealthPoints() {
        return HealthPoints;
    }

    @Override
    public void setMageDamage(int mana) {
        this.mageDamage += mana;
    }

    @Override
    public void setDamage(int damage) {
        this.damage += damage;
    }

    @Override
    public void setMana(int mana) {
        this.Mana += mana;
    }

    @Override
    public void setHealthPoints(int HealthPoints) {
        this.HealthPoints = HealthPoints;
    }

    @Override
    public String getDescription() {
        return "Priest";
    }

    @Override
    public int getMageCost() {
        return 15;
    }

    @Override
    public int getMageDamage() {
        return mageDamage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public void giveHeal(Character human) {
        if (status) {
            if (Mana > 0) {
                if (human.getStatus().equals("Alive")) {
                    int HP = human.getHealthPoints();
                    int heal = 45;
                    human.setHealthPoints(HP + heal);
                } else {
                    System.out.println(human.getName() + " is already Dead");
                }
            } else {
                System.out.println(getName() + "don't have enough Mana");
            }
        } else {
            System.out.println(getName() + " is already Dead");
        }
    }
    public void giveMana(Character human) {
        if (status) {
            if (human.getStatus().equals("Alive")) {
                int Mana = human.getMana();
                int mana = 45;
                human.setMana(Mana + mana);
            } else {
                System.out.println(human.getName() + " is already Dead");
            }
        } else {
            System.out.println(getName() + " is already Dead");
        }
    }

    @Override
    public int getMana() {
        return Mana;
    }

    public String getWarClass() {
        return warClass;
    }
}
```
```java
public class Warrior extends Human {
    private String warClass = "Warrior";
    private int HealthPoints = 300;
    private int Mana = 50;
    private int damage = 75;
    private int mageDamage = 5;

    public Warrior(String name) {
        super(name);
    }

    @Override
    public int getHealthPoints() {
        return HealthPoints;
    }

    @Override
    public void setMageDamage(int damage) {
        this.mageDamage += damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage += damage;
    }

    @Override
    public void setMana(int mana) {
        this.Mana = mana;
    }

    @Override
    public void setHealthPoints(int HealthPoints) {
        this.HealthPoints = HealthPoints;
    }

    @Override
    public String getDescription() {
        return "Warrior" + getName() + "got an equipment: Sword ";
    }

    @Override
    public int getMageCost() {
        return 10;
    }

    @Override
    public int getMageDamage() {
        return mageDamage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void giveHeal(Character warrior) {
        int heal = 0;
        warrior.setHealthPoints(warrior.getHealthPoints() + heal);
    }

    @Override
    public void giveMana(Character human) {
        System.out.println("Warrior can't restore mana, so you just lost your action");
    }

    @Override
    public int getMana() {
        return Mana;
    }

    public String getWarClass() {
        return warClass;
    }
}
```

```java
public class Wizard extends Human {
    private String warClass = "Wizard";
    private int HealthPoints = 200;
    private int Mana = 150;
    private int damage = 15;
    private int mageDamage = 85;

    public Wizard(String name) {
        super(name);
    }

    @Override
    public int getHealthPoints() {
        return HealthPoints;
    }

    @Override
    public void setMageDamage(int mana) {
        this.mageDamage += mana;
    }

    @Override
    public void setDamage(int damage) {
        this.damage += damage;
    }

    @Override
    public void setMana(int mana) {
        this.Mana += mana;
    }

    @Override
    public void setHealthPoints(int HealthPoints) {
        this.HealthPoints = HealthPoints;
    }

    @Override
    public String getDescription() {
        return "Wizard";
    }

    @Override
    public int getMageCost() {
        return 15;
    }

    @Override
    public int getMageDamage() {
        return mageDamage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void giveHeal(Character warrior) {
        setHealthPoints(getHealthPoints());
    }

    @Override
    public void giveMana(Character human) {
        setMana(0);
    }

    @Override
    public int getMana() {
        return Mana;
    }

    public String getWarClass() {
        return warClass;
    }
}
```

## Creator

```java
public interface CharacterCreator {
    Character create(String name);
}
```
## ConcreteCreators
```java
public class PriestCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Priest(name);
    }
}
```
```java
public class WarriorCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Warrior(name);
    }
}
```
```java
public class WizardCreator implements CharacterCreator {
    @Override
    public Character create(String name) {
        return new Wizard(name);
    }
}
```



---



# Decorator

## CharacterDecorator

``` An abstract class created to adapt Character interface to a Decorator without changing interface itself ```
 
```java
public abstract class CharacterDecorator implements Character {
    private Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    public String getDescription() {
         return decoratedCharacter.getDescription();
    }
    public int getHealthPoints() {
        return decoratedCharacter.getHealthPoints();
    }
    public int getDamage() {
        return decoratedCharacter.getDamage();
    }
    public int getMageCost() {
        return decoratedCharacter.getMageCost();
    }
    public int getMageDamage() {
        return decoratedCharacter.getMageDamage();
    }
    public int getMana() {
        return decoratedCharacter.getMana();
    }
    public String getStatus() {
        return decoratedCharacter.getStatus();
    }
    public String getName() {
        return decoratedCharacter.getName();
    }
    public void setMana(int mana) {
        decoratedCharacter.setMana(mana);
    }
    public void setHealthPoints(int HP) {
        decoratedCharacter.setHealthPoints(HP);
    }
    public void setStatus(boolean status) {
        decoratedCharacter.setStatus(status);
    }
    public void giveMana(Character human) {
        decoratedCharacter.giveMana(human);
    }
    public void giveHeal(Character human) {
        decoratedCharacter.giveMana(human);
    }
    public String getWarClass() {
        return decoratedCharacter.getWarClass();
    }
}
```

## ArmorDecorator

``` This Decorator giving Armor to chosen Charecter ```

```java
public class ArmorDecorator extends CharacterDecorator {
    private Human Decorated;
    public ArmorDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    public void setHealthPoints(Human Decorated) {
        Decorated.setHealthPoints(Decorated.getHealthPoints() + 35);
    }

    public String getDescription(Human Decorated) {
        return super.getDescription() + ", Armor";
    }
}
```

## MagicStickDecorator

``` This Decorator giving Magic Stick to chosen Charecter ```

```java
public class MagicStickDecorator extends CharacterDecorator{
    private Human Decorated;
    public MagicStickDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    public int getMageDamage(Human Decorated) {
        Decorated.setMageDamage(15);
        return super.getMageDamage() + 15;
    }

    public String getDescription(Human Decorated) {
        return super.getDescription() + ", Magic Stick";
    }
}
```

## WeaponDecorator

``` This Decorator giving Katana to chosen Charecter ```

```java
public class WeaponDecorator extends CharacterDecorator {
    private Human Decorated;

    public WeaponDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    public int getDamage(Human Decorated) {
        Decorated.setDamage(20);
        return super.getDamage() + 20;
    }

    public String getDescription(Human Decorated) {
        return super.getDescription() + ", Katana";
    }
}
```



---



# Strategy

``` Strategy Interface of AttackType's ```

```java
public interface AttackType {
    void attack(Character allie, Character enemy);
}
```

## Attack

``` Used to initialize the Type of attack Itself ```

```java
public class Attack {
    private AttackType attackType;

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
```

## MageAttack

``` Strategy for Magic AttackType, Implements the type of attack ```

```java
public class MageAttack implements AttackType {
    public void attack(Character allie, Character enemy) {
        if (enemy.getStatus().equals("Alive")) {
            if (allie.getMana() > 0) {
                allie.setMana(allie.getMana() - allie.getMageCost());
                int HP = enemy.getHealthPoints();
                enemy.setHealthPoints(HP - allie.getMageDamage());
                if (enemy.getHealthPoints() <= 0) {
                    enemy.setStatus(false);
                }
                System.out.println(allie.getName() + " attacking " + enemy.getName());
                System.out.println(enemy.getName() + " lose " + (allie.getMageDamage()) + " and have " + enemy.getHealthPoints() + " HP\n");
            } else {
                System.out.println(allie.getName() + " needs to get Mana");
            }
        } else {
            System.out.println(allie.getName() + " is ALREADY Dead!!!");
        }
    }
}
```
## PhysAttack

``` Strategy for Physical Attack, Implements the type of attack```

```java
public class PhysAttack implements AttackType {
    @Override
    public void attack(Character allie, Character enemy) {
        if (enemy.getStatus().equals("Alive")) {
            int HP = enemy.getHealthPoints();
            enemy.setHealthPoints(HP - allie.getDamage());
            if (enemy.getHealthPoints() <= 0) {
                enemy.setStatus(false);
            }
            System.out.println(allie.getName() + " attacking " + enemy.getName());
            System.out.println(enemy.getName() + " lose " + (allie.getDamage()) + " and have " + enemy.getHealthPoints() + " HP\n");
        } else {
            System.out.println(enemy.getName() + " is ALREADY Dead!!!");
        }
    }
}
```



---



# Adapter

``` In this project Adapter Pattern used to adapt Attack types from Strategy Pattern to Characters ```

## Adapter for Warrior

``` Here is Adapter Pattern for Warrior ```

```java
public class WarriorAttackAdapter extends Warrior implements Character {
    private AttackType attackType; // AttackType (Mage or Physical)

    // Constructor
    public WarriorAttackAdapter(String name) {
        super(name);
    }
    // Setting AttackType
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    // Attack function itself (using Strategy)
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
```

## Adapter for Wizard

``` Here is Adapter Pattern for Wizard ```

```java
public class WizardAttackAdapter extends Wizard implements Character {
    private AttackType attackType; // AttackType (Mage or Physical)

    // Constructor
    public WizardAttackAdapter(String name) {
        super(name);
    }
    // Setting AttackType
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    // Attack function itself (using Strategy)
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
```

