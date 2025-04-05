package com.epam.leetcode.hiringSprint;

public class MergeString {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq"));
    }
    public static String mergeAlternately(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0;
        while(i<minLength){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
            i++;
        }
        if(word1.length() > minLength){
            for(int k=minLength; k<word1.length(); k++){
                str.append(word1.charAt(k));
            }
        }
        if(word2.length() > minLength){
            for(int k=minLength; k<word2.length(); k++){
                str.append(word2.charAt(k));
            }
        }
        return str.toString();
    }
}
