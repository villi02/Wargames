package Units;

public class InfantryUnit extends Unit {

    /**
     * A constructor for an InfantryUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     * @param attack the attack damage of a unit as an int
     * @param armor the defensive value of a unit as an int
     */
    public InfantryUnit(String name, int health, int attack, int armor) throws Exception {
        super(name, health, attack, armor);
    }

    /**
     * A simplified constructor for an InfantryUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     */
    public InfantryUnit(String name, int health) throws Exception {
        super(name, health, 15, 10);
    }

    /**
     * A method to retrieve the attack bonus of the unit
     * @return the attack bonus of the unit as an int
     */
    @Override
    public int getAttackBonus() {
        return 2;
    }

    /**
     * A method to retrieve the defence bonus of the unit
     * @return the defense bonus of the unit as an int
     */
    @Override
    public int getDefenceBonus() {
        return 1;
    }
}
