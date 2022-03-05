package Units;

public abstract class Unit {

    /**
     * Initialize enum
     */
    enum State{
        FIRST_ATTACK,
        SECOND_ATTACK,
        THIRD_ATTACK
    }

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
    public Unit(String name, int health, int attack, int armor) throws Exception {
        if (health <= 0 || attack <= 0 || armor <=0 ){
            throw new Exception("Must be positive integers");
        }
        if (!(Character.isDigit(health) || !(Character.isDigit(attack)) || !(Character.isDigit(armor)))){
            throw new IllegalArgumentException("Must be integers");
        }

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
        if (health <= 0)
        {
            this.health = 0;
        }
        else
        {
            this.health = health;
        }
    }

    /**
     * A method to retrieve information about a Units.Unit represented as a string
     * @return Information about the unit as a string
     */
    @Override
    public String toString() {
        return String.format("Unit- name: %s, health: %d, attack: %d, armor: %d ", this.name, this.health, this.attack, this.armor);
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
