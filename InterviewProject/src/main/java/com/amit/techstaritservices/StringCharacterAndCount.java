package com.amit.techstaritservices;

import java.util.HashMap;

public class StringCharacterAndCount {

    public static void main(String[] args) {
        String s = "amitkumarakoolamitamitkumarus";
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(h.containsKey(c)) {
                h.put(c, h.get(c)+1);
            } else {
                h.put(c , 1);
            }
        }
        System.out.println(h);
    }

}
