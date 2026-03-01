package com.example.loginfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("login.fxml"));
        Scene scene = new Scene(loader.load(), 300, 250);
        stage.setTitle("Login FX");
        stage.setScene(scene);
        stage.show();
    }
}