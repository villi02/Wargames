import Units.*;

import java.util.Scanner;
import java.util.stream.IntStream;

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

    public final int EXIT = 9;

    public Client(){
    }

    /**
     * Initialize the armies
     */
      private Army human;
      private Army orcish;


    Scanner scStr = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);

    /**
     * The main method
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Client go = new Client();
        go.testData();
        //Battle battle = new battle(human, orcish);
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
        for (int i = 0; i < 100; i++)
        {
            human.add(new CavalryUnit("Knight", 100));
        }
        IntStream.range(0, 200).forEach(i -> {
            try {
                human.add(new RangedUnit("Archer", 100));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        human.add(new CommanderUnit("Mountain King", 180));


        // Orcish

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
             try {
                 orcish.add(new CommanderUnit("Gul'dan", 180));
             } catch (Exception e) {
                 e.printStackTrace();
             }
         });

        }

    public void start()
    {
        while (true){
            int choice = this.menuChoice();
            switch(choice){
                case VALG1:

                    break;
                case VALG2:

                    break;
                case VALG3:

                    break;
                case VALG4:

                    break;
                case VALG5:

                    break;
                case VALG6:

                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Fant ikke ditt menyvalg, følg instruksjoner som er gitt");
                    break;
            }
        }
    }

    public int menuChoice()
    {
        int choice = 0;
        System.out.println("Hva vil du gjøre?");
        System.out.println("1: ");
        System.out.println("2: ");
        System.out.println("3: ");
        System.out.println("4: ");
        System.out.println("5: ");
        System.out.println("6: ");
        choice = scInt.nextInt();
        if (scInt.hasNextInt())
        {
            choice = scInt.nextInt();
        }
        else
        {
            System.out.println("Du må oppgi en av valgene over");
        }
        return choice;
    }

}
