package org.example.exercise;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 exercise2 = new Exercise2();
        System.out.println(exercise2.fileExist(Path.of("datos.bin")));
    }

    public boolean fileExist(Path file) {
        return Files.exists(file);
    }
}