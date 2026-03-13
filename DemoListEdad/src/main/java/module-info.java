module com.example.demolistedad {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demolistedad.controllers to javafx.fxml;
    opens com.example.demolistedad to javafx.fxml;
    exports com.example.demolistedad;
}