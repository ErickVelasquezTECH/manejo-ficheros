package org.example.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        Exercise3 exercise3 = new Exercise3();
        Path file = Path.of("hola.txt");
        Path route = Path.of("/home/diurno");

        boolean result = exercise3.fileExistInRoute(file, route);
        System.out.println(result);

    }

    public boolean fileExistInRoute(Path file, Path route) {
        Path realRoute = Path.of(route + "/" + file);
        return Files.exists(realRoute);
    }
}
