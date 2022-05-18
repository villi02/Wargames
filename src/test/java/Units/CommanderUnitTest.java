package Units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommanderUnitTest {

    CommanderUnit cody;
    Terrain terrain = Terrain.STANDARD_TERRAIN;

    @BeforeEach
     void testData()
    {
        try {
            cody = new CommanderUnit("Cody", 69);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void CommanderUnit() throws Exception {
        CommanderUnit commando = new CommanderUnit("Commando", 69, 420, 600);
        assertEquals("Commando", commando.getName());
        assertEquals(69, commando.getHealth());
        assertEquals(420, commando.getAttack());
        assertEquals(600, commando.getArmor());
        assertEquals(6, commando.getAttackBonus());
        assertEquals(2, commando.getAttackBonus());
        assertEquals(1, commando.getDefenceBonus());
    }

    @Test
    void CommanderUnitNegative() throws Exception {
        Army test = new Army("test");
        assertThrows(Exception.class, () -> {
            test.add(new CommanderUnit("Exception", -69));
        });
    }


    @Test
    void getAttackBonusNoTerrain(){
        assertEquals(6, cody.getAttackBonus());
        assertEquals(2, cody.getAttackBonus());
    }

    @Test
    void getDefenceBonusNoTerrain() {
        assertEquals(1, cody.getDefenceBonus());
    }

    @Test
    void theString(){
        assertEquals(String.format("Unit- name: %s, health: %d, attack: %d, armor: %d ", "Cody", 69, 25, 15), cody.toString());
    }

    @Test
    void getDefenceBonusForest() { assertEquals(0, cody.getDefenceBonus(Terrain.FOREST), "Should be zero every time");}

    @Test
    void getDefencebonusNotForest() {
        assertEquals(1, cody.getDefenceBonus(Terrain.PlAINS), "Should be 1 every time");
        assertEquals(1, cody.getDefenceBonus(Terrain.HILL), "Should be 1 every time");
        assertEquals(1, cody.getDefenceBonus(), "Should be 1 every time");
        assertEquals(1, cody.getDefenceBonus(Terrain.STANDARD_TERRAIN), "Should be 1 every time");
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
        CommanderUnit comStandard = new CommanderUnit("Standard Terrain", 420);
        assertEquals(6, comStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "First attack: Should be 6");
        assertEquals(2, comStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "Second attack: Should be 2");
        assertEquals(2, comStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "Third attack: Should be 2");
        assertEquals(2, comStandard.getAttackBonus(Terrain.STANDARD_TERRAIN), "Fourth attack: Should be 2");

        CavalryUnit comNormal = new CavalryUnit("No Terrain", 420);
        assertEquals(6, comNormal.getAttackBonus(), "First attack: Should be 6");
        assertEquals(2, comNormal.getAttackBonus(), "Second attack: Should be 2");
        assertEquals(2, comNormal.getAttackBonus(), "Third attack: Should be 2");
        assertEquals(2, comNormal.getAttackBonus(), "Fourth attack: Should be 2");

        CavalryUnit comForest = new CavalryUnit("Forest Terrain", 420);
        assertEquals(6, comForest.getAttackBonus(Terrain.FOREST), "First attack: Should be 6");
        assertEquals(2, comForest.getAttackBonus(Terrain.FOREST), "Second attack: Should be 2");
        assertEquals(2, comForest.getAttackBonus(Terrain.FOREST), "Third attack: Should be 2");
        assertEquals(2, comForest.getAttackBonus(Terrain.FOREST), "Fourth attack: Should be 2");
    }
}