package com.example.demolistview.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PersonFileRepository {

    private final Path filePath = Paths.get("data", "personas.csv");

    private void ensureFile() throws IOException {
        if (Files.notExists(filePath)){
            Files.createFile(filePath);
        }
    }

    public List<String> readAllLines() throws IOException {
        ensureFile();
        return Files.readAllLines(filePath);
    }
}
