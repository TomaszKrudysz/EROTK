module com.example.erptk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.erptk to javafx.fxml;
    exports com.example.erptk;
    exports com.example.erptk.controller;
    opens com.example.erptk.controller to javafx.fxml;
}