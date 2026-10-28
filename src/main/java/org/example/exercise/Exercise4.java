package org.example.exercise;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Exercise4 {
    public static void main(String[] args) {
        Exercise4 exercise4 = new Exercise4();

        Path directorio = Path.of(".");
        boolean result = exercise4.isdirectoryListNIO(directorio);
    }

    public boolean isdirectoryListNIO(Path directory) {
        if (Files.isDirectory(directory)) {
            try (Stream<Path> elementos = Files.list(directory.normalize())) {
                elementos.forEach(System.out::println);
                return true;
            } catch (Exception e) {
                System.out.printf("Error: %s", e.getMessage());
            }
        }
        return false;
    }

    public boolean isdirectoryListIO(File directory) {
        File[]files=directory.listFiles();
        if (files!=null){
            for (File file: files){
                System.out.println(file.getName());
            }
            return true;
        }
        return false;

    }


}