package com.example.demolistview.repository;

import com.example.demolistedad.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaFileRepository {

    private final String ARCHIVO = "data/personas.txt";

    public List<Persona> cargarPersonas() {

        List<Persona> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                String nombre = datos[0];
                String correo = datos[1];
                int edad = Integer.parseInt(datos[2]);

                lista.add(new Persona(nombre, correo, edad));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void guardarPersona(Persona p) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {

            bw.write(p.getNombre() + "," + p.getCorreo() + "," + p.getEdad());
            bw.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}