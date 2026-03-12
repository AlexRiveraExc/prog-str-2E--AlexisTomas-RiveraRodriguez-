package com.example.demolistedad.controllers;

import com.example.demolistedad.Persona;
import com.example.demolistedad.repository.PersonaFileRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppController {

    @FXML private TextField nombreField;
    @FXML private TextField correoField;
    @FXML private TextField edadField;
    @FXML private ListView<Persona> listView;
    @FXML private Label detalleLabel;

    private PersonaFileRepository repo = new PersonaFileRepository();

    @FXML
    public void initialize() {
        cargar();

        listView.getSelectionModel().selectedItemProperty().addListener((obs,o,p)->{
            if(p!=null){
                detalleLabel.setText(
                        "Nombre: " + p.getNombre() +
                                "\nCorreo: " + p.getCorreo() +
                                "\nEdad: " + p.getEdad()
                );
            }
        });
    }

    @FXML
    public void guardarPersona(){

        String nombre = nombreField.getText();
        String correo = correoField.getText();
        int edad;

        // validar nombre
        if(nombre.isEmpty()){
            alerta("El nombre es obligatorio");
            return;
        }

        // validar correo
        if(!correoValido(correo)){
            alerta("Correo invalido");
            return;
        }

        // validar edad numerica
        try{
            edad = Integer.parseInt(edadField.getText());
        }catch(Exception e){
            alerta("Edad invalida");
            return;
        }

        // validar edad mayor de 18
        if(edad < 18){
            alerta("Solo mayores de 18");
            return;
        }

        Persona p = new Persona(nombre,correo,edad);
        repo.guardar(p);
        cargar();

        nombreField.clear();
        correoField.clear();
        edadField.clear();
    }

    // VALIDACION DE CORREO
    private boolean correoValido(String correo){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return correo.matches(regex);
    }

    private void cargar(){
        listView.setItems(FXCollections.observableArrayList(repo.obtener()));
    }

    private void alerta(String m){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(m);
        a.showAndWait();
    }
}
