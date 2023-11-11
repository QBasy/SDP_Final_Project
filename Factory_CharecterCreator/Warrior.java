package Factory_CharecterCreator;

public class Warrior extends Human {
    private int HealthPoints = 300;
    private int Mana = 50;
    private int damage = 75;
    private int mageDamage = 5;
    private int mageCost = 10;

    public Warrior(String name) {
        super(name);
    }

    @Override
    public int getHealthPoints() {
        return HealthPoints;
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
    public int getMageCost() {
        return mageCost;
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
    public void giveHeal(Human warrior) {
        System.out.println("Heal can only Priest, so you just lost your action)))");
    }

    @Override
    public void giveMana(Human human) {
        System.out.println("Only a Priest can restore mana, so you just lost your action)))");
    }

    @Override
    public int getMana() {
        return Mana;
    }
}
