package Units;

public abstract class Unit {

    /**
     * Initializing variables
     */
    private String name;
    private int health, attack, armor;

    /**
     * A constructor for a Unit
     * @param name a string that represents the name of the unit
     * @param health an int that represents the amount of health a unit has
     * @param attack an int that represents the attack value of a units weapon
     * @param armor an int that represents the defensive value of a unit when attacked
     */
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * A method for retrieving the name of a Units.Unit
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * A method for retrieving the health points of a Units.Unit
     * @return The health points as an int
     */
    public int getHealth() {
        return health;
    }

    /**
     * A method for retrieving the attack value of a Units.Unit
     * @return The attack value as an int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * A method for retrieving the defensive value of a Units.Unit when attacked
     * @return The defensive value as an int
     */
    public int getArmor() {
        return armor;
    }

    /**
     * A method for changing a Units.Unit's health points
     * @param health The health points as an int
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * A method to retrieve information about a Units.Unit represented as a string
     * @return Information about the unit as a string
     */
    @Override
    public String toString() {
        return String.format("Units.Unit name: {0}, health: {1}, attack: {2}, armor: {3} ", getName(), getHealth(), getAttack(), getArmor());
    }

    /**
     * A method to retrieve the attack bonus of a unit
     * @return the attack bonus of a unit as an int
     */
    abstract public int getAttackBonus();

    /**
     * A method to retrieve the defence bonus of a unit
     * @return the defence bonus of a unit as an int
     */
    abstract public int getDefenceBonus();

}