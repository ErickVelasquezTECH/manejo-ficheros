package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MaquinaDeEscribir {

    public static void main(String[] args) {
        MaquinaDeEscribir maquinaDeEscribir = new MaquinaDeEscribir();
        String[] cadena = {"Erick", "Luis", "Patricia"};
        maquinaDeEscribir.leerContenido("prueba.txt");
    }

    public void depositarContenido(String[] cadena, String nombreFichero) {
        Path fichero = Path.of(nombreFichero);
        try {
            if (!Files.exists(fichero)) {
                Files.createFile(fichero);
            }

            for (String palabra : cadena) {
                Files.writeString(
                        fichero,
                        palabra + "*",
                        StandardCharsets.UTF_8,
                        StandardOpenOption.APPEND
                );
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void leerContenido(String nombreFichero) {
        Path fichero = Path.of(nombreFichero);
        try {
            if (Files.exists(fichero)) {
                String linea = Files.readString(
                                fichero,
                                StandardCharsets.UTF_8)
                        .replace("*", "%n");

                System.out.printf("%s", linea);
            } else {
                System.out.print("El fichero no existe");
            }
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}


