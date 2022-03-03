package Units;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Army {

    ArrayList<Unit> units;
    String name;

    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    public Army(ArrayList<Unit> units, String name) {

        for (Unit unit: units){
            this.units.add(unit);
        }

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

    public ArrayList<Unit> getAllUnits(){
        return this.units;
    }

    public Unit getRandom(){
        Random random = new Random();
        return this.units.get(random.nextInt(this.units.size()));
    }

    @Override
    public String toString() {
        return "Army{" +
                "units=" + units +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(units, army.units) && Objects.equals(name, army.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(units, name);
    }
}
