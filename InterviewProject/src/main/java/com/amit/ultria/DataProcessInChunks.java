package com.amit.ultria;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class DataProcessInChunks {
    public static void main(String[] args) throws FileNotFoundException {
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("/home/amit/Desktop/DesktopOneFolder/abc.txt"))) {
            byte[] bbuf = new byte[4096];
            int len;
            while ((len = in.read(bbuf)) != -1) {
                System.out.println(Arrays.asList(bbuf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
