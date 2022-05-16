package Units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {
    CavalryUnit cav;
    Terrain terrain = Terrain.STANDARD_TERRAIN;

    @BeforeEach
    void testData() throws Exception{
        cav = new CavalryUnit("Cav", 69);
    }

    @Test
    void CavalryUnitTest() throws Exception {
        CavalryUnit zeus = new CavalryUnit("Zeus", 69, 3, 6);
        assertEquals("Zeus", zeus.getName());
        assertEquals(69, zeus.getHealth());
        assertEquals(3, zeus.getAttack());
        assertEquals(6, zeus.getArmor());
        assertEquals(6, zeus.getAttackBonus(terrain), "First Attack bonus");
        assertEquals(2, zeus.getAttackBonus(terrain), "Second Attack bonus");
        assertEquals(2, zeus.getAttackBonus(terrain), "Third Attack bonus");
    }

    @Test
    void CavalryUnitNegativeTest() throws Exception {
        Army test = new Army("test");
        assertThrows(Exception.class, () -> {
            test.add(new CavalryUnit("Exception", -69));
        });
    }


    @Test
    void getAttackBonusStandardTerrain() {
        terrain = Terrain.STANDARD_TERRAIN;
        assertEquals(6, cav.getAttackBonus(terrain));
        assertEquals(2, cav.getAttackBonus(terrain));
    }


    @Test
    void getDefenceBonusForest() { assertEquals(0, cav.getDefenceBonus(Terrain.FOREST), "Should be zero every time");}

    @Test
    void getDefencebonusNotForest() {
        assertEquals(1, cav.getDefenceBonus(Terrain.PlAINS), "Should be 1 every time");
        assertEquals(1, cav.getDefenceBonus(Terrain.HILL), "Should be 1 every time");
        assertEquals(1, cav.getDefenceBonus(), "Should be 1 every time");
        assertEquals(1, cav.getDefenceBonus(Terrain.STANDARD_TERRAIN), "Should be 1 every time");
    }
    @Test
    void getAttackBonusPlains() throws Exception {
        CavalryUnit newCav = new CavalryUnit("Kasdis", 69);
        assertEquals(8, newCav.getAttackBonus(Terrain.PlAINS), "First attack: Should be 8");
        assertEquals(4, newCav.getAttackBonus(Terrain.PlAINS), "Second attack: Should be 4");
        assertEquals(4, newCav.getAttackBonus(Terrain.PlAINS), "Third attack: Should be 4");
        assertEquals(4, newCav.getAttackBonus(Terrain.PlAINS), "Fourth attack: Should be 4");
    }

    @Test
    void getAttackBonusNotPlains() throws Exception {
        CavalryUnit cavStandard = new CavalryUnit("Standard Terrain", 420);
        assertEquals(6, cavStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "First attack: Should be 6");
        assertEquals(2, cavStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "Second attack: Should be 2");
        assertEquals(2, cavStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "Third attack: Should be 2");
        assertEquals(2, cavStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "Fourth attack: Should be 2");

        CavalryUnit cavNormal = new CavalryUnit("No Terrain", 420);
        assertEquals(6, cavNormal.getAttackBonus(), "First attack: Should be 6");
        assertEquals(2, cavNormal.getAttackBonus(), "Second attack: Should be 2");
        assertEquals(2, cavNormal.getAttackBonus(), "Third attack: Should be 2");
        assertEquals(2, cavNormal.getAttackBonus(), "Fourth attack: Should be 2");

        CavalryUnit cavForest = new CavalryUnit("Forest Terrain", 420);
        assertEquals(6, cavForest.getAttackBonus(Terrain.FOREST), "First attack: Should be 6");
        assertEquals(2, cavForest.getAttackBonus(Terrain.FOREST), "Second attack: Should be 2");
        assertEquals(2, cavForest.getAttackBonus(Terrain.FOREST), "Third attack: Should be 2");
        assertEquals(2, cavForest.getAttackBonus(Terrain.FOREST), "Fourth attack: Should be 2");
    }

}