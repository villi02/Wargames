module Wargames {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports App;
    exports App.Controllers;

    opens App;
}