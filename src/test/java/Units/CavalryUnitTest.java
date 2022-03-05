package Units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {
    CavalryUnit cav;

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
        assertEquals(6, zeus.getAttackBonus(), "First Attack bonus");
        assertEquals(2, zeus.getAttackBonus(), "Second Attack bonus");
        assertEquals(2, zeus.getAttackBonus(), "Third Attack bonus");
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
        assertEquals(6, cav.getAttackBonus());
        assertEquals(2, cav.getAttackBonus());
    }

    @Test
    void getDefenceBonusTest() {
        assertEquals(1, cav.getDefenceBonus());
    }

}