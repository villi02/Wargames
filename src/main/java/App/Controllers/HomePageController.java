package App.Controllers;

import App.Alertbox;
import App.FileManagement;
import App.Temp;
import Units.Army;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class HomePageController {

    /**
     * Initialize elements
     */
    private Scene scene;
    private Stage stage;

    @FXML
    private Button TestBtn;


    public void switchToLoadOrCreate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoadOrCreateBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


   /* public void switchToArmyCreator(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ArmyCreator.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/
    /*public void switchToArmyCreator(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ArmyCreator.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/
    public void helpButton(ActionEvent event){
        Alertbox.display("Help","The developer is sorry that you're having problems, there's nothing he can do for you. \n - Yours truly");
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

    public void ArmyInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/BattleInfo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ChangeTxt(ActionEvent event) throws Exception {
        FileManagement fm = new FileManagement();
        Army army2 = fm.readArmyFromFile(new File("NewTestArmy.csv"));
        Temp.Army2 = army2;
        TestBtn.setText("Changed!");

    }

}
