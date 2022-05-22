package App.Controllers;

import App.Temp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleInfoNewController implements Initializable {

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


    public void createBattle() {
        
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
        txtInp1TotArmyHlth.setText(String.valueOf(Temp.Army1.getAllUnits().stream().mapToInt(unit -> unit.getHealth()).sum()));
        txtInp2TotArmyHlth.setText(String.valueOf(Temp.Army2.getAllUnits().stream().mapToInt(unit -> unit.getHealth()).sum()));

        // Add the total Attack of armies to textfield
        txtInp1TotArmyAttk.setText(String.valueOf(Temp.Army1.getAllUnits().stream().mapToInt(unit -> unit.getAttack()).sum()));
        txtInp2TotArmyAttk.setText(String.valueOf(Temp.Army2.getAllUnits().stream().mapToInt(unit -> unit.getAttack()).sum()));

        // Add the total Armor to textfield
        txtInp1TotArmyArmr.setText(String.valueOf(Temp.Army1.getAllUnits().stream().mapToInt(unit -> unit.getArmor()).sum()));
        txtInp2TotArmyArmr.setText(String.valueOf(Temp.Army2.getAllUnits().stream().mapToInt(unit -> unit.getArmor()).sum()));

        // Add terrain options
        BtnTerrain.getItems().addAll(
                "Hills",
                "Plains",
                "Forest",
                "Standard Terrain",
                "Dynamic (Time-wise)",
                "Dynamic (Space-wise)"
        );
    }
}
