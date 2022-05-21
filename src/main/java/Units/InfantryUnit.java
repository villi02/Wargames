package Units;

public class InfantryUnit extends Unit {

    /**
     * Initialize variables
     */
    int attackBonus = 2; // 2 is Standard attack bonus for this class
    int defenceBonus = 1; // 1 is Standard defence bonus for this class
    int FOREST_BONUS = 2; // The forest bonus

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
    public int getAttackBonus(Terrain terrain) {
        if (terrain.equals(Terrain.FOREST)) {
            return (this.attackBonus + FOREST_BONUS);
        }

        return this.attackBonus;
    }

    /**
     * A standard method for getting the attack bonus, for when no terrain is provided
     * @return the standard attack bonus
     */
    @Override
    public int getAttackBonus() {

        return this.attackBonus;
    }

    /**
     * A method to retrieve the defence bonus of the unit
     * @return the defense bonus of the unit as an int
     */
    @Override
    public int getDefenceBonus(Terrain terrain) {
        if (terrain.equals(Terrain.FOREST)){
            return this.defenceBonus + FOREST_BONUS;
        }

        return this.defenceBonus;
    }

    /**
     * A standard method for getting the defence bonus, for when no terrain is provided
     * @return The defence bonus
     */
    @Override
    public int getDefenceBonus() {
        return this.defenceBonus;
    }

    /**
     * A method to get the type of the Unit
     * @return the type as a String
     */
    @Override
    public String getType() {
        return "Infantry";
    }

}
