package com.epam.microsoft.array;

public class ReverseWords {
    public static void main(String[] args) {

    }
    public static String reverseWords(String str){
        String[] words = str.trim().split("\\s+");
        String output = "";
        for(int i= words.length-1; i>0; i--){
            output += words[i] + " ";
        }
        output += words[0];
        return output;
    }
}
