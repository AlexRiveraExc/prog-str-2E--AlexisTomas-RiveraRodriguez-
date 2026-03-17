package com.example.demolistedad.repository;

import com.example.demolistedad.Persona;
import java.io.*;
import java.util.*;

public class PersonaFileRepository {

    private final String archivo = "personas.txt";

    public void guardar(Persona p) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(p.getNombre() + "," + p.getCorreo() + "," + p.getEdad());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Persona> obtener() {
        List<Persona> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                lista.add(new Persona(d[0], d[1], Integer.parseInt(d[2])));
            }
        } catch (Exception e) {
            // si no existe el archivo, no pasa nada
        }

        return lista;
    }

    public void eliminar(Persona persona) {
        List<Persona> lista = obtener();

        lista.removeIf(p ->
                p.getNombre().equals(persona.getNombre()) &&
                        p.getCorreo().equals(persona.getCorreo()) &&
                        p.getEdad() == persona.getEdad()
        );

        guardarLista(lista);
    }

    private void guardarLista(List<Persona> lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Persona p : lista) {
                pw.println(p.getNombre() + "," + p.getCorreo() + "," + p.getEdad());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}