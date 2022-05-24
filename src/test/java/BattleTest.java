import Units.Army;
import Units.Battle;
import Units.InfantryUnit;
import Units.Terrain;
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
        assertEquals(human.getName(), test.simulate().getName());
    }

    @Test
    void attack() throws Exception {
        human.add(new InfantryUnit("Footman", 100));
        orcish.add(new InfantryUnit("Grunt", 100));
        test.attack(human.getRandom(), orcish.getRandom());
        assertEquals(94, orcish.getRandom().getHealth());
    }

    @Test
    void attackWithTerrain() throws Exception {
        human.add(new InfantryUnit("Footman", 100));
        orcish.add(new InfantryUnit("Grunt", 100));
        test.attack(human.getRandom(), orcish.getRandom(), Terrain.FOREST);
        assertEquals(94, orcish.getRandom().getHealth());
    }

    @Test
    void getArmy(){
        assertEquals(true, test.getArmyOne().equals(human));
        assertEquals(false, test.getArmyOne().equals(orcish));
        assertEquals(true, test.getArmyTwo().equals(orcish));
    }

    @Test
    void testToString() {
    }
}