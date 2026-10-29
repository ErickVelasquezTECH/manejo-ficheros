package org.example.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise7 {
    public static void main(String[] args) {
        Exercise7 exercise7 = new Exercise7();

        Path fichero = Path.of("prueba/erick.txt");
        try {
            System.out.println(exercise7.crearFicheroNIO(fichero)
                    ? "Archivo creado con exito"
                    : "El archivo ya existia");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public boolean crearFicheroNIO(Path fichero) throws IOException {
        if (fichero.getParent() != null) {
            Files.createDirectories(fichero.getParent());
        }
        try {
            Files.createFile(fichero);
            return true;
        } catch (FileAlreadyExistsException e) {
            return false;
        }
    }

    public boolean crearFicheroIO(File file) throws IOException {
        if (file.getParent()!=null){
            file.getParentFile().mkdirs();
        }
        return file.createNewFile();
    }
}
