package org.example.classroom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        String[] apellidos = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASTILLA", "REY"};

        int[] departamentos = {10, 20, 10, 10, 30, 30, 20};
        double[]salarios={1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};

        StringBuffer buffer=null;

        for (int i = 0; i < apellidos.length ; i++) {
            file.writeInt(i+1);
            buffer =new StringBuffer(apellidos[i]);
            buffer.setLength(10);
            file.writeChars(buffer.toString());

            file.writeInt(departamentos[i]);
            file.writeDouble(salarios[i]);
        }

        file.close();

    }
}
