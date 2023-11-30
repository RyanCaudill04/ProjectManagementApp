module demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens demo to javafx.fxml;
    exports demo;
}
