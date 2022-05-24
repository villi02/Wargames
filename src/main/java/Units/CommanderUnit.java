package Units;

public class CommanderUnit extends CavalryUnit{

    private String type;

    /**
     * A constructor for a CommanderUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     * @param attack the attack damage of a unit as an int
     * @param armor the defensive value of a unit as an int
     */
    public CommanderUnit(String name, int health, int attack, int armor) throws Exception {
        super(name, health, attack, armor);
        this.type = "Commander";
    }

    /**
     * A simplified constructor for the CommanderUnit
     * @param name the name of the Unit as a string
     * @param health the health points of a unit as an int
     */
    public CommanderUnit(String name, int health) throws Exception {
        super(name, health, 20, 15);
        this.type = "Commander";
    }

    /**
     * A copy constructor
     * @param unit the unit to be copied as a CommanderUnit
     * @throws Exception
     */
    public CommanderUnit(CommanderUnit unit) throws Exception {
        super(unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor());
        this.type = "Commander";
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
