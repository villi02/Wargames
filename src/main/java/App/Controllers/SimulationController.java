package App.Controllers;

import App.FileManagement;
import App.Temp;
import Units.Army;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class SimulationController implements Initializable {

    @FXML
    private GridPane GridPn;

    @FXML
    private AnchorPane AnchrGridBckgrnd;

    FileManagement fm = new FileManagement();
    Army testArmy = fm.readArmyFromFile("Nice");

    private final int gridHeight = 471;
    private final int gridWidth = 825;
    private HashMap<Integer, Node> coordinateLookUp = new HashMap<>();
    private int rMultiplier = 103;
    private int cMultiplier = 97;
    private int ARMY1SIZE = Temp.TempBattle.getArmyOne().getAllUnits().size();
    private int ARMY2SIZE = Temp.TempBattle.getArmyTwo().getAllUnits().size();

    double recLength;
    double recHeight;
    int numColumns;
    int numRows;
    int middleClmn;


    public SimulationController() throws IOException {
    }

    public void setVariables(){
        //Calculate how many rows and columns to create
        if (ARMY1SIZE > ARMY2SIZE){
            this.numRows = (int) Math.sqrt(ARMY1SIZE) + 1;
        } else{
            this.numRows = (int) Math.sqrt(ARMY2SIZE) + 1;
        }
        this.numColumns = numRows*2 + 1;


        this.recLength = (gridWidth/numColumns)*3/4;
        this.recHeight =  (gridHeight/numRows)*3/4;

        this.middleClmn = (numColumns + 1)/2;
    }


    public void setupGrid(){

        AnchrGridBckgrnd.setStyle("-fx-background-color: BROWN");

        //Add all necessary rows
        for (int row = 0 ; row < this.numRows ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setPercentHeight(100d / this.numRows);
            rc.setVgrow(Priority.ALWAYS);
            GridPn.addRow(row);
            GridPn.getRowConstraints().add(rc);
        }
        //Add all necessary columns
        for (int col = 0 ; col < this.numColumns; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setPercentWidth(100d / this.numColumns);
            GridPn.addColumn(col);
            GridPn.getColumnConstraints().add(cc);
        }

        // Set the middle cells as black
        for (int i = 0; i < this.numRows; i++){
            Rectangle rec = new Rectangle(this.recLength, this.recHeight);
            rec.setFill(Color.BLACK);
            GridPn.add(rec, this.middleClmn-1, i);
            GridPn.setHalignment(rec, HPos.CENTER);
            GridPn.setValignment(rec, VPos.CENTER);
            coordinateLookUp.put(103*this.middleClmn + 97*i, rec);
        }

        //Set grid Background

    }

    public void displayArmy1() {

        int unitsPlacedArmy1 = 0;
        Shape icon = null;
        while (ARMY1SIZE > unitsPlacedArmy1){
            for (int i = this.middleClmn-2; i > 0; i--){
                for (int j = 0; j < this.numRows; j++){
                    try {
                        if (Temp.TempBattle.getArmyOne().getAllUnits().get(unitsPlacedArmy1).getType().equals("Commander")) {
                            icon = new Circle((this.recLength/2), Color.valueOf("#FF5F1F"));
                        }
                        else{
                            icon = new Rectangle(this.recLength, this.recHeight,Color.valueOf("#FF5F1F"));
                        }
                    } catch(Exception e){
                        break;
                    }

                    //icon = new Rectangle(this.recLength, this.recHeight);
                    assert icon != null;
                    if (unitsPlacedArmy1 == ARMY1SIZE){
                        break;
                    }
                    icon.toFront();
                    GridPn.add(icon, i, j);
                    GridPn.setHalignment(icon, HPos.CENTER);
                    GridPn.setValignment(icon, VPos.CENTER);
                    coordinateLookUp.put(103*j + 97*j, icon);
                    unitsPlacedArmy1++;

                }
            }
        }
    }

    public void displayArmy2() {


        int unitsPlacedArmy2 = 0;
        while (ARMY2SIZE > unitsPlacedArmy2){
            for (int i = this.middleClmn; i < numColumns; i++){
                for (int j = 0; j < numRows; j++){
                    Rectangle rec = new Rectangle(this.recLength, this.recHeight);
                    rec.setFill(Color.valueOf("#82FF06"));
                    if (unitsPlacedArmy2 == ARMY2SIZE){
                        break;
                    }
                    GridPn.add(rec, i, j);
                    GridPn.setHalignment(rec, HPos.CENTER);
                    GridPn.setValignment(rec, VPos.CENTER);
                    coordinateLookUp.put(103*j + 97*j, rec);
                    unitsPlacedArmy2++;

                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVariables();
        setupGrid();
        Temp.TempBattle.setArmyOne(Temp.TempBattle.getArmyOne());
        Temp.TempBattle.setArmyTwo(Temp.TempBattle.getArmyTwo());
        displayArmy1();
        displayArmy2();
    }

}
