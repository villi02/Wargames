import App.FileManagement;
import Units.Army;
import Units.CommanderUnit;
import Units.InfantryUnit;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FileManagementTest {

    File army1File = new File("army1File.csv");
    FileManagement fileManagement = new FileManagement();
    Army army = new Army("Nice");


    @Test
    void TestWriteAndReadArmyToFile() throws IOException {
        Army army = new Army("Nice");
        IntStream.range(1,6).forEach(i -> {
            try {
                army.add(new InfantryUnit("Soldier", i));
                army.add(new CommanderUnit("Commander", 69));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        assertEquals(true, fileManagement.writeArmyToFile(army1File, army));
        Army army1Test = fileManagement.readArmyFromFile(army1File);
        assertEquals(true, army1Test.getAllUnits().size() == (army.getAllUnits().size()));
        assertEquals(true, army1Test.getName().equals(army.getName()));
        System.out.println(army1Test.getAllUnits());
        System.out.println(army.getAllUnits());

    }

}