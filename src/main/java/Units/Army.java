package Units;

import java.util.*;
import java.util.stream.Collectors;

public class Army {

    /**
     * Initialize variables
     */
    ArrayList<Unit> units = new ArrayList<>();
    String name;

    /**
     * An empty constructor, for initialization
     */
    public Army(){
        this.name = "";
    }

    /**
     * Constructor for Amry class
     * @param name name of army
     */
    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    /**
     * Copy constructor for an army object
     * @param army the army you want to copy
     */
    public Army(Army army) throws Exception {
        this.name = army.getName();
        this.units = new ArrayList<>();
        for (Unit unit: army.getAllUnits())
        {
            switch(unit.getType()){
                case "Cavalry" -> this.units.add(new CavalryUnit((CavalryUnit) unit));
                case "Commander" -> this.units.add(new CommanderUnit((CommanderUnit) unit));
                case "Infantry" -> this.units.add(new InfantryUnit((InfantryUnit) unit));
                case "Ranged" -> this.units.add(new RangedUnit((RangedUnit) unit));

            }
        }
    }

    /**
     * Constructor for Army class
     * @param units An Arraylist<Units> with the Units to be included in the army
     * @param name  The name of the army
     */
    public Army(ArrayList<Unit> units, String name) {

        for (Unit unit: units) {
            this.units.add(unit);
            System.out.println("adding units");
        }

        this.name = name;
    }

    /**
     * A method to get the name of the Army
     * @return The name of the Army
     */
    public String getName() {
        return name;
    }

    /**
     * A method to change name of army
     * @param name the new name of army
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method to add a unit to the Army
     * @param unit the unit to be added to the Army
     */
    public void add(Unit unit){
        this.units.add(unit);
    }

    /**
     * A method to add multiple units to the Army
     * @param units An Arraylist<Units> with the units to be added to the Army
     */
    public void addAll(ArrayList<Unit> units){
        for (Unit unit : units) {
            this.units.add(unit);
        }
        }

    /**
     * A method to remove a Unit from the Army
     * @param unit The Unit to be removed
     */
    public void remove(Unit unit){
            this.units.remove(unit);
        }

    /**
     * A method to check if the Army has units
     * @return A boolean, true if Army has units
     */
    public boolean hasUnits(){
            return !this.units.isEmpty();
        }

    /**
     * A method to get all units in an Army
     * @return The units as an Arraylist<Unit>
     */
    public ArrayList<Unit> getAllUnits(){
        return this.units;
    }

    /**
     * A method to get a random Unit from the Army
     * @return The Unit
     */
    public Unit getRandom(){
        Random random = new Random();
        return this.units.get(random.nextInt(this.units.size()));
    }

    /**
     * A method to return all Infantry units in an army
     * @return The Infantry units in the army as a List<Unit>
     */
    public List<Unit> getInfantryUnits() {
        return this.units.stream().filter(x -> x instanceof InfantryUnit).collect(Collectors.toList());
    }

    /**
     * A method to return all Cavalry units in an army
     * @return The Cavalry units in the army as a List<Unit>
     */
    public List<Unit> getCavalryUnits() {
        return this.units.stream().filter(x -> x instanceof CavalryUnit && !(x instanceof CommanderUnit)).collect(Collectors.toList());
    }

    /**
     * A method to return all Ranged units in an army
     * @return The Ranged units in the army as a List<Unit>
     */
    public List<Unit> getRangedUnits() {
        return this.units.stream().filter(x -> x instanceof RangedUnit).collect(Collectors.toList());
    }

    /**
     * A method to return all Commander units in an army
     * @return The Commander units in the army as a List<Unit>
     */
    public List<Unit> getCommanderUnits() {
        return this.units.stream().filter(x -> x instanceof CommanderUnit).collect(Collectors.toList());
    }

    /**
     * A method to get the size of the army
     * @return the size as an int
     */
    public int getSize(){
        return this.units.size();
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

    /**
     * Method to return a list with all the units of a given type
     * @param unitType The unit type to find
     * @return the units as a List<Unit>
     */
    public List<Unit> getUnitsWithType(String unitType) {
        switch (unitType){
            case "[Commander]" -> {
                return getCommanderUnits();
            }
            case "[Cavalry]" -> {
                return getCavalryUnits();
            }
            case "[Infantry]" -> {
                return getInfantryUnits();
            }
            case "[Ranged]" -> {
                return getRangedUnits();
            }
            default -> throw new NoSuchElementException("Could not find the Unit type" + unitType);
        }
    }
}
