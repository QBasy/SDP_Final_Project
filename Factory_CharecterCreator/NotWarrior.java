package Factory_CharecterCreator;

public class NotWarrior extends Human{
    private int HealthPoints;
    private int Mana;
    private int damage;
    private int mageDamage;
    private int heal;
    private int mageCost;

    public NotWarrior(String name) {
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
        System.out.println("He can't even attack, what are you thinking?");
    }

    @Override
    public void giveMana(Human human) {
        System.out.println("He can't even attack, what are you thinking?");
    }

    @Override
    public int getMana() {
        return Mana;
    }
}
