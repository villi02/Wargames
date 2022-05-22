package Units;



public class RangedUnit extends Unit{

    private State myState  = State.FIRST_ATTACK;
    int defenceBonus = 2; // standard defence bonus
    int attackBonus = 3; // standard attack bonus
    final int FOREST_REDUCTION = -1;
    final int HILL_BONUS = 2;
    final int FIRST_DEFENCE_BONUS = 4;
    final int SECOND_DEFENCE_BONUS = 2;
    private String type;

    /**
     * A constructor for the RangedUnit
     * @param name the name of the unit as a string
     * @param health the health points of a unit as an int
     * @param attack the attack damage of a unit as an int
     * @param armor the defensive value of a unit as an int
     */
    public RangedUnit(String name, int health, int attack, int armor) throws Exception {
        super(name, health, attack, armor);
        this.type = "Ranged";
    }

    /**
     * a simplified constructor for the RangedUnit
     * @param name the name of the unit as a string
     * @param health the health points of a unit as an int
     */
    public RangedUnit(String name, int health) throws Exception {
        super(name, health, 15, 8);
        this.type = "Ranged";
    }

    /**
     * A method for getting the attack bonus of a ranged unit, when terrain is implemented
     * @param terrain the terrain as a Terrain
     * @return the attack bonus as an int
     */
    public int getAttackBonus(Terrain terrain) {
       switch (terrain){
           case PlAINS, STANDARD_TERRAIN -> {
               return (this.attackBonus);
           }
           case FOREST -> {
               return (this.attackBonus + FOREST_REDUCTION);
           }
           case HILL -> {
               return (this.attackBonus + HILL_BONUS);
           }
           default -> {
               System.out.println("Something went wrong");
               break;
           }
       }
        return attackBonus;
    }

    /**
     * A method for getting the attack bonus of a ranged unit
     * @return the attack bonus as an int
     */
    @Override
    public int getAttackBonus() {
        return this.attackBonus;
    }

    /**
     * A method for getting the defence bonus based on terrain
     * @param terrain the terrain in which the unit is located
     * @return the defence bonus as an int
     */
    public int getDefenceBonus(Terrain terrain) {
        switch(this.myState){
            case FIRST_ATTACK -> {
                this.myState = State.SECOND_ATTACK;
                return this.defenceBonus + 4;
            }

            case SECOND_ATTACK -> {
                this.myState = State.THIRD_ATTACK;
                return this.defenceBonus + 2;
            }

            case THIRD_ATTACK -> {
                return this.defenceBonus;
            }

            default -> {
                System.out.println("something went wrong");
                break;
            }
        }
        return defenceBonus;

        }

    /**
     * A standard method for getting defence bonus, for when no terrain is provided
     * @return the defence bonus as an int
     */
    @Override
    public int getDefenceBonus() {
        switch(this.myState){
            case FIRST_ATTACK -> {
                this.myState = State.SECOND_ATTACK;
                return this.defenceBonus + FIRST_DEFENCE_BONUS;
            }

            case SECOND_ATTACK -> {
                this.myState = State.THIRD_ATTACK;
                return this.defenceBonus + SECOND_DEFENCE_BONUS;
            }

            case THIRD_ATTACK -> {
                return this.defenceBonus;
            }

            default -> {
                System.out.println("something went wrong");
                break;
            }
        }
        return defenceBonus;

    }

    @Override
    public String toString() {
        return getClass() + "," + getName() + "," + getHealth();
    }

    /**
     * A method to get the type of the Unit
     * @return the type as a String
     */
    @Override
    public String getType() {
        return this.type;
    }
}

