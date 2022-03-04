import Units.*;

import java.util.Random;

public class Battle {

    private Army armyOne, armyTwo;
    enum State{
        ARMY1_ATTACK,
        ARMY2_ATTACK
    }

    private Battle.State myState  = State.ARMY1_ATTACK;

    public Battle(Army armyOne, Army armyTwo) throws Exception {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    public Army simulate(){
        Army armyOneCopy = new Army(this.armyOne);
        Army armyTwoCopy = new Army(this.armyTwo);
        Random random = new Random();
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

    public boolean attack(Unit attacker, Unit defender)
    {
        int newHealth = defender.getHealth() - (attacker.getAttack() + attacker.getAttackBonus()) + (defender.getArmor() + defender.getDefenceBonus());
        if (!(newHealth > 0)){
            defender.setHealth(0);
            return false;
        }
        defender.setHealth(newHealth);
        return true;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}
