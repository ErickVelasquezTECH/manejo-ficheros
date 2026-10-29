package org.example.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise6 {
    public static void main(String[] args) {
        Exercise6 exercise6 = new Exercise6();
        File ficheroio = new File("erick.txt");
        System.out.println(exercise6.eliminarIO(ficheroio)
                ? "Eliminado por io"
                : "No existe o no se pudo eliminar"
        );

        Path ficheronio = ficheroio.toPath();
        System.out.println(exercise6.eliminarNIO(ficheronio)
                ? "Eliminado con nio"
                : "No existe o no se pudo eliminar"
        );

    }

    public boolean eliminarIO(File file) {
        return file.delete();
    }

    public boolean eliminarNIO(Path path) {
        try {
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }


}
