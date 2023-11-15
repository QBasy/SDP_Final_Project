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

    /*
    Observer
            */

}
```

---

# Observer

```java
public class ObserverClass implements Observer {

    /*
    Singleton
            */

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

```java
```

---

# Decorator

```java
```

---

# Strategy

```java
```

---

# Adapter

```java
```

---

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

```java
```

```java
```
