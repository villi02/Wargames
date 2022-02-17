package Units;

import java.util.ArrayList;

public class Army {

    ArrayList<Unit> units;
    String name;

    public Army(String name) {
        this.name = name;
        this.units = null;
    }

    public Army(ArrayList<Unit> units, String name) {
        this.units = units;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Unit unit){
        this.units.add(unit);
    }

    public void addAll(ArrayList<Unit> units){
        for (Unit unit : units) {
            this.units.add(unit);
        }
        }

    public void remove(Unit unit){
            this.units.remove(unit);
        }

    public boolean hasUnits(){
            return !this.units.isEmpty();
        }


    }
}
