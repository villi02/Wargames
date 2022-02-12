public class Unit {
    private String name;
    private int health, attack, armor;

    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return String.format("Unit name: {0}, health: {1}, attack: {2}, armor: {3} ", getName(), getHealth(), getAttack(), getArmor());
    }

}
