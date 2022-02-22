package Units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {
    CavalryUnit cav = new CavalryUnit("Cav", 69);



    @Test
    void CavalryUnit() {
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
    void getAttackBonus() {
        assertEquals(6, cav.getAttackBonus());
        assertEquals(2, cav.getAttackBonus());
    }

    @Test
    void getDefenceBonus() {
        assertEquals(1, cav.getDefenceBonus());
    }

}