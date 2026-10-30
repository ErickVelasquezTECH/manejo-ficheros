package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class GeneradorDeFacturas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Path fichero = Path.of("factura.txt");
        Double importe;
        Double iva;

        Double sumaImporte=0.0;
        try {
            do {
                importe = scanner.nextDouble();
                scanner.nextLine();
                if (importe!=0) {
                    iva=scanner.nextDouble();
                    scanner.nextLine();
                    if (iva!=0){
                        Files.writeString(fichero, importe.toString()+" - "+iva.toString(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                        Files.writeString(fichero, "\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                        sumaImporte=sumaImporte+importe;
                    }

                }else {
                    Files.writeString(fichero, sumaImporte.toString(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);

                }
            } while (importe!=0);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


}
