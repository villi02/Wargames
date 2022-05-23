package App.Controllers;

import App.FileManagement;
import Units.Army;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class SimulationController implements Initializable {

    @FXML
    private GridPane GridPn;

    enum BattleSize{
        SMALL,
        MEDIUM,
        LARGE
    }

    private HashMap<Integer, Node> coordinateLookUp = new HashMap<>();
    private int rMultiplier = 103;
    private int cMultiplier = 97;

    FileManagement fm = new FileManagement();
    Army testArmy = fm.readArmyFromFile("Nice");
    int painted = 0;

    public SimulationController() throws IOException {
    }


    public void Paint(int i, int j) {

        Rectangle rec = new Rectangle(10, 10);
        if (j == testArmy.getAllUnits().size()-1 || j == 0){
            rec.setFill(Color.AQUA);
        }
        else {
            rec.setFill(Color.RED);
        }
        GridPn.add(rec, i, j);
    }

    public void displayArmies() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numRows = 60;
        int numColumns = 60;
        for (int row = 0 ; row < numRows ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setPercentHeight(100d / numRows);
            rc.setVgrow(Priority.ALWAYS);
            GridPn.addRow(row);
            GridPn.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col < numColumns; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setPercentWidth(100d / numColumns);
            GridPn.addColumn(col);
            GridPn.getColumnConstraints().add(cc);
        }


        Rectangle rec1 = new Rectangle(10, 10);
        rec1.setFill(Color.RED);

        Rectangle rec2 = new Rectangle(10, 10);
        rec2.setFill(Color.BLACK);

        Rectangle rec3 = new Rectangle(10, 10);
        rec3.setFill(Color.BLUE);

        for (int i = 0; i < 1; i++){
            for (int j = 0; j < testArmy.getAllUnits().size(); j++){
                Rectangle rec = new Rectangle(10, 10);
                if (j == testArmy.getAllUnits().size()-1 || j == 0){
                    rec.setFill(Color.RED);
                }
                else {
                    rec.setFill(Color.AQUA);
                }
                GridPn.add(rec, i, j);
            }
        }

        GridPn.add(rec2, 14,4 );
        GridPn.add(rec3, 19,19 );
        GridPn.add(new Label("You're"), 1, 3);
        GridPn.add(new Label("Cute!"), 2, 3);
    }
}
