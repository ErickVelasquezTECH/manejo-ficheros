package org.example.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Exercise8 {
    public static void main(String[] args) {
        Exercise8 exercise8 = new Exercise8();
        File path = new File("carpeta1");
        if (exercise8.borradoRecursivoIO(path)) {
            System.out.println("Borrado exitoso");
        } else {
            System.out.println("Fallo al borrar");
        }


    }


    public boolean borradoRecursivoIO(File fichero) {
        File[] hijos = fichero.listFiles();

        if (hijos != null) {
            for (File hijo : hijos) {
                if (!borradoRecursivoIO(hijo)) {
                    return false;
                }
            }
        }

        if (!fichero.delete()) {
            return false;
        }

        System.out.println("Borrado: " + fichero);
        return true;
    }


    public boolean borradoRecursivoNIO(Path fichero) {
        try {
            if (Files.isDirectory(fichero)) {
                try (Stream<Path> hijos = Files.list(fichero)) {
                    for (Path hijo : hijos.toList()) {
                        if (!borradoRecursivoNIO(hijo)) {
                            return false;
                        }
                    }
                }
            }
            if (!Files.deleteIfExists(fichero)) {
                return false;
            }
            System.out.println("Borrado: " + fichero);
            return true;

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

}
