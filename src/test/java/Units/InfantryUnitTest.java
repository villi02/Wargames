package Units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfantryUnitTest {

    InfantryUnit infant = new InfantryUnit("Joe", 69);
    Terrain terrain = Terrain.STANDARD_TERRAIN;

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
    void getDefenceBonusForrest() { assertEquals(3, infant.getDefenceBonus(Terrain.FOREST));}

    @Test
    void GetAttackBonusForrest() { assertEquals(4, infant.getAttackBonus(Terrain.FOREST));}

    @Test
    void GetAttackBonusNotForrest() {
        assertEquals(2, infant.getAttackBonus(Terrain.STANDARD_TERRAIN));
        assertEquals(2, infant.getAttackBonus(Terrain.PlAINS));
        assertEquals(2, infant.getAttackBonus(Terrain.HILL));
    }

    @Test
    void GetDefenceBonusNotForrest() {
        assertEquals(1, infant.getDefenceBonus(Terrain.STANDARD_TERRAIN));
        assertEquals(1, infant.getDefenceBonus(Terrain.HILL));
        assertEquals(1, infant.getDefenceBonus(Terrain.PlAINS));
    }

    @Test
    void setHealth(){
        infant.setHealth(420);
        assertEquals(420, infant.getHealth());
    }
}