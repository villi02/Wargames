package App.Controllers;

import App.Alertbox;
import App.Temp;
import Factory.UnitFactory;
import Factory.UnitType;
import Units.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateBattleController implements Initializable {

    /**
     * Initializing components
     */
    private Scene scene;
    private Stage stage;

    private String selectedUnit = "";

    @FXML
    private TableView UnitInoTbl;

    @FXML
    private ImageView imgViewUnitsPic;

    @FXML
    private Button BtnAddUnits;

    @FXML
    private TableColumn<Unit, String> NameClmn;

    @FXML
    private TableColumn<Unit, String> HealthClmn;

    @FXML
    private TableColumn<Unit, Integer> AttackClmn;

    @FXML
    private TableColumn<Unit, Integer> ArmorClmn;

    @FXML
    private ComboBox BtnUnitType;

    @FXML
    private TextField txtInpAmountUnits;

    @FXML
    private TextField txtInpHealthUnits;

    @FXML
    private TextField txtInpNameUnits;

    private List<Character> wrongInput = List.of('æ','ø','å',',','.','!','-','_','+','?');

    private boolean validateInput(String input){
        for(int i=0; i<input.length(); i++){
            if(wrongInput.contains(input.charAt(i))) return false;
        }
        return true;
    }

    public void DisplayUnitTable(List<Unit> unitArray) {
        ObservableList<Unit> units = FXCollections.observableArrayList(unitArray);
        UnitInoTbl.getItems().clear();
        UnitInoTbl.setItems(units);

    }

    public void addUnits() {
        if (txtInpAmountUnits.getText().equals("")|| txtInpHealthUnits.getText().equals("") || txtInpNameUnits.getText().equals("")) {
            Alertbox.display("Error!", "TextField cant be blank");
        }
        else if (!validateInput(txtInpAmountUnits.getText()) || !validateInput(txtInpHealthUnits.getText()) || !validateInput(txtInpNameUnits.getText())){
            Alertbox.display("Error!", "TextField can't contain these characters: " + wrongInput);
        }
        else{
            String unitName = txtInpNameUnits.getText();
            int unitHealth = 0;
            int unitAmount = 0;
            try{
               unitHealth = Integer.parseInt(txtInpHealthUnits.getText());
            } catch(Exception e){
                Alertbox.display("Error", "The health points must be a number");
            }
            try{
                unitAmount = Integer.parseInt(txtInpAmountUnits.getText());
            } catch(Exception e){
                Alertbox.display("Error", "The unit amount must be a number");
            }

            UnitFactory unitFactory = new UnitFactory();
            switch (BtnUnitType.getValue().toString()){
                case "Cavalry" -> Temp.newUnits.addAll(unitFactory.getMultipleUnits(UnitType.CAVALRY, unitAmount, unitName, unitHealth));
                case "Commander" ->Temp.newUnits.addAll(unitFactory.getMultipleUnits(UnitType.COMMANDER, unitAmount, unitName, unitHealth));
                case "Infantry" -> Temp.newUnits.addAll(unitFactory.getMultipleUnits(UnitType.INFANTRY, unitAmount, unitName, unitHealth));
                case "Ranged" -> Temp.newUnits.addAll(unitFactory.getMultipleUnits(UnitType.RANGED, unitAmount, unitName, unitHealth));
            }

            DisplayUnitTable(Temp.newUnits);
        }


    }

    /**
     * A method to remove a unit from the temp army
     */
    public void removeUnit() {
        ObservableList unitsToBeRemoved = UnitInoTbl.getSelectionModel().getSelectedItems();
        unitsToBeRemoved.stream().forEach(unit -> Temp.newUnits.remove(unit));
        DisplayUnitTable(Temp.newUnits);
    }

    public void saveToArmy1() {
        ObservableList unitsToBeAdded = UnitInoTbl.getItems();
        ArrayList<Unit> unitsToBeAddedArrayList = new ArrayList<>();
        try{
            unitsToBeAddedArrayList = (ArrayList<Unit>) unitsToBeAdded;
        }catch (Exception e){
            Alertbox.display("Error", "Something went wrong when saving to Army 1");
        }
        Temp.Army1.addAll(unitsToBeAddedArrayList);
        DisplayUnitTable(Temp.Army1.getAllUnits());
    }

    public void displayTempArmy1() {
        DisplayUnitTable(Temp.Army1.getAllUnits());
    }

    public void saveToArmy2() {
        ObservableList unitsToBeAdded = UnitInoTbl.getItems();
        ArrayList<Unit> unitsToBeAddedArrayList = new ArrayList<>();
        try{
            unitsToBeAddedArrayList = (ArrayList<Unit>) unitsToBeAdded;
        }catch (Exception e){
            Alertbox.display("Error", "Something went wrong when saving to Army 1");
        }
        Temp.Army2.addAll(unitsToBeAddedArrayList);
        DisplayUnitTable(Temp.Army2.getAllUnits());
    }

    public void displayTempArmy2() {
        DisplayUnitTable(Temp.Army2.getAllUnits());
    }

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

    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BtnUnitType.valueProperty().addListener(((observableValue, o, t1) -> {
            selectedUnit = BtnUnitType.getValue().toString();
        }));


        NameClmn.setCellValueFactory(new PropertyValueFactory<Unit, String>("Name"));
        HealthClmn.setCellValueFactory(new PropertyValueFactory<Unit, String>("Health"));
        AttackClmn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("attack"));
        ArmorClmn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("armor"));

        BtnUnitType.getItems().addAll(
                "Cavalry",
                "Commander",
                "Infantry",
                "Ranged"
        );
    }
}
