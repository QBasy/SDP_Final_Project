package Factory_CharecterCreator;

public abstract class Human {
    private String name = "Human";
    private boolean status = true;
    private int HealthPoints = 50;
    private int Mana = 5;
    private int damage = 25;
    private int mageDamage = 15;
    private int heal = 15;
    private int mana = 10;
    private int mageCost = 5;

    public Human(String name) {
        this.name = name;
    }

    public void physAttack(Human human) {
        if (human.status) {
            int HP = human.getHealthPoints();
            human.setHealthPoints(HP - damage);
            if (human.getHealthPoints() <= 0) {
                human.setStatus(false);
            }
        } else {
            System.out.println(name + " is ALREADY Dead!!!");
        }
    }

    public void mageAttack(Human human) {
        if (human.status) {
            if (mana > 0) {
                this.mana -= mageCost;
                int HP = human.getHealthPoints();
                human.setHealthPoints(HP - mageDamage);
                if (human.getHealthPoints() <= 0) {
                    human.setStatus(false);
                }
            } else {
                System.out.println(name + " needs to get Mana");
            }
        } else {
            System.out.println(name + " is ALREADY Dead!!!");
        }
    }

    public void giveHeal(Human human) {
        if (mana > 0) {
            if (human.status) {
                int HP = human.getHealthPoints();
                human.setHealthPoints(HP + heal);
            } else {
                System.out.println(name + " is already Dead");
            }
        } else {
            System.out.println(name + "don't have enough Mana");
        }
    }

    public void giveMana(Human human) {
        if (human.status) {
            int Mana = human.getMana();
            human.setMana(Mana + mana);
        } else {
            System.out.println(name + " is already Dead");
        }
    }

    public int getMana(){
        return Mana;
    }
    public int getHealthPoints(){
        return HealthPoints;
    }
    public void setMana(int mana){
        this.Mana = mana;
    }
    public void setHealthPoints(int HealthPoints){
        this.HealthPoints = HealthPoints;
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
}
