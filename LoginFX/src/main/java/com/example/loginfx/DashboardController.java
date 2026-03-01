package com.example.loginfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblWelcome;

    public void setUsuario(String usuario) {
        lblWelcome.setText("Bienvenido, " + usuario);
    }
}