package org.example.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise5 {

    public static void main(String[] args) {
        Exercise5 exercise5=new Exercise5();
        try {
            exercise5.informationFileNIO(args[0]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Falta indicar alguno o los dos datos requeridos (fichero y su ruta) en la linea de comandos");
        }
    }
    public void informationFileNIO(String file){
        File fichero=new File(file);
        if (fichero.exists()){
            System.out.println(fichero.getName());
            System.out.println(fichero.getAbsoluteFile());
            System.out.println(fichero.canRead());
            System.out.println(fichero.length());
            System.out.println(fichero.isDirectory()? "Es directorio": "Es fichero");
        }else {
            System.out.println("El directorio no existe");
        }
    }

    public void informationFileIO(String file) throws IOException {
        Path fichero=Path.of(file);
        try {
            if (Files.exists(fichero)){
                System.out.println(fichero.getFileName());
                System.out.println(fichero.toAbsolutePath());
                System.out.println(Files.isReadable(fichero));
                System.out.println(Files.size(fichero));
                System.out.println(Files.isDirectory(fichero)? "Es directorio": "Es fichero");
            }else {
                System.out.println("El directorio no existe");
            }
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }

    }

}
