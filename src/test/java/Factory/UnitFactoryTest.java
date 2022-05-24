package Factory;

import Units.CavalryUnit;
import Units.InfantryUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitFactoryTest {

    UnitFactory factory = new UnitFactory();

    @Test
    void getSingleUnit() throws Exception {
        assertEquals(true, factory.getSingleUnit(UnitType.CAVALRY, "ivar", 50) instanceof CavalryUnit);
        assertEquals(false, factory.getSingleUnit(UnitType.RANGED, "ivar", 50) instanceof InfantryUnit);
    }

    @Test
    void getMultipleUnits() {
        assertEquals(50, factory.getMultipleUnits(UnitType.CAVALRY, 50, "Ragnar", 70).size());
        assertEquals(true, factory.getMultipleUnits(UnitType.CAVALRY, 50, "Bjorn", 60).get(34) instanceof CavalryUnit);
    }
}