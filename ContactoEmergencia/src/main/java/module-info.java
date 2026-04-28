module com.example.contactoemergencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactoemergencia to javafx.fxml;
    exports com.example.contactoemergencia;
}