package com.amit.ultria;

import java.io.*;

public class MemoryCheck1 {
    public static void main(String[] args) throws IOException {
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println("-------------------------------");
        File file = new File("/home/amit/Desktop/DesktopOneFolder/abc.txt");
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println("-------------------------------");
        BufferedReader br = new BufferedReader(new FileReader(file));
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println("-------------------------------");
        int i =0;
        while(i < 100) {
            String s = br.readLine();
            System.out.println(s);
            i++;
        }
        System.out.println("-------------------------------");
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
