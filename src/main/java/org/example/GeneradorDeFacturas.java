
package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class GeneradorDeFacturas {
    private final Scanner scanner;

    public GeneradorDeFacturas(Scanner scanner) {
        this.scanner = scanner;
    }


    public static void main(String[] args) {
        var scanner=new Scanner(System.in);
        var generadorFacturaApp=new GeneradorDeFacturas(scanner);
        generadorFacturaApp.run();
    }

    public void run() {
        int opt;
        do {
            System.out.println("""
                    Generador de facturas :D
                    1) Crear factura
                    2) Salir
                    """);
            opt = readOption("Elige una opcion");

            switch (opt) {
                case 1 -> {
                    try {
                        int contador = leerContador();
                        contador++;

                        String fichero = "factura" + contador + ".txt";

                        crearFactura(fichero);

                        Files.writeString(
                                Path.of("contador.txt"),
                                String.valueOf(contador),
                                StandardCharsets.UTF_8
                        );
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> System.out.println("Hasta pronto...");
                default -> System.out.println("Opcion invalida");
            }

        } while (opt != 2);
    }

    private int readOption(String message) {
        while (true) {
            System.out.println(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número valido.");
            }
        }
    }

    private int leerContador() throws IOException {
        Path fichero = Path.of("contador.txt");

        if (!Files.exists(fichero) || Files.size(fichero) == 0) {
            return 0;
        }

        return Integer.parseInt(
                Files.readString(fichero, StandardCharsets.UTF_8).trim()
        );
    }

    private void crearFactura(String nombreFichero) throws IOException {

        Path fichero = Path.of(nombreFichero);

        Double importe;
        Double iva;

        Double sumaImporte = 0.0;
        Double sumaIVA = 0.0;

        Files.writeString(fichero, "", StandardCharsets.UTF_8);

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
        scanner.nextLine();

        Files.writeString(
                fichero,
                "\nTOTAL IMPORTES: " + sumaImporte +
                        "\nTOTAL IVA: " + sumaIVA,
                StandardCharsets.UTF_8,
                StandardOpenOption.APPEND
        );

        System.out.println("Factura generada correctamente.");


    }

}
