package com.example.contactoemergencia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class ContactoController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbParentesco;
    @FXML
    private ListView<Contacto> listViewContactos;

    private ObservableList<Contacto> contactos;
    private final String[] parentescos =
            {"Padre",
                    "Madre",
                    "Hermano",
                    "Hermana",
                    "Abuelo",
                    "Abuela",
                    "Tío",
                    "Tía"};

    public void initialize() {
        contactos = FXCollections.observableArrayList();
        cmbParentesco.getItems().addAll(parentescos);
        listViewContactos.setItems(contactos);
    }

    @FXML
    public void agregarContacto() {
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String parentesco = cmbParentesco.getValue();

        if (validarContacto(nombre, telefono, parentesco)) {
            Contacto nuevoContacto = new Contacto(nombre, telefono, parentesco);
            contactos.add(nuevoContacto);
            limpiarCampos();
        }
    }

    @FXML
    public void buscarContacto() {
        String nombre = txtNombre.getText().trim();
        Optional<Contacto> contactoOpt = contactos.stream().filter(c -> c.getNombre().equals(nombre)).findFirst();

        if (contactoOpt.isPresent()) {
            Contacto contacto = contactoOpt.get();
            txtTelefono.setText(contacto.getTelefono());
            cmbParentesco.setValue(contacto.getParentesco());
        } else {
            mostrarMensaje("el contacto no se encuentra guardado.");
        }
    }

    @FXML
    public void actualizarContacto() {
        String nombre = txtNombre.getText().trim();
        Optional<Contacto> contactoOpt = contactos.stream().filter(c -> c.getNombre().equals(nombre)).findFirst();

        if (contactoOpt.isPresent()) {
            Contacto contacto = contactoOpt.get();
            contacto.setTelefono(txtTelefono.getText().trim());
            contacto.setParentesco(cmbParentesco.getValue());
            listViewContactos.refresh();
            limpiarCampos();
        } else {
            mostrarMensaje("contacto no existente.");
        }
    }

    @FXML
    public void eliminarContacto() {
        String nombre = txtNombre.getText().trim();
        contactos.removeIf(c -> c.getNombre().equals(nombre));
        limpiarCampos();
    }

    @FXML
    public void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
    }

    private boolean validarContacto(String nombre, String telefono, String parentesco) {
        if (nombre.isEmpty() || telefono.isEmpty() || parentesco == null) {
            mostrarMensaje("llenar todos los campos (obligatorio).");
            return false;
        }
        if (telefono.length() != 10) {
            mostrarMensaje("El telelefono debe ser de 10 dígitos.");
            return false;
        }
        if (contactos.stream().anyMatch(c -> c.getNombre().equals(nombre))) {
            mostrarMensaje("ya existe un contacto con ese nommbre.");
            return false;
        }
        return true;
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}