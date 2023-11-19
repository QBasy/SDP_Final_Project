# Software Design Patterns Final Project 
# by Sayat Adilkhanov & Alikhan Dochshanov
# From SE-2215

---

# Signleton

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

```java
public class ObserverClass implements Observer {

    /*Singleton*/

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
        checkForDead(allies, enemy);
    }
    public void checkForDead(List<Character> allies, List<Character> enemies) {
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

public interface Observer {
    void update(List<Character> allies, List<Character> enemy);
}
```


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
        return super.getDescription() + ",Armor ";
    }
}
```

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
        return super.getDescription() + ",Magic Stick ";
    }
}
```

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
        return super.getDescription() + ",Katana+ ";
    }
}
```
---

# Strategy

```java
public interface AttackType {
    void attack(Character allie, Character enemy);
}
```

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

```java
public class PriestAttackAdapter extends Priest implements Character {
    private AttackType attackType;

    public PriestAttackAdapter(String name) {
        super(name);
    }
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
```

---

```java
public class WarriorAttackAdapter extends Warrior implements Character {
    private AttackType attackType;

    public WarriorAttackAdapter(String name) {
        super(name);
    }
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
```

```java
public class WizardAttackAdapter extends Wizard implements Character {
    private AttackType attackType;

    public WizardAttackAdapter(String name) {
        super(name);
    }
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public void attack(Character allie, Character enemy) {
        attackType.attack(allie, enemy);
    }
}
```

```java
```

```java
```

```java
```

```java
```

```java
```

```java
```
