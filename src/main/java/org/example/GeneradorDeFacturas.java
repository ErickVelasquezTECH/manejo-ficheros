
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
        Double sumaImporte = 0.0;
        Double sumaIVA = 0.0;

        try {

            Files.writeString(
                    fichero,
                    "",
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

            do {
                System.out.print("Introduce el importe (0 para terminar): ");
                importe = scanner.nextDouble();

                if (importe != 0) {

                    System.out.print("Introduce el IVA (10 o 21): ");
                    iva = scanner.nextDouble();

                    if (iva == 10 || iva == 21) {

                        Double cantidadIVA = importe * (iva / 100);

                        Files.writeString(
                                fichero,
                                importe + " - " + iva + "%\n",
                                StandardCharsets.UTF_8,
                                StandardOpenOption.APPEND
                        );

                        sumaImporte += importe;
                        sumaIVA += cantidadIVA;

                    } else {
                        System.out.println("IVA no valido. Introduccion rechazada.");
                    }
                }

            } while (importe != 0);

            Files.writeString(
                    fichero,
                    "\nTOTAL IMPORTES: " + sumaImporte + "\nTOTAL IVA: " + sumaIVA,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND
            );

            System.out.println("Factura generada correctamente.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
