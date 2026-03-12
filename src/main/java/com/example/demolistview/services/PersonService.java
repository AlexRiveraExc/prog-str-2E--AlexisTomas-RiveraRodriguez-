package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repository= new PersonFileRepository();

    public List<String> loadDataForListView() throws IOException {
        List<String> lines=repository.readAllLines();
        List<String> result=new ArrayList<>();

        for (String line:lines){
            if (line==null || line.isBlank())continue;
            String [] parts=line.split(",");
            String name=parts[0];
            String email=parts[1];
            result.add("Nombre: "+name+" - Email: "+email);
        }
        return result;
    }
}
