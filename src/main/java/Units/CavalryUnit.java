package Units;


public class CavalryUnit extends Unit{
    /**
     * Initializing variables for later use
     */
    private State myState  = State.FIRST_ATTACK;
    int attackBonus;
    final int PLAINS_BONUS = 2;
    int TERRAIN_BONUS = 0;
    int STANDARD_ATTACK_BONUS = 2;
    int FIRST_ATTACK_BONUS = 4;
    int STANDARD_DEFENCE_BONUS = 1;
    int FOREST_DEFENCE_BONUS = 0;

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
     *
     * @return the attack bonus of a unit as an int
     */
    @Override
    public int getAttackBonus(Terrain terrain) {

        if (terrain.equals(Terrain.PlAINS)) {
            TERRAIN_BONUS = PLAINS_BONUS;
        }

        switch(this.myState){
            case FIRST_ATTACK:
                this.attackBonus = STANDARD_ATTACK_BONUS + TERRAIN_BONUS + FIRST_ATTACK_BONUS;
                this.myState = State.SECOND_ATTACK;
                break;

            case SECOND_ATTACK:
                attackBonus = STANDARD_ATTACK_BONUS + TERRAIN_BONUS;
                break;

            default:
                System.out.println("something went wrong");
                break;
        }
        return attackBonus;

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

        return STANDARD_DEFENCE_BONUS;
    }

    /**
     * A standard method to retrieve the defence bonus of a unit
     * @return the defence bonus of the Cavalry unit as an int
     */
    @Override
    public int getAttackBonus() {
        int attackBonus = 0;
        switch(this.myState){
            case FIRST_ATTACK:
                attackBonus = 4 + 2;
                this.myState = State.SECOND_ATTACK;
                break;

            case SECOND_ATTACK:
                attackBonus = 2;
                break;

            default:
                System.out.println("something went wrong");
                break;
        }
        return attackBonus;

    }

    /**
     * A standard method to retrieve the defence bonus of a unit
     *
     * @return the defence bonus of a unit as an int
     */
    @Override
    public int getDefenceBonus() {
        return STANDARD_DEFENCE_BONUS;
    }

}
