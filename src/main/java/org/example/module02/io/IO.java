package org.example.module02.io;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class IO {
    public static void main(String[] args) {
        File fichero = new File("file/archivo.txt");

        fichero.getParentFile().mkdirs();
        try {

            //Forma de escribir y crear a la vez con BUFFER
            try (BufferedWriter escritor = new BufferedWriter(
                    new FileWriter(fichero)
            )) {
                escritor.write("Hola, estoy aprendiendo java");
                escritor.newLine();
                escritor.write("Jeje");

            }

            //Forma de escribir y crear a la vez mas sencillo
            try (FileWriter escritor = new FileWriter(fichero)) {
                escritor.write("Hola");
                escritor.write(" mundo");
                escritor.write("!");
            }

            try (BufferedReader lector = new BufferedReader(
                    new FileReader(fichero)
            )) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error en: " + e.getMessage());
        }


    }
}
