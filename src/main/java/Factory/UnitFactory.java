package Factory;

import Units.CavalryUnit;
import Units.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class UnitFactory {

    public Unit getSingleUnit(UnitType unitType, String name, int health) throws Exception {
        Unit unit = null;
        switch (unitType) {
            case CAVALRY -> unit = new CavalryUnit(name,health);
            case COMMANDER -> unit = new CommanderUnit(name, health);
            case INFANTRY -> unit = new InfantryUnit(name, health);
            case RANGED -> unit = new RangedUnit(name, health);
        }
        return unit;
    }

    public Unit getSingleUnit(UnitType unitType, String name, int health, int attack, int armor) throws Exception {
        Unit unit = null;
        switch (unitType) {
            case CAVALRY -> unit = new CavalryUnit(name,health, attack, armor);
            case COMMANDER -> unit = new CommanderUnit(name,health, attack, armor);
            case INFANTRY -> unit = new InfantryUnit(name,health, attack, armor);
            case RANGED -> unit = new RangedUnit(name,health, attack, armor);
        }
        return unit;
    }

    public ArrayList<Unit> getMultipleUnits(UnitType unitType, int amount, String name, int health){
        ArrayList<Unit> units = new ArrayList<>();
        switch (unitType){
            case CAVALRY -> IntStream.range(0, amount).forEach(i -> {
                try {
                    units.add(new CavalryUnit(name, health));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            case COMMANDER -> IntStream.range(0, amount).forEach(i -> {
                try {
                    units.add(new CommanderUnit(name, health));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            case INFANTRY -> IntStream.range(0, amount).forEach(i_-> {
                try {
                    units.add(new InfantryUnit(name, health));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            case RANGED -> IntStream.range(0, amount).forEach(i -> {
                try {
                    units.add(new RangedUnit(name, amount));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        return units;
    }

    public ArrayList<Unit> getMultipleUnits(UnitType unitType, int amount, String name, int health, int attack, int armor){
        ArrayList<Unit> units = new ArrayList<>();
        switch (unitType){
            case CAVALRY -> IntStream.range(0, amount).forEach(i -> {
                try {
                    units.add(new CavalryUnit(name, health, attack, armor));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            case COMMANDER -> IntStream.range(0, amount).forEach(i -> {
                try {
                    units.add(new CommanderUnit(name, health, attack, armor));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            case INFANTRY -> IntStream.range(0, amount).forEach(i_-> {
                try {
                    units.add(new InfantryUnit(name, health, attack, armor));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            case RANGED -> IntStream.range(0, amount).forEach(i -> {
                try {
                    units.add(new RangedUnit(name, health, attack, armor));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        return units;
    }
}
