package org.example.exercise;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Exercise12 {
    public static void main(String[] args) throws IOException {


        Path path= Path.of("erick", "nota.txt");
        try {
            Files.createFile(path);
        }catch (NoSuchFileException e){
            System.out.println("ERROR: Archio o ruta no encontrada");
        }



        try {
            Files.createFile(Path.of("erick.txt"));

        }catch (FileAlreadyExistsException e){
            System.out.println("Error: Archivo ya existe");
        }






    }


}
