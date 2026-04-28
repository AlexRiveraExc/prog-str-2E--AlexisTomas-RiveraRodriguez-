package com.example.loginfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtCorreo;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;

    @FXML
    public void login() {
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();

        if (correo.isEmpty() || correo.length() < 4) {
            lblError.setText("Usuario mínimo 4 caracteres");
            return;
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            lblError.setText("Correo inválido");
            return;
        }

        if (password.length() < 6) {
            lblError.setText("Password mínimo 6 caracteres");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("dashboard.fxml"));
            Scene scene = new Scene(loader.load(), 300, 200);

            DashboardController controller = loader.getController();
            controller.setUsuario(correo);

            Stage stage = (Stage) txtCorreo.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}