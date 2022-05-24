package App.Controllers;

import App.Alertbox;
import App.Temp;
import Units.Terrain;
import Units.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BattleInfoNewController implements Initializable {

    /**
     * Initializing components
     */
    private Scene scene;
    private Stage stage;

    @FXML
    private Label LblArmy1;

    @FXML
    private Label LblArmy2;

    @FXML
    private TextField txtInp1TotUnits;

    @FXML
    private TextField txtInp2TotUnits;

    @FXML
    private TextField txtInp1TotCvlry;

    @FXML
    private TextField txtInp2TotCvlry;

    @FXML
    private TextField txtInp1Cmndr;

    @FXML
    private TextField txtInp2Cmndr;

    @FXML
    private TextField txtInp1TotIntry;

    @FXML
    private TextField txtInp2TotIntry;

    @FXML
    private TextField txtInp1TotRngd;

    @FXML
    private TextField txtInp2TotRngd;

    @FXML
    private TextField txtInp1TotArmyHlth;

    @FXML
    private TextField txtInp2TotArmyHlth;

    @FXML
    private TextField txtInp1TotArmyAttk;

    @FXML
    private TextField txtInp2TotArmyAttk;

    @FXML
    private TextField txtInp1TotArmyArmr;

    @FXML
    private TextField txtInp2TotArmyArmr;

    @FXML
    private ComboBox BtnTerrain;

    public void setTerrain() {
        switch(BtnTerrain.getValue().toString()){
            case "Hills" -> Temp.terrain = Terrain.HILL;
            case "Plains" -> Temp.terrain = Terrain.PlAINS;
            case "Forest" -> Temp.terrain = Terrain.FOREST;
            case "Standard Terrain" -> Temp.terrain = Terrain.STANDARD_TERRAIN;
            //case "Dynamic (Time-wise)" -> Temp.terrain = Terrain.DYNAMIC_TIME;
            //case "Dynamic (Space-wise)" -> Temp.terrain = Terrain.DYNAMIC_SPACE;
            default -> Temp.terrain = Terrain.STANDARD_TERRAIN;
        }
    }

    public Boolean createBattle() {
        //Check if no terrain is provided, if no Terrain is provided then it is set to Standard Terrain
        try {
            if (BtnTerrain.getValue().equals(null)) {
                Temp.terrain = Terrain.STANDARD_TERRAIN;
            } else {
                setTerrain();
            }
        } catch (NullPointerException e){
            Temp.terrain = Terrain.STANDARD_TERRAIN;
        }
        try {
            //Check if army1 has name
            if (Temp.Army1.getName().equals("")){
                Temp.Army1.setName("Army1");
            }
            // Check if army2 has name
            if (Temp.Army2.getName().equals("")){
                Temp.Army2.setName("Army2");
            }



            // Set up battle
            Temp.TempBattle.setArmyOne(Temp.Army1);
            Temp.TempBattle.setArmyTwo(Temp.Army2);
            Temp.TempBattle.setTerrain(Temp.terrain);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void switchToCreateBattle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/CreateBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSimulate(ActionEvent event) throws IOException {
        if (!createBattle()){
            Alertbox.display("Error", "Something went wrong when creating battle");
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("/Simulation.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        LblArmy1.setText(Temp.Army1.getName());
        LblArmy2.setText(Temp.Army2.getName());



        // Add Total amount of units to textfield
        txtInp1TotUnits.setText(String.valueOf(Temp.Army1.getAllUnits().size()));
        txtInp2TotUnits.setText(String.valueOf(Temp.Army2.getAllUnits().size()));

        // Add Total amount of Cavalry units to textfield
        txtInp1TotCvlry.setText(String.valueOf(Temp.Army1.getCavalryUnits().size()));
        txtInp2TotCvlry.setText(String.valueOf(Temp.Army2.getCavalryUnits().size()));

        // Add Total amount of Commander units to textfield
        txtInp1Cmndr.setText(String.valueOf(Temp.Army1.getCommanderUnits().size()));
        txtInp2Cmndr.setText(String.valueOf(Temp.Army2.getCommanderUnits().size()));

        // Add Total amount of Infantry units to textfield
        txtInp1TotIntry.setText(String.valueOf(Temp.Army1.getInfantryUnits().size()));
        txtInp2TotIntry.setText(String.valueOf(Temp.Army2.getInfantryUnits().size()));

        // Add Total amount of Ranged units to textfield
        txtInp1TotRngd.setText(String.valueOf(Temp.Army1.getRangedUnits().size()));
        txtInp2TotRngd.setText(String.valueOf(Temp.Army2.getRangedUnits().size()));

        // Add the total health of armies to textfield
        txtInp1TotArmyHlth.setText(String.valueOf(Temp.Army1.getAllUnits().stream().mapToInt(Unit::getHealth).sum()));
        txtInp2TotArmyHlth.setText(String.valueOf(Temp.Army2.getAllUnits().stream().mapToInt(Unit::getHealth).sum()));

        // Add the total Attack of armies to textfield
        txtInp1TotArmyAttk.setText(String.valueOf(Temp.Army1.getAllUnits().stream().mapToInt(Unit::getAttack).sum()));
        txtInp2TotArmyAttk.setText(String.valueOf(Temp.Army2.getAllUnits().stream().mapToInt(Unit::getAttack).sum()));

        // Add the total Armor to textfield
        txtInp1TotArmyArmr.setText(String.valueOf(Temp.Army1.getAllUnits().stream().mapToInt(Unit::getArmor).sum()));
        txtInp2TotArmyArmr.setText(String.valueOf(Temp.Army2.getAllUnits().stream().mapToInt(Unit::getArmor).sum()));

        // Add terrain options
        BtnTerrain.getItems().addAll(
                "Hills",
                "Plains",
                "Forest",
                "Standard Terrain"
                //"Dynamic (Time-wise)",
                //"Dynamic (Space-wise)"
        );
    }
}
