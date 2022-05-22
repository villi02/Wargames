module Wargames {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports App;
    exports Units;
    exports App.Controllers;

    opens App;
    opens App.Controllers;
    opens Units;
}