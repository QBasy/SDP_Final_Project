package Factory_CharecterCreator;

public class Priest extends Human {
    private String name;
    private boolean status = true;
    private int HealthPoints = 100;
    private int Mana = 200;
    private int damage = 10;
    private int mageDamage = 35;
    private int heal = 45;
    private int mana = 45;
    private int mageCost = 15;

    public Priest(String name) {
        super(name);
        status = true;
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

    public void giveHeal(Human human) {
        if (status) {
            if (Mana > 0) {
                if (human.getStatus().equals("Alive")) {
                    int HP = human.getHealthPoints();
                    human.setHealthPoints(HP + heal);
                } else {
                    System.out.println(human.getName() + " is already Dead");
                }
            } else {
                System.out.println(name + "don't have enough Mana");
            }
        } else {
            System.out.println(name + " is already Dead");
        }
    }
    public void giveMana(Human human) {
        if (status) {
            if (human.getStatus().equals("Alive")) {
                int Mana = human.getMana();
                human.setMana(Mana + mana);
            } else {
                System.out.println(human.getName() + " is already Dead");
            }
        } else {
            System.out.println(name + " is already Dead");
        }
    }

    @Override
    public int getMana() {
        return Mana;
    }
}
