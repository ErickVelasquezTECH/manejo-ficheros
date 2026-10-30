package org.example.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise10 {
    public static void main(String[] args) {
        //Creacion directorio NIO
        Path path=Path.of("documentos");
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }


        //Creacion directorio IO
        File file=new File("erick");
        if (file.mkdirs()) {
            System.out.println("Directorio IO creado");
        } else if (file.isDirectory()) {
            System.out.println("El directorio IO ya existe");
        } else {
            System.out.println("No se pudo crear el directorio IO");
        }
    }


}
