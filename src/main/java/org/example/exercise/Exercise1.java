package org.example.exercise;

import java.io.File;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        System.out.println(exercise1.fileExist(new File("datos.bin")));
    }

    public boolean fileExist(File file){
        if (file.exists()){
            return true;
        }
        return false;
    }


}