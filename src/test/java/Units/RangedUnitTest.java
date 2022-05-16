package Units;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {

    Terrain terrain = Terrain.STANDARD_TERRAIN;
    RangedUnit archer;

    @BeforeEach
    void setUp() throws Exception {
        archer = new RangedUnit("William", 69);
    }

    @Test
    void getAttackBonus() {
        assertEquals(3, archer.getAttackBonus(terrain), "should return 3 every time");
        assertEquals(3, archer.getAttackBonus(terrain), "should return 3 every time");
    }

    @Test
    void getDefenceBonus() {
        assertEquals(6, archer.getDefenceBonus(terrain), "fist defence bonus");
        assertEquals(4, archer.getDefenceBonus(terrain), "second defence bonus");
        assertEquals(2, archer.getDefenceBonus(terrain), "third defence bonus");
        assertEquals(2, archer.getDefenceBonus(terrain), "third defence bonus");
        assertEquals(2, archer.getDefenceBonus(terrain), "third defence bonus");
        assertEquals(2, archer.getDefenceBonus(terrain), "third defence bonus");
    }


    @Test
    void RangedUnit() throws Exception {
        RangedUnit ranger = new RangedUnit("William", 69, 3, 6);
        assertEquals("William", ranger.getName());
        assertEquals(69, ranger.getHealth());
        assertEquals(3, ranger.getAttack());
        assertEquals(6, ranger.getArmor());
        assertEquals(6, ranger.getDefenceBonus(terrain), "First defence bonus");
        assertEquals(4, ranger.getDefenceBonus(terrain), "Second defence bonus");
        assertEquals(2, ranger.getDefenceBonus(terrain), "Third defence bonus");
    }

    @Test
    void getName() {
        assertEquals("William", archer.getName());
    }
}