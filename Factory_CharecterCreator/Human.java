package Factory_CharecterCreator;

public abstract class Human {
    private String name;
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
    public abstract void giveHeal(Human warrior);
    public abstract void giveMana(Human human);
    public abstract int getMana();
    public abstract int getHealthPoints();
    public abstract void setMana(int mana);
    public abstract void setHealthPoints(int HealthPoints);
}
