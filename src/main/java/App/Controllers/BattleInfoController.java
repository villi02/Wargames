package App.Controllers;

import App.FileManagement;
import App.Temp;
import Units.Army;
import Units.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BattleInfoController implements Initializable {

    /**
     * Initializing components
     */
    private Scene scene;
    private Stage stage;

    @FXML
    private TableView<Unit> UnitInoTbl;

    @FXML
    private TableColumn<Unit, String> NameClmn;

    @FXML
    private TableColumn<Unit, String> HealthClmn;

    @FXML
    private TableColumn<Unit, Integer> AttackClmn;

    @FXML
    private TableColumn<Unit, Integer> ArmorClmn;

    @FXML
    private ListView<String> UnitType;

    @FXML
    private ListView<String> UnitInfoList;

    FileManagement fm = new FileManagement();
    Army army1 = fm.readArmyFromFile(new File("army1File.csv"));
    Army originalArmy = fm.readArmyFromFile(new File("army1File.csv"));

    public BattleInfoController() throws IOException {
    }

    public void DisplayUnits() {
        ArrayList<String> UnitTypes = new ArrayList<>();
        army1.getAllUnits().stream().filter(unit -> !UnitTypes.contains(unit.getType())).forEach(unit -> UnitTypes.add(unit.getType()));

        UnitType.getItems().clear();
        for (String unitType : UnitTypes) {
            UnitType.getItems().add(unitType);
        }
        UnitType.getSelectionModel().selectedItemProperty().addListener((observableValue, unit, t1) -> {
            String currentUnit = String.valueOf(UnitType.getSelectionModel().getSelectedItems());
            DisplayUnitsTable(currentUnit);
        });

        DisplayUnitTable(army1.getAllUnits());

    }


    public void DisplayUnit(Unit unit) {
        //Todo
    }

    public void DisplayUnitTable(List<Unit> unitArray) {
        ObservableList<Unit> units = FXCollections.observableArrayList(unitArray);
        UnitInoTbl.getItems().clear();
        UnitInoTbl.setItems(units);

    }

    public void DisplayUnitsTable(String unitType) {
        DisplayUnitTable(army1.getUnitsWithType(unitType));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NameClmn.setCellValueFactory(new PropertyValueFactory<Unit, String>("Name"));
        HealthClmn.setCellValueFactory(new PropertyValueFactory<Unit, String>("Health"));
        AttackClmn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("attack"));
        ArmorClmn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("armor"));

        DisplayUnits();

    }

    public void changeToArmy2(ActionEvent event) {
        army1 = Temp.Army2;
        DisplayUnits();
    }

    public void changeToArmy1(ActionEvent event) {
        army1 = originalArmy;
        DisplayUnits();
    }

}
