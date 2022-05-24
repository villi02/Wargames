package App.Controllers;

import App.Alertbox;
import App.Temp;
import Units.Army;
import Units.Terrain;
import Units.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BattleSummaryController implements Initializable {

    /**
     * Initializing components
     */
    private Scene scene;
    private Stage stage;

    @FXML
    private TextField txtInpWnr;

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


    public void switchToSimulate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Simulation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        LblArmy1.setText(Temp.Army1.getName());
        LblArmy2.setText(Temp.Army2.getName());

        txtInpWnr.setText(Temp.winner.getName());

        if (Temp.winner.getName().equals(Temp.TempBattle.getArmyOne().getName())){
            Army army1AfterBattle = Temp.winner;
            Army army1BeforeBattle = Temp.TempBattle.getArmyOne();
            Army army2 = Temp.TempBattle.getArmyTwo();

            txtInp1TotUnits.setText(String.valueOf(army1AfterBattle.getAllUnits().size()));
            txtInp2TotUnits.setText(String.valueOf(0));

            txtInp1TotCvlry.setText(String.valueOf(army1AfterBattle.getAllUnits().size()));
            txtInp2TotCvlry.setText(String.valueOf(0));

            txtInp1Cmndr.setText(String.valueOf(army1AfterBattle.getCommanderUnits().size()));
            txtInp2Cmndr.setText(String.valueOf(0));

            txtInp1TotIntry.setText(String.valueOf(army1AfterBattle.getInfantryUnits().size()));
            txtInp2TotIntry.setText(String.valueOf(0));

            txtInp1TotRngd.setText(String.valueOf(army1AfterBattle.getRangedUnits().size()));
            txtInp2TotRngd.setText(String.valueOf(0));

            txtInp1TotArmyHlth.setText(String.valueOf(army1AfterBattle.getAllUnits().stream().mapToInt(Unit::getHealth).sum()));
            txtInp2TotArmyHlth.setText(String.valueOf(0));

            int healthBeforeArmy1 = army1BeforeBattle.getAllUnits().stream().mapToInt(Unit::getHealth).sum();
            int healthAfterArmy1 = army1AfterBattle.getAllUnits().stream().mapToInt(Unit::getHealth).sum();
            int healthBeforeArmy2 = army2.getAllUnits().stream().mapToInt(Unit::getHealth).sum();
            txtInp1TotArmyAttk.setText(String.valueOf(healthBeforeArmy2));
            txtInp2TotArmyAttk.setText(String.valueOf((healthBeforeArmy1 - healthAfterArmy1)));
        }
        else{
            Army army2AfterBattle = Temp.winner;
            Army army1 = Temp.TempBattle.getArmyOne();
            Army army2BeforeBattle = Temp.TempBattle.getArmyTwo();

            txtInp2TotUnits.setText(String.valueOf(army2AfterBattle.getAllUnits().size()));
            txtInp1TotUnits.setText(String.valueOf(0));

            txtInp2TotCvlry.setText(String.valueOf(army2AfterBattle.getAllUnits().size()));
            txtInp1TotCvlry.setText(String.valueOf(0));

            txtInp2Cmndr.setText(String.valueOf(army2AfterBattle.getCommanderUnits().size()));
            txtInp1Cmndr.setText(String.valueOf(0));

            txtInp2TotIntry.setText(String.valueOf(army2AfterBattle.getInfantryUnits().size()));
            txtInp1TotIntry.setText(String.valueOf(0));

            txtInp2TotRngd.setText(String.valueOf(army2AfterBattle.getRangedUnits().size()));
            txtInp1TotRngd.setText(String.valueOf(0));

            txtInp2TotArmyHlth.setText(String.valueOf(army2AfterBattle.getAllUnits().stream().mapToInt(Unit::getHealth).sum()));
            txtInp1TotArmyHlth.setText(String.valueOf(0));

            int healthBeforeArmy2 = army2BeforeBattle.getAllUnits().stream().mapToInt(Unit::getHealth).sum();
            int healthAfterArmy2 = army2AfterBattle.getAllUnits().stream().mapToInt(Unit::getHealth).sum();
            int healthBeforeArmy1 = army1.getAllUnits().stream().mapToInt(Unit::getHealth).sum();
            txtInp2TotArmyAttk.setText(String.valueOf(healthBeforeArmy1));
            txtInp1TotArmyAttk.setText(String.valueOf(healthBeforeArmy2 - healthAfterArmy2));
        }
    }
}
