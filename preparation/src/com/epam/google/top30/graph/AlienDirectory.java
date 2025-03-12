package com.epam.google.top30.graph;

import java.util.HashMap;
import java.util.Map;

public class AlienDirectory {
    public static void main(String[] args) {

    }
    public boolean isAlienSorted(String[] words, String order){
        Map<Character, Integer> orderMap = new HashMap<>();
        for(int i=0; i< order.length(); i++){
            orderMap.put(order.charAt(i), i);
        }

        for(int i=0; i< words.length-1; i++){
            if(compare(words[i], words[i+1], orderMap) == 1){
                return false;
            }
        }
        return true;
    }

    private int compare(String s1, String s2, Map<Character, Integer> map){
        int minLength = Math.min(s1.length(), s2.length());
        for(int i=0; i<minLength; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(map.get(c1) < map.get(c2)){
                return -1;
            }else if(map.get(c1) > map.get(c2)){
                return 1;
            }
        }
        if(s1.length() < s2.length()){
            return -1;
        }else if(s1.length() > s2.length()){
            return 1;
        }
        return 0;
    }
}
