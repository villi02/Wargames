package Units;

import java.util.Random;

public class Battle {

    /**
     * Initialize variables
     */
    private Army armyOne, armyTwo;
    private Terrain terrain;
    enum State{
        ARMY1_ATTACK,
        ARMY2_ATTACK
    }

    Random random = new Random();
    private Battle.State myState;

    /**
     * A constructor for the Units.Battle class, when terrain is implemented
     * @param armyOne An army to be featured in the Units.Battle
     * @param armyTwo An army to be featured in the Units.Battle (can be the same as the first Army)
     * @param terrain The terrain in which the battle will take place, as a Terrain
     * @throws Exception
     */
    public Battle(Army armyOne, Army armyTwo, Terrain terrain) throws Exception {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
        this.terrain = terrain;
    }

    /**
     * A constructor for the Units.Battle class, when terrain is not implemented
     * @param armyOne An army to be featured in the Units.Battle
     * @param armyTwo An army to be featured in the Units.Battle (can be the same as the first Army)
     * @throws Exception
     */
    public Battle(Army armyOne, Army armyTwo) throws Exception {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     * A method to simulate a battle between two armies
     * @return An Army as the victorious Army
     */
    public Army simulate(){
        myState = State.values()[random.nextInt( 2)];

        System.out.println("First attacking" + myState);
        Army armyOneCopy = new Army(this.armyOne);
        System.out.println("Armycopy 1 size:" + armyOneCopy.getAllUnits().size());
        Army armyTwoCopy = new Army(this.armyTwo);
        System.out.println("Armycopy 2 size:" + armyTwoCopy.getAllUnits().size());

        while (armyOneCopy.hasUnits() && armyTwoCopy.hasUnits())
        {
            Unit armyoneTrooper = armyOneCopy.getRandom();
            Unit armytwoTrooper = armyTwoCopy.getRandom();

            switch(myState){
                case ARMY1_ATTACK:
                    if (!attack(armyoneTrooper, armytwoTrooper)){
                        armyTwoCopy.remove(armytwoTrooper);
                }
                    this.myState = State.ARMY2_ATTACK;
                    break;

                case ARMY2_ATTACK:
                    if(!attack(armytwoTrooper, armyoneTrooper)){
                        armyOneCopy.remove(armyoneTrooper);
                    }
                    this.myState = State.ARMY1_ATTACK;
                    break;

                default:
                    System.out.println("Something went wrong");
                    break;
            }
        }
        if (armyOneCopy.hasUnits()){
            return armyOne;
        }
        return armyTwo;
    }

    /**
     * A method to attack a Unit
     * @param attacker A Unit that's going to attack
     * @param defender A Unit that's going to be attacked
     * @return A boolean, returns false if the unit dies
     */
    //Make sure unit cant have more health than before attack
    public boolean attack(Unit attacker, Unit defender)
    {
        int newHealth = defender.getHealth() - (attacker.getAttack() + attacker.getAttackBonus(terrain)) + (defender.getArmor() + defender.getDefenceBonus(terrain));
        if (!(newHealth > 0)){
            defender.setHealth(0);
            return false;
        }
        defender.setHealth(newHealth);
        return true;
    }

    @Override
    public String toString() {
        return "Units.Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}
