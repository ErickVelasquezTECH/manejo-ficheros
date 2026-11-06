package org.example.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise11 {
    public static void main(String[] args) throws IOException {
        Path path= Path.of("erick", "nota.txt");

        Files.createFile(path);

        /*Si creamos un archivo con un directorio que no existe lanza
        NoSuchFileException*/

    }
}
