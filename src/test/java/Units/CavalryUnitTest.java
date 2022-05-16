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
    void getAttackBonusTest() {
        terrain = Terrain.STANDARD_TERRAIN;
        assertEquals(6, cav.getAttackBonus(terrain));
        assertEquals(2, cav.getAttackBonus(terrain));
    }

    @Test
    void getDefenceBonusTest() {
        assertEquals(1, cav.getDefenceBonus(terrain));
    }

}