package App.Controllers;


import App.Temp;
import Units.Army;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.ResourceBundle;


public class SimulationController implements Initializable {

    private Scene scene;
    private Stage stage;

    @FXML
    private GridPane GridPn;

    @FXML
    private ImageView ImgVwTerin;

    @FXML
    private Label LblArmy1;

    @FXML
    private Label LblArmy2;

    private final int gridHeight = 471;
    private final int gridWidth = 825;
    private HashMap<Integer, Node> coordinateLookUp = new HashMap<>();
    private int rMultiplier = 103;
    private int cMultiplier = 97;
    private int ARMY1SIZE = Temp.TempBattle.getArmyOne().getSize();
    private int ARMY2SIZE = Temp.TempBattle.getArmyTwo().getSize();
    private ArrayList<Node> testNodes = new ArrayList<>();

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

    public void reset(){
        displayArmy1(Temp.TempBattle.getArmyOne());
        displayArmy2(Temp.TempBattle.getArmyTwo());
        switch(Temp.TempBattle.getTerrain()){
            case HILL -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Hills.JPG").toURI().toString()));
            case PlAINS -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Plains.JPG").toURI().toString()));
            case FOREST -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Forest.JPG").toURI().toString()));
            case DYNAMIC_TIME -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Multi.png").toURI().toString()));
            case DYNAMIC_SPACE -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Multi.png").toURI().toString()));
        }

    }

    public void simulate() throws Exception {
        GridPn.getChildren().removeAll(testNodes);
        Army winner = Temp.TempBattle.simulate(Temp.TempBattle.getTerrain());
        ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/AfterBattle.JPG").toURI().toString()));
        String winnername = winner.getName();
        if (winnername.equals(Temp.TempBattle.getArmyOne().getName())){
            displayArmy1(winner);
        }
        else{
            displayArmy2(winner);
        }
        Temp.winner = winner;
    }

    public void setupGrid(){
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
            Rectangle rec = new Rectangle(this.recLength*4/3, this.recHeight*4/3);
            rec.setFill(Color.BLACK);
            GridPn.add(rec, this.middleClmn-1, i);
            GridPn.setHalignment(rec, HPos.CENTER);
            GridPn.setValignment(rec, VPos.CENTER);
            coordinateLookUp.put(103*this.middleClmn + 97*i, rec);

        }

        //Set grid Background
        switch(Temp.TempBattle.getTerrain()){
            case HILL -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Hills.JPG").toURI().toString()));
            case PlAINS -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Plains.JPG").toURI().toString()));
            case FOREST -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Forest.JPG").toURI().toString()));
            case DYNAMIC_TIME -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Multi.png").toURI().toString()));
            case DYNAMIC_SPACE -> ImgVwTerin.setImage(new Image(new File("src/main/resources/Images/Multi.png").toURI().toString()));
        }
        GridPn.setGridLinesVisible(true);
    }


    public void displayArmy1(Army army1) {

        LblArmy1.setText(army1.getName());

        int unitsPlacedArmy1 = 0;
        Shape icon = null;
        while (army1.getSize() > unitsPlacedArmy1){
            for (int i = this.middleClmn-2; i > 0; i--){
                for (int j = 0; j < this.numRows; j++){
                    try {
                        if (army1.getAllUnits().get(unitsPlacedArmy1).getType().equals("Commander")) {
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
                    if (unitsPlacedArmy1 == army1.getSize()){
                        break;
                    }
                    icon.toFront();
                    GridPn.add(icon, i, j);
                    GridPn.setHalignment(icon, HPos.CENTER);
                    GridPn.setValignment(icon, VPos.CENTER);
                    coordinateLookUp.put(103*j + 97*j, icon);
                    testNodes.add(icon);
                    unitsPlacedArmy1++;

                }
            }
        }
    }

    public void displayArmy2(Army army2) {

        LblArmy2.setText(army2.getName());
        int unitsPlacedArmy2 = 0;
        Shape icon = null;
        while (army2.getSize() > unitsPlacedArmy2){
            for (int i = this.middleClmn; i < numColumns; i++){
                for (int j = 0; j < numRows; j++){
                    try {
                        if (army2.getAllUnits().get(unitsPlacedArmy2).getType().equals("Commander")) {
                            icon = new Circle((this.recLength/2), Color.valueOf("#DF00FE"));
                        }
                        else{
                            icon = new Rectangle(this.recLength, this.recHeight,Color.valueOf("#DF00FE"));
                        }
                    } catch(Exception e){
                        break;
                    }

                    //icon = new Rectangle(this.recLength, this.recHeight);
                    assert icon != null;
                    if (unitsPlacedArmy2 == army2.getSize()){
                        break;
                    }
                    icon.toFront();
                    GridPn.add(icon, i, j);
                    GridPn.setHalignment(icon, HPos.CENTER);
                    GridPn.setValignment(icon, VPos.CENTER);
                    coordinateLookUp.put(103*j + 97*j, icon);
                    testNodes.add(icon);
                    unitsPlacedArmy2++;
                }
            }
        }
    }

    public void switchToBattleInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/BattleInfoNew.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBattleSummary(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/BattleSummary.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVariables();
        setupGrid();
        Temp.TempBattle.setArmyOne(Temp.TempBattle.getArmyOne());
        Temp.TempBattle.setArmyTwo(Temp.TempBattle.getArmyTwo());
        displayArmy1(Temp.TempBattle.getArmyOne());
        displayArmy2(Temp.TempBattle.getArmyTwo());
    }

}
