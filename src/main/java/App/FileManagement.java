package App;

import Units.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileManagement {

    /**
     * Method to write army to file
     * @param file The file to be written to
     * @param army The army to be written
     * @return true if successfully written
     * @throws IOException
     */
    public boolean writeArmyToFile(File file, Army army) throws IOException {
        if (!file.getName().endsWith(".csv")){
            throw new IOException("Wrong file format");
        }

        ArrayList<Unit> units = army.getAllUnits();
        StringBuilder line = new StringBuilder();

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(line.append(army.getName()).append("\n").toString());
            units.forEach(x -> {
                try {
                    StringBuilder unitLine = new StringBuilder();
                    fileWriter.write(unitLine.append(x.getClass().getSimpleName()).append(",")
                            .append(x.getName()).append(",")
                            .append(x.getHealth()).append("\n")
                            .toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            return true;
        }
    }

    /**
     * Method to read army from file
     * @param file the file to be read
     * @return the army
     * @throws IOException
     */
    public Army readArmyFromFile(File file) throws IOException {
        if (!file.getName().endsWith(".csv")){
            throw new IOException("Wrong file format");
        }

        ArrayList<Unit> units = new ArrayList<>();
        Army army = new Army("Army name");

        //Go through every line of the file, check first line for army name
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // should be first line of army
                if (!line.contains(",")) {
                    army.setName(line);
                }
                else {
                    List<String> lineElements = Arrays.asList(line.split(","));
                    switch (lineElements.get(0)) {
                        case "CavalryUnit" -> army.add(new CavalryUnit(lineElements.get(1), Integer.parseInt(lineElements.get(2))));
                        case "CommanderUnit" -> army.add(new CommanderUnit(lineElements.get(1), Integer.parseInt(lineElements.get(2))));
                        case "InfantryUnit" -> army.add(new InfantryUnit(lineElements.get(1), Integer.parseInt(lineElements.get(2))));
                        case "RangedUnit" -> army.add(new RangedUnit(lineElements.get(1), Integer.parseInt(lineElements.get(2))));
                        default -> System.out.println("Something went wrong");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return army;
    }

    public Army readArmyFromFile(String armyName) throws IOException {
        Path path = Paths.get("src/main/resources/Armies");
        ArrayList<String> foundArmyPath = new ArrayList<>();
        try (Stream<Path> subPaths = Files.walk(path, 1)) {
            subPaths.filter(Files::isRegularFile).forEach(a -> {
                try {
                    BufferedReader brReader = new BufferedReader(new FileReader(String.valueOf(a)));
                    if (brReader.readLine().equals(armyName)){
                        foundArmyPath.add(a.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!foundArmyPath.isEmpty()){
            return readArmyFromFile(new File(foundArmyPath.get(0)));
        }
        else{
            return null;
        }
    }

    public ArrayList<String> getArmyNames() {
        ArrayList<String> armyNames = new ArrayList<>();
        Path path = Paths.get("src/main/resources/Armies");
        try (Stream<Path> subPaths = Files.walk(path, 1)) {
            subPaths.filter(Files::isRegularFile).forEach(a -> {
                try {
                    BufferedReader brReader = new BufferedReader(new FileReader(String.valueOf(a)));
                    armyNames.add(brReader.readLine());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return armyNames;
    }
}
