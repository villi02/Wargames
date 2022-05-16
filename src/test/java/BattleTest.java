import Units.Army;
import Units.Battle;
import Units.InfantryUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    public Army human,orcish;
    public Battle test;

    @BeforeEach
    void testData() throws Exception {
            human = new Army("human");
            orcish = new Army("orcish");
            test = new Battle(human, orcish);

    }

    @Test
    void simulate() throws Exception {
        human.add(new InfantryUnit("Footman", 100));
        human.add(new InfantryUnit("Footman", 100));
        orcish.add(new InfantryUnit("Grunt", 3));
        assertEquals(human, test.simulate());
    }

    @Test
    void attack() throws Exception {
        human.add(new InfantryUnit("Footman", 100));
        orcish.add(new InfantryUnit("Grunt", 100));
        test.attack(human.getRandom(), orcish.getRandom());
        assertEquals(94, orcish.getRandom().getHealth());
    }

    @Test
    void testToString() {
    }
}