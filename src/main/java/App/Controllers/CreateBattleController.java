package App.Controllers;

import App.Alertbox;
import App.FileManagement;
import App.Temp;
import Factory.UnitFactory;
import Factory.UnitType;
import Units.Army;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
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

    private ArrayList<Unit> displayedUnits = new ArrayList<>();

    private FileManagement fm = new FileManagement();

    @FXML
    private TextField txtInpTotlUnts;

    @FXML
    private TextField txtInpTotCvlry;

    @FXML
    private TextField txtInpTotCmndr;

    @FXML
    private TextField txtInpTotInftry;

    @FXML
    private TextField txtInpTotRngd;

    @FXML
    private ImageView imgViewUnitsPic;

    @FXML
    private ComboBox BtnPreMdArmies;

    @FXML
    private TableView UnitInoTbl;

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
    private TableColumn<Unit, String> TypeClmn;

    @FXML
    private ComboBox BtnUnitType;

    @FXML
    private TextField txtInpAmountUnits;

    @FXML
    private TextField txtInpHealthUnits;

    @FXML
    private TextField txtInpNameUnits;

    @FXML
    private TextField txtInpArmynm;

    private List<Character> wrongInput = List.of('æ','ø','å',',','.','!','-','_','+','?');

    private boolean validateInput(String input){
        for(int i=0; i<input.length(); i++){
            if(wrongInput.contains(input.charAt(i))) return false;
        }
        return true;
    }

    public void removeAll(){
        displayedUnits.clear();
        DisplayUnitTable(displayedUnits);
    }

    public void DisplayUnitTable(ArrayList<Unit> unitArray) {
        displayedUnits = unitArray;
        ObservableList<Unit> units = FXCollections.observableArrayList(unitArray);
        UnitInoTbl.getItems().clear();
        UnitInoTbl.setItems(units);

        txtInpTotlUnts.setText(String.valueOf(unitArray.size()));
        int totalCavalry = (int) unitArray.stream().filter(unit -> "Cavalry".equals(unit.getType())).count();
        txtInpTotCvlry.setText(String.valueOf(totalCavalry));

        int totalCommander = (int) unitArray.stream().filter(unit -> "Commander".equals(unit.getType())).count();
        txtInpTotCmndr.setText(String.valueOf(totalCommander));

        int totalInfantry = (int) unitArray.stream().filter(unit -> "Infantry".equals(unit.getType())).count();
        txtInpTotInftry.setText(String.valueOf(totalInfantry));

        int totalRanged = (int) unitArray.stream().filter(unit -> "Ranged".equals(unit.getType())).count();
        txtInpTotRngd.setText(String.valueOf(totalRanged));


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
     * A method to display image of units
     */
    public void displayImage(){
        switch (BtnUnitType.getValue().toString()){
            case "Cavalry" -> imgViewUnitsPic.setImage(new Image(new File("src/main/resources/Images/Cavalry.JPG").toURI().toString()));
            case "Commander" -> imgViewUnitsPic.setImage(new Image(new File("src/main/resources/Images/Commander.JPG").toURI().toString()));
            case "Infantry" -> imgViewUnitsPic.setImage(new Image(new File("src/main/resources/Images/Infantry.jpeg").toURI().toString()));
            case "Ranged" -> imgViewUnitsPic.setImage(new Image(new File("src/main/resources/Images/Archer.JPG").toURI().toString()));
        }
    }

    /**
     * A method to remove a unit from the temp army
     */
    public void removeUnit() {
        ObservableList unitsToBeRemoved = UnitInoTbl.getSelectionModel().getSelectedItems();
        unitsToBeRemoved.stream().forEach(unit -> displayedUnits.remove(unit));
        DisplayUnitTable(displayedUnits);
    }

    public void saveToArmy1() {
        ObservableList unitsToBeAdded = UnitInoTbl.getItems();
        ArrayList<Unit> unitsToBeAddedArrayList = new ArrayList<>();
        try{
            unitsToBeAdded.stream().forEach(unit -> unitsToBeAddedArrayList.add((Unit) unit));
        }catch (Exception e){
            Alertbox.display("Error", "Something went wrong when saving to Army 1");
        }

        if (txtInpArmynm.getText().equals("") && Temp.Army1.getName().equals("")){
            Alertbox.display("Error", "Your army does not have a name, and you didn't insert an army name \n NB: Your army name will be set to 'Army1' if you do nothing");
        }
        else if(txtInpArmynm.getText().equals(Temp.Army2.getName())){
            Alertbox.display("Error", "Can't have the same name as army2");
        }
        else{
            Temp.Army1.setName(txtInpArmynm.getText());
        }

        Temp.Army1.addAll(unitsToBeAddedArrayList);
        Temp.newUnits.clear();
        DisplayUnitTable(Temp.Army1.getAllUnits());
    }

    public void displayTempArmy1() {
        DisplayUnitTable(Temp.Army1.getAllUnits());
        try{
        txtInpArmynm.setText(Temp.Army1.getName());
        }catch (NullPointerException e){
            txtInpArmynm.setText("");
        }
    }

    public void saveToArmy2() {
        ObservableList unitsToBeAdded = UnitInoTbl.getItems();
        ArrayList<Unit> unitsToBeAddedArrayList = new ArrayList<>();
        try{
            unitsToBeAdded.stream().forEach(unit -> unitsToBeAddedArrayList.add((Unit) unit));
        }catch (Exception e){
            Alertbox.display("Error", "Something went wrong when saving to Army 2");
        }

        if (txtInpArmynm.getText().equals("") && Temp.Army2.getName().equals("")){
            Alertbox.display("Error", "Your army does not have a name, and you didn't insert an army name \n NB: Your army name will be set to 'Army2' if you do nothing");
        }
        else if(txtInpArmynm.getText().equals(Temp.Army1.getName())){
            Alertbox.display("Error", "Can't have the same name as army1");
        }
        else{
            Temp.Army2.setName(txtInpArmynm.getText());
        }

        Temp.Army2.addAll(unitsToBeAddedArrayList);
        Temp.newUnits.clear();
        DisplayUnitTable(Temp.Army2.getAllUnits());
    }

    public void displayTempArmy2() {
        DisplayUnitTable(Temp.Army2.getAllUnits());
        try{
            txtInpArmynm.setText(Temp.Army2.getName());
        }catch (NullPointerException e){
            txtInpArmynm.setText("");
        }
    }



     public void switchToLoad(ActionEvent event) throws IOException {
        if (Temp.Army1.getName().equals("")){
            Temp.Army1.setName("Army1");
        }

         if (Temp.Army2.getName().equals("")){
             Temp.Army2.setName("Army2");
         }

         if (Temp.Army1.getAllUnits().isEmpty() || Temp.Army2.getAllUnits().isEmpty()){
             Alertbox.display("Error", "Both armies need to have units to continue to simulation");
         } else {

             Parent root = FXMLLoader.load(getClass().getResource("/BattleInfoNew.fxml"));
             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
         }
    }

    public void insertArmyFromFile() throws Exception {
        FileManagement fm = new FileManagement();
        Army armyFromFile = new Army(fm.readArmyFromFile(BtnPreMdArmies.getValue().toString()));
        DisplayUnitTable(armyFromFile.getAllUnits());
        txtInpArmynm.setText(armyFromFile.getName());

    }

    public void saveToFiles() {
        if (txtInpArmynm.getText().equals("")) {
            Alertbox.display("Error", "An army name is needed when saving to files");
        }

        else if (!validateInput(txtInpArmynm.getText())){
            Alertbox.display("Error!", "Army name can't contain these characters: " + wrongInput);
        }

        else if (fm.getArmyNames().contains(txtInpArmynm.getText())){
            Alertbox.display("Error", "There already exist an army with the selected name in files");
        }

        else{

            try{
                String path = "src/main/resources/Armies/" + txtInpArmynm.getText() + ".csv";
                File newArmyToFiles = new File(path);
                fm.writeArmyToFile(newArmyToFiles, new Army(displayedUnits,txtInpArmynm.getText()));
            } catch (Exception e){
                Alertbox.display("Error", "Something went wrong when saving to files");
            }
            BtnPreMdArmies.getItems().add(txtInpArmynm.getText());
        }

    }

    public void switchToLoadOrCreateBattle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoadOrCreateBattle.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        InitializeTableColumn(NameClmn, HealthClmn, AttackClmn, ArmorClmn, TypeClmn);

        BtnPreMdArmies.getItems().addAll(fm.getArmyNames());

        BtnUnitType.getItems().addAll(
                "Cavalry",
                "Commander",
                "Infantry",
                "Ranged"
        );
    }

    static void InitializeTableColumn(TableColumn<Unit, String> nameClmn, TableColumn<Unit, String> healthClmn, TableColumn<Unit, Integer> attackClmn, TableColumn<Unit, Integer> armorClmn, TableColumn<Unit, String> typeClmn) {
        nameClmn.setCellValueFactory(new PropertyValueFactory<Unit, String>("Name"));
        healthClmn.setCellValueFactory(new PropertyValueFactory<Unit, String>("Health"));
        attackClmn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("Attack"));
        armorClmn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("Armor"));
        typeClmn.setCellValueFactory(new PropertyValueFactory<Unit, String>("Type"));

    }
}
