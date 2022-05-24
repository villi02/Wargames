package App.Controllers;

import App.Alertbox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;


public class HomePageController {

    /**
     * Initialize elements
     */
    private Scene scene;
    private Stage stage;


    /**
     * A method to handle switching page
     * @param event the event as an ActionEvent
     * @throws IOException
     */
    public void switchToLoadOrCreate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoadOrCreateBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method to display alertbox with potential help for the user
     * @param event the event as an ActionEvent
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


}
