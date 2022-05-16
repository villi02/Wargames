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
        assertEquals(6, commando.getAttackBonus(terrain));
        assertEquals(2, commando.getAttackBonus(terrain));
        assertEquals(1, commando.getDefenceBonus(terrain));
    }

    @Test
    void CommanderUnitNegative() throws Exception {
        Army test = new Army("test");
        assertThrows(Exception.class, () -> {
            test.add(new CommanderUnit("Exception", -69));
        });
    }


    @Test
    void getAttackBonus(){
        assertEquals(6, cody.getAttackBonus(terrain));
        assertEquals(2, cody.getAttackBonus(terrain));
    }

    @Test
    void getDefenceBonus() {
        assertEquals(1, cody.getDefenceBonus(terrain));
    }

    @Test
    void theString(){
        assertEquals(String.format("Unit- name: %s, health: %d, attack: %d, armor: %d ", "Cody", 69, 25, 15), cody.toString());
    }
}