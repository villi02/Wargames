package Units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommanderUnitTest {

    CommanderUnit cody;

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
    void getAttackBonus(){
        assertEquals(6, cody.getAttackBonus());
        assertEquals(2, cody.getAttackBonus());
    }

    @Test
    void getDefenceBonus() {
        assertEquals(1, cody.getDefenceBonus());
    }

    @Test
    void theString(){
        assertEquals(String.format("Unit- name: %s, health: %d, attack: %d, armor: %d ", "Cody", 69, 25, 15), cody.toString());
    }
}