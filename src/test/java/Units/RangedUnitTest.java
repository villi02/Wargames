package Units;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {


    RangedUnit archer;

    @BeforeEach
    void setUp(){
        archer = new RangedUnit("William", 69);
    }

    @Test
    void getAttackBonus() {
        assertEquals(3, archer.getAttackBonus(), "should return 3 every time");
        assertEquals(3, archer.getAttackBonus(), "should return 3 every time");
    }

    @Test
    void getDefenceBonus() {
        assertEquals(6, archer.getDefenceBonus(), "fist defence bonus");
        assertEquals(4, archer.getDefenceBonus(), "second defence bonus");
        assertEquals(2, archer.getDefenceBonus(), "third defence bonus");
        assertEquals(2, archer.getDefenceBonus(), "third defence bonus");
        assertEquals(2, archer.getDefenceBonus(), "third defence bonus");
        assertEquals(2, archer.getDefenceBonus(), "third defence bonus");
    }


    @Test
    void RangedUnit() {
        RangedUnit ranger = new RangedUnit("William", 69, 3, 6);
        assertEquals("William", ranger.getName());
        assertEquals(69, ranger.getHealth());
        assertEquals(3, ranger.getAttack());
        assertEquals(6, ranger.getArmor());
        assertEquals(6, ranger.getDefenceBonus(), "First defence bonus");
        assertEquals(4, ranger.getDefenceBonus(), "Second defence bonus");
        assertEquals(2, ranger.getDefenceBonus(), "Third defence bonus");
    }

    @Test
    void getName() {
        assertEquals("William", archer.getName());
    }
}