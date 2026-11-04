package org.example.classroom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id, departamento;
        double salario;
        char[] apellido = new char[10];
        char letra;
        int posicion = 0;

        while (file.getFilePointer() < file.length()) {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellido.length; i++) {
                letra = file.readChar();
                apellido[i] = letra;
            }

            String apellidos = new String(apellido);
            departamento = file.readInt();
            salario = file.readDouble();

            if (id > 0) {
                System.out.printf(
                        "ID: %s, Apellido: %s, Departamento: %s, Salario: %.2f",
                        id,apellidos.trim(), departamento, salario
                );
                System.out.println();
            }
            posicion =posicion+36;

        }
        file.close();


    }

}
