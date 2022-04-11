package Units;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

class ArmyTest {

    Army elves = new Army("elves");
    @BeforeEach
    void initArmy() throws Exception {
        for (int i = 0; i < 4; i++) {

            elves.units.add(new RangedUnit(String.format("Ranged nr: {0}", i), 69));
            elves.units.add(new InfantryUnit(String.format("Infantry nr: {0}", i), 420));
            elves.units.add(new CavalryUnit(String.format("Cavalry nr: {0}", i), 3000));
            elves.units.add(new CommanderUnit(String.format("Commander nr: {0}", i), 69420));
        }
    }
    @Test
    void getName() {
        assertEquals("elves", elves.getName());
    }

    @Test
    void add() throws Exception {
        elves.add(new RangedUnit("test trooper", 3));
        assertEquals(17, elves.units.size());
    }

    @Test
    void addAll() throws Exception {
        ArrayList<Unit> testunits = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            testunits.add(new CavalryUnit(String.format("nr: {0}", i),50 ));
        }
        elves.addAll(testunits);
        assertEquals(21,elves.units.size());
    }

    @Test
    void remove() {
        elves.remove(elves.getRandom());
        assertEquals(15, elves.units.size());
    }

    @Test
    void hasUnits() {
        assertEquals(true, elves.hasUnits());
    }

    @Test
    void getAllUnits() {
        ArrayList<Unit> test = elves.getAllUnits();
        assertEquals(true, test.equals(elves.units));
    }

    @Test
    void getRandom() {
        ArrayList<Unit> test = new ArrayList<>();
        Random random = new Random();
        test.add(elves.units.get(random.nextInt(elves.units.size())));
        assertEquals(1, test.size());

    }

    @Test
    void getInfantryUnits() throws Exception {
        elves.add(new InfantryUnit("Test Infantry", 420));
        elves.add(new InfantryUnit("Test Infantry", 420));
        assertEquals(true, elves.getInfantryUnits().size() == 6);
    }

    @Test
    void getCavalryUnits() throws Exception {
        elves.add(new CavalryUnit("Test Cavalry", 420));
        elves.add(new CavalryUnit("Test Cavalry", 420));
        elves.add(new CavalryUnit("Test Cavarly", 420));
        System.out.println(elves.getCavalryUnits().size());
        assertEquals(true, elves.getCavalryUnits().size() == 7);
    }

    @Test
    void getCommanderUnit() throws Exception {
        elves.add(new CommanderUnit("Test Commander", 420));
        elves.add(new CommanderUnit("Test Commander", 420));
        elves.add(new CommanderUnit("Test Commander", 420));
        elves.add(new CommanderUnit("Test Commander", 420));
        assertEquals(true, elves.getCommanderUnits().size() == 8);
    }

    @Test
    void getRangedUnits() throws Exception {
        elves.add(new RangedUnit("Test Ranged", 420));
        assertEquals(true, elves.getRangedUnits().size() == 5);
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}