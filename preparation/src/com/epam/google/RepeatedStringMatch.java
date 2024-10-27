package com.epam.google;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        System.out.println(minRepeat("abcd", "cdabcdab"));
    }

    public static int minRepeat(String small, String large){
        StringBuilder repeatedSmall = new StringBuilder(small);
        int count=1;
        while(repeatedSmall.length() < large.length()){
            repeatedSmall.append(small);
            count++;
        }
        if(repeatedSmall.toString().contains(large)){
            return count;
        }

        repeatedSmall.append(small);
        count++;

        if(repeatedSmall.toString().contains(large)){
            return count;
        }
        return -1;
    }
}
