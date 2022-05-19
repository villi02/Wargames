package App.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class LoadBattle {

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
