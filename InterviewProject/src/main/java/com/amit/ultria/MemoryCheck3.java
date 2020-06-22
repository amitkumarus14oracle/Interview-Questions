package com.amit.ultria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemoryCheck3 {
    public static void main(String[] args) throws IOException {
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println("-------------------------------");
        Files.readAllBytes(Paths.get("/home/amit/Desktop/DesktopOneFolder/abc.txt"));
        //Stream<String> stream = Files.lines(Paths.get("/home/amit/Desktop/DesktopOneFolder/abc.txt"));
        //stream = stream.filter(line -> line.contains("abc"));
        //System.out.println(stream.collect(Collectors.toList()));
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println("-------------------------------");
        /*List<String> alist = Files.lines(Paths.get("/home/amit/Desktop/DesktopOneFolder/abc.txt"))
                .filter(line -> !line.contains("abc"))
                .collect(Collectors.toList());
        System.out.println(alist);*/
    }
}
