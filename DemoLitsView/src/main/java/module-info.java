module com.example.demolitsview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolitsview to javafx.fxml;
    exports com.example.demolitsview;
}