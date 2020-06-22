package com.amit.ultria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MemoryCheck {
    public static void main(String[] args) throws IOException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        File f = new File("/home/amit/Desktop/DesktopOneFolder/abc.txt");
        if(f.exists()) {
            System.out.println("file present");
        } else {
            System.out.println("file not present");
        }
        FileInputStream fis = new FileInputStream(f);
        System.out.println(fis);
        System.out.println(f.length());
        int b = fis.read(); // it reads single byte from file, file is not yet loaded in the memory
        System.out.println(b);
        //byte[] data = new byte[(int) f.length()];
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        //fis.read(data);
        //fis.close();
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        //fis.close();
    }
}
