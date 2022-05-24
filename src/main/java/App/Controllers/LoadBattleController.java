package App.Controllers;

import App.FileManagement;
import App.Temp;
import Units.Army;
import Units.Terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadBattleController {

    /**
     * Initialize elements
     */
    private Scene scene;
    private Stage stage;

    FileManagement fm = new FileManagement();


    /* public void switchCreate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/loadBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/

    /* public void switchToLoad(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/CreateBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/

    /**
     * A method to handle the loading of the Battle "Battle of the Bastards"
     * @param event the event as an ActionEvent
     */
    public void battleOfTheBastards(ActionEvent event) throws Exception {
        Army StarkArmy = fm.readArmyFromFile("Stark Army");
        Army BoltonArmy = fm.readArmyFromFile("Bolton Army");
        setupArmy(StarkArmy, BoltonArmy, Terrain.PlAINS);

        Parent root = FXMLLoader.load(getClass().getResource("/Simulation.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method to handle the loading of the battle "Battle of Pelennor Fields"
     * @param event
     */
    public void battleOfPelennorFields(ActionEvent event) throws Exception {
        Army GondorRohanArmy = fm.readArmyFromFile("Gondor Rohan Army");
        Army OrcArmy = fm.readArmyFromFile("Orc Army");
        setupArmy(GondorRohanArmy, OrcArmy, Terrain.PlAINS);

        Parent root = FXMLLoader.load(getClass().getResource("/Simulation.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method to handle the loading of the battle "Battle of Thermopylae"
     * @param event
     */
    public void battleOfThermopylae(ActionEvent event) throws Exception {
        Army SpartanArmy = fm.readArmyFromFile("Spartan Army");
        Army PersianArmy = fm.readArmyFromFile("Persian Army");
        setupArmy(SpartanArmy, PersianArmy, Terrain.PlAINS);

        Parent root = FXMLLoader.load(getClass().getResource("/Simulation.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setupArmy(Army army1, Army army2, Terrain terrain) throws Exception {
        Temp.Army1 = new Army(army1);
        Temp.Army2 = new Army(army2);
        Temp.TempBattle.setArmyOne(Temp.Army1);
        Temp.TempBattle.setArmyTwo(Temp.Army2);
        Temp.TempBattle.setTerrain(terrain);
    }

    /**
     * A method to handle closing the application
     * @param event the event as an ActionEvent
     */
    public void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to close the application!");
        alert.setContentText("Do you want to close the application?");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.exit(0);
        }
    }

     public void switchCreateOrLoad(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoadOrCreateBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
