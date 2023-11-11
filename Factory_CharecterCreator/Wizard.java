package Factory_CharecterCreator;

public class Wizard extends Human {
    private String name = "Wizard";
    private boolean status = true;
    private int HealthPoints = 200;
    private int Mana = 150;
    private int damage = 15;
    private int mageDamage = 85;
    private int heal = 20;
    private int mana = 25;

    public Wizard(String name) {
        super(name);
    }
}
