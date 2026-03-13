package com.example.demolistedad.repository;

import com.example.demolistedad.Persona;
import java.io.*;
import java.util.*;

public class PersonaFileRepository {

    private static final String FILE = "personas.txt";

    public void guardar(Persona p){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE,true))){
            bw.write(p.getNombre()+","+p.getCorreo()+","+p.getEdad());
            bw.newLine();
        }catch(Exception e){}
    }

    public List<Persona> obtener(){

        List<Persona> lista = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(FILE))){

            String l;

            while((l=br.readLine())!=null){

                String[] d = l.split(",");

                lista.add(new Persona(
                        d[0],
                        d[1],
                        Integer.parseInt(d[2])
                ));
            }

        }catch(Exception e){}

        return lista;
    }
}
