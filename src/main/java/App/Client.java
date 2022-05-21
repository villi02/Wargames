package App;

import Units.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client {


    /**
     * Initialize the choices
     */
    public final int VALG1 = 1;
    public final int VALG2 = 2;
    public final int VALG3 = 3;
    public final int VALG4 = 4;
    public final int VALG5 = 5;
    public final int VALG6 = 6;

    public final int EXIT = 7;

    public Client(){
    }

    /**
     * Initialize the armies
     */
      private Army human;
      private Army orcish;
      private Battle battle;


    Scanner scStr = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);

    /**
     * The main method
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Client go = new Client();
        go.testData();
        while (true)
        {
            go.start();
        }
    }


    /**
     * Creates instances to be used as test data
     */
    public void testData() throws Exception {

        // Human Army
        human = new Army("Human");

        IntStream.range(0, 500).forEach(i -> {
            try {
                human.add(new InfantryUnit("Footman", 100));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        IntStream.range(0, 100).forEach(i -> {
            try {
                human.add(new CavalryUnit("Knight", 100));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        IntStream.range(0, 200).forEach(i -> {
            try {
                human.add(new RangedUnit("Archer", 100));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        human.add(new CommanderUnit("Mountain King", 180));


        // Orcish
        orcish = new Army("Orcish");

         IntStream.range(0,500).forEach(i -> {
             try {
                 orcish.add(new InfantryUnit("Grunt", 100));
             } catch (Exception e) {
                 e.printStackTrace();
             }
         });

         IntStream.range(0,100).forEach(i -> {
             try {
                 orcish.add(new CavalryUnit("Raider", 100));
             } catch (Exception e) {
                 e.printStackTrace();
             }
         });

         IntStream.range(0,200).forEach(i -> {
             try {
                 orcish.add(new RangedUnit("Spearman", 100));
             } catch (Exception e) {
                 e.printStackTrace();
             }

         });

        try {
            orcish.add(new CommanderUnit("Gul'dan", 180));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize Units.Battle
        battle = new Battle(human, orcish);

        }

    /**
     * Method to call the functions and for the user to give input
     */
    public void start() throws Exception {
        while (true){
            int choice = this.menuChoice();
            switch(choice){
                case VALG1:
                    System.out.println("Army sizes:");
                    System.out.println(String.format("Human size: %d", human.getAllUnits().size()));
                    System.out.println(String.format("Orcish size: %d", orcish.getAllUnits().size()));

                    break;
                case VALG2:
                    System.out.println(String.format("The winning army: %s",battle.simulate().getName()));


                    break;
                case VALG3:
                    System.out.println("Name:");
                    String humanName = scStr.nextLine();
                    System.out.println("Health:");
                    int humanHealth = scInt.nextInt();
                    System.out.println("Attack:");
                    int humanAttack = scInt.nextInt();
                    System.out.println("Armor:");
                    int humanArmor = scInt.nextInt();
                    try {
                        human.add(new InfantryUnit(humanName, humanHealth, humanAttack, humanArmor));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    break;
                case VALG4:
                    System.out.println("Name:");
                    String orcishName = scStr.nextLine();
                    System.out.println("Health:");
                    int orcishHealth = scInt.nextInt();
                    System.out.println("Attack:");
                    int orcishAttack = scInt.nextInt();
                    System.out.println("Armor:");
                    int orcishArmor = scInt.nextInt();
                    try {
                        orcish.add(new InfantryUnit(orcishName, orcishHealth, orcishAttack, orcishArmor));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    break;
                case VALG5:
                    Path path = Paths.get("src/main/resources/Armies");
                    try (Stream<Path> subPaths = Files.walk(path, 1)) {
                        subPaths.filter(Files::isRegularFile).forEach(a -> {
                            try {
                                BufferedReader brTest = new BufferedReader(new FileReader(String.valueOf(a)));
                                System.out.println(brTest.readLine());
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    break;
                case VALG6:

                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }
        }
    }

    /**
     * A method to get the input of the user, to be used in start()
     * @return The choice as an int
     */
    public int menuChoice()
    {
        int choice = 0;
        System.out.println("What dou you want to do?");
        System.out.println("1: Get the size of each army");
        System.out.println("2: Simulate Units.Battle ");
        System.out.println("3: Add new Unit to Human");
        System.out.println("4: Add new Unit to Orcish");
        System.out.println("5: Print all armies in files");
        System.out.println("6: ");
        System.out.println("7: Quit ");
        choice = scInt.nextInt();
        if (choice < 0 || choice > 8) {
            System.out.println("Must be one of the options stated");
        }
        return choice;
    }

}
