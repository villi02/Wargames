package App;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WargamesApp extends Application {





/**
 * The type Card game app.
 */



    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/cardGameView.fxml"));
        primaryStage.setTitle("Card Game");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }
}