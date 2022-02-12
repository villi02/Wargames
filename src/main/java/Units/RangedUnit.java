package Units;

public class RangedUnit extends Unit{

    /**
     * A constructor for the RangedUnit
     * @param name the name of the unit as a string
     * @param health the health points of a unit as an int
     * @param attack the attack damage of a unit as an int
     * @param armor the defensive value of a unit as an int
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * a simplified constructor for the RangedUnit
     * @param name the name of the unit as a string
     * @param health the health points of a unit as an int
     */
    public RangedUnit(String name, int health){
        super(name, health, 15, 8);
    }

    /**
     * A method to retrieve the attack bonus of a unit
     *
     * @return the attack bonus of a unit as an int
     */
    @Override
    public int getAttackBonus() {
        return 3;
    }

    /**
     * A method to retrieve the defence bonus of a unit
     *
     * @return the defence bonus of a unit as an int
     */
    @Override
    //Not sure as to where i'll insert the logic to the defence bonus, set the temporary return value to the standard value
    public int getDefenceBonus() {
        return 2;
        }
}

