package App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CardGameController {
    /**
     * Initialize elements
     */
    @FXML
    public TextField cardsDealtField;

    @FXML
    public TextField amountOfCards;

    @FXML
    public TextField sumOfFacesField;

    @FXML
    public TextField cardOfHeartsField;

    @FXML
    public TextField queenSpadesField;

    @FXML
    public TextField flushField;


    /**
     * A method to deal hand and update all the text fields
     *
     * @param event the event
     */
    public void dealHand(ActionEvent event) {
        boolean nice = true;

    }
}