package Units;


public class CavalryUnit extends Unit{
    /**
     * Initializing variables for later use
     */
    private State myState  = State.FIRST_ATTACK;
    final int attackBonus = 2; // standard attack bonus is 2
    final int defenceBonus = 1; // standard defence bonus is 1
    final int PLAINS_BONUS = 2;
    int TERRAIN_BONUS = 0; // is set to zero as standard value
    final int FIRST_ATTACK_BONUS = 4;
    final int FOREST_DEFENCE_BONUS = 0;

    /**
     * A constructor for a CavalryUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     * @param attack the attack damage of a unit as an int
     * @param armor the defensive value of a unit as an int
     */
    public CavalryUnit(String name, int health, int attack, int armor) throws Exception {
        super(name, health, attack, armor);
    }

    /**
     * A simplified constructor for the CavalryUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     */
    public CavalryUnit(String name, int health) throws Exception {
        super(name, health, 20, 12);
    }

    /**
     * A method to retrieve the attack bonus of a unit
     * @param terrain the terrain as a Terrain
     * @return the attack bonus as an int
     */
    @Override
    public int getAttackBonus(Terrain terrain) {

        if (terrain.equals(Terrain.PlAINS)) {
            TERRAIN_BONUS = PLAINS_BONUS; // terrain bonus is zero as standard
        }

        switch(this.myState){
            case FIRST_ATTACK -> {
                this.myState = State.SECOND_ATTACK;
                return this.attackBonus + TERRAIN_BONUS + FIRST_ATTACK_BONUS;
            }

            case SECOND_ATTACK -> {
                return this.attackBonus + TERRAIN_BONUS;
            }

            default -> {
                System.out.println("something went wrong");
                break;
            }
        }
        return this.attackBonus;

    }

    /**
     * A method to retrieve the defence bonus of a unit
     *
     * @return the defence bonus of a unit as an int
     */
    @Override
    public int getDefenceBonus(Terrain terrain) {
        if (terrain.equals(Terrain.FOREST)) {
            return FOREST_DEFENCE_BONUS; // is equal to zero
        }

        return this.defenceBonus;
    }

    /**
     * A standard method to retrieve the defence bonus of a unit
     * @return the defence bonus of the Cavalry unit as an int
     */
    @Override
    public int getAttackBonus() {
        switch(this.myState){
            case FIRST_ATTACK -> {
                this.myState = State.SECOND_ATTACK;
                return this.attackBonus + FIRST_ATTACK_BONUS;
            }

            case SECOND_ATTACK -> {
                return this.attackBonus + TERRAIN_BONUS;
            }

            default -> {
                System.out.println("something went wrong");
                break;
            }
        }
        return this.attackBonus;

    }

    /**
     * A standard method to retrieve the defence bonus of a unit
     *
     * @return the defence bonus of a unit as an int
     */
    @Override
    public int getDefenceBonus() {
        return this.defenceBonus;
    }

}
