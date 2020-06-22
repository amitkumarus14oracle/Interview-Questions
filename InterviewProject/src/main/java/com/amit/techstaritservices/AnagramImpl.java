package com.amit.techstaritservices;

import java.util.Arrays;

public class AnagramImpl {
    public static void main(String[] args) {
        String s1 = "army";
        String s2 = "Mary";
        System.out.println(areAnagram(s1, s2));
    }

    private static boolean areAnagram(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        char[] tempArray = s1.toLowerCase().toCharArray();
        Arrays.sort(tempArray);
        s1 = new String(tempArray);
        tempArray = s2.toLowerCase().toCharArray();
        Arrays.sort(tempArray);
        s2 = new String(tempArray);
        if(s1.equals(s2)) {
            return true;
        }
        return false;
    }
}
