package Units;



public class RangedUnit extends Unit{

    private State myState  = State.FIRST_ATTACK;
    int defenceBonus;
    int attackBonus = 3; // standard attack bonus
    final int FOREST_REDUCTION = -1;
    final int HILL_BONUS = 2;

    /**
     * A constructor for the RangedUnit
     * @param name the name of the unit as a string
     * @param health the health points of a unit as an int
     * @param attack the attack damage of a unit as an int
     * @param armor the defensive value of a unit as an int
     */
    public RangedUnit(String name, int health, int attack, int armor) throws Exception {
        super(name, health, attack, armor);
    }

    /**
     * a simplified constructor for the RangedUnit
     * @param name the name of the unit as a string
     * @param health the health points of a unit as an int
     */
    public RangedUnit(String name, int health) throws Exception {
        super(name, health, 15, 8);
    }

    /**
     * A method to retrieve the attack bonus of a unit
     *
     * @return the attack bonus of a unit as an int
     */
    public int getAttackBonus(Terrain terrain) {
       switch (terrain){
           case PlAINS, STANDARD_TERRAIN -> {
               return (this.defenceBonus);
           }
           case FOREST -> {
               return (this.defenceBonus + FOREST_REDUCTION);
           }
           case HILL -> {
               return (this.defenceBonus + HILL_BONUS);
           }
       }
        return attackBonus;
    }

    /**
     * A standard method for getting the attack bonus, for when to terrain is provided
     * @return the attack bonus as an int
     */
    @Override
    public int getAttackBonus() {
        return attackBonus;
    }

    /**
     * A method for getting the defence bonus based on terrain
     * @param terrain the terrain in which the unit is located
     * @return the defence bonus as an int
     */
    public int getDefenceBonus(Terrain terrain) {
        defenceBonus = 0;
        switch(this.myState){
            case FIRST_ATTACK:
                defenceBonus = 6;
                this.myState = State.SECOND_ATTACK;
                break;

            case SECOND_ATTACK:
                defenceBonus = 4;
                this.myState = State.THIRD_ATTACK;
                break;

            case THIRD_ATTACK:
                defenceBonus = 2;
                break;

            default:
                System.out.println("something went wrong");
                break;
        }
        return defenceBonus;

        }

    /**
     * A standard method for getting defence bonus, for when no terrain is provided
     * @return the defence bonus as an int
     */
    @Override
    public int getDefenceBonus() {
        defenceBonus = 0;
        switch(this.myState){
            case FIRST_ATTACK:
                defenceBonus = 6;
                this.myState = State.SECOND_ATTACK;
                break;

            case SECOND_ATTACK:
                defenceBonus = 4;
                this.myState = State.THIRD_ATTACK;
                break;

            case THIRD_ATTACK:
                defenceBonus = 2;
                break;

            default:
                System.out.println("something went wrong");
                break;
        }
        return defenceBonus;

    }

    @Override
    public String toString() {
        return getClass() + "," + getName() + "," + getHealth();
    }
}

