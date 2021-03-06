package App.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadOrCreateBattle {

    /**
     * Initialize elements
     */
    private Scene scene;
    private Stage stage;

    /**
     * A method to Switch to Create page
     * @param event the event as an ActionEvent
     * @throws IOException
     */
     public void switchCreateBattle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/CreateBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method to Switch to HomePage page
     * @param event the event as an ActionEvent
     * @throws IOException
     */
    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * A method to Switch to LoadBattle page
     * @param event the event as an ActionEvent
     * @throws IOException
     */
     public void switchToLoadBattle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoadBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

}
