package Units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfantryUnitTest {

    InfantryUnit infant = new InfantryUnit("Joe", 69);

    InfantryUnitTest() throws Exception {
    }

    @Test
    void InfantryUnit() throws Exception {
        InfantryUnit madJack = new InfantryUnit("Mad Jack", 25, 4, 3);
        assertEquals("Mad Jack", madJack.getName());
        assertEquals(25, madJack.getHealth());
        assertEquals(4, madJack.getAttack());
        assertEquals(3, madJack.getArmor());
        assertEquals(2, madJack.getAttackBonus());
        assertEquals(1, madJack.getDefenceBonus());
    }

    @Test
    void getAttackBonus() {
        assertEquals(2, infant.getAttackBonus());
    }

    @Test
    void getDefenceBonus() {
        assertEquals(1, infant.getDefenceBonus());
    }

    @Test
    void setHealth(){
        infant.setHealth(420);
        assertEquals(420, infant.getHealth());
    }
}