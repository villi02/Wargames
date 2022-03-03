import Units.*;
public class Battle {

    private Army armyOne, armyTwo;
    enum State{
        ARMY1_ATTACK,
        ARMY2_ATTACK
    }

    private Battle.State myState  = State.ARMY1_ATTACK;

    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    public void simulate(){
        Army armyoneCopy = new Army(armyOne.getAllUnits(), "copy1");
        Army armytwoCopy = new Army(armyTwo.getAllUnits(), "copy2");
        while (armyOne.hasUnits() && armyTwo.hasUnits())
        {
            Unit armyoneTrooper = armyOne.getRandom();
            Unit armytwoTrooper = armyTwo.getRandom();

            switch(myState){
                case ARMY1_ATTACK:
                    // Gonna make a method to deal with attacks and defences
            }
        }
    }

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}
