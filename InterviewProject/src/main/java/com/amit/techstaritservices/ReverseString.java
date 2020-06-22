package com.amit.techstaritservices;

public class ReverseString {
    public static void main(String[] args) {
        String x = "amit";
        System.out.println("original string : "+x);
        x = reverseString(x);
        System.out.println("reversed string : "+x);
    }

    private static String reverseString(String x) {
        if(x== null) {
            return x;
        }
        int i = 0;
        int size = x.length();
        String s = "";
        while(i < size ) {
            s += x.charAt(size-i-1);
            i++;
        }
        return s;
    }
}
