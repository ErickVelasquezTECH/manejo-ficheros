package org.example.exercise;

import java.io.File;

public class Exercise9 {
    public static void main(String[] args) {
        //mkdir
        File fichero=new File("documentos/carpeta1/hola.txt");
        fichero.getParentFile().mkdir(); //Crea la carpeta padre "carpeta1"
        fichero.getParentFile().mkdirs(); //Crea la carpetas "documentos" y "carpeta1"


        //Ambas petenecen a la clase IO
    }
}
