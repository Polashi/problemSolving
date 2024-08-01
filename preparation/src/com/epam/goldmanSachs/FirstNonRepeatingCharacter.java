package com.epam.goldmanSachs;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "aabb";
        System.out.println(getIndex(str));
    }
    public static int getIndex(String s){
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(s.indexOf(ch) == i && i== s.lastIndexOf(ch)){
                return i;
            }
        }
        return -1;
    }
}
