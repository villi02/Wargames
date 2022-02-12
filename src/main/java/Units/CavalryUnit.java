package Units;

public class CavalryUnit extends Unit{
    /**
     * A constructor for a CavalryUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     * @param attack the attack damage of a unit as an int
     * @param armor the defensive value of a unit as an int
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * A simplified constructor for the CavalryUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     */
    public CavalryUnit(String name, int health){
        super(name, health, 20, 12);
    }

    /**
     * A method to retrieve the attack bonus of a unit
     *
     * @return the attack bonus of a unit as an int
     */
    @Override
    public int getAttackBonus() {
        return 2;
    }

    /**
     * A method to retrieve the defence bonus of a unit
     *
     * @return the defence bonus of a unit as an int
     */
    @Override
    public int getDefenceBonus() {
        return 1;
    }
}
