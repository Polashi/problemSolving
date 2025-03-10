package com.epam.google.top30.array;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compressString("aabbbbccdee"));
    }

    public static String compressString(String str){
        StringBuilder result = new StringBuilder();
        int count = 0;
        char ch = ' ';
        for(char curr: str.toCharArray()){
            if(ch == ' '){
                ch = curr;
                result.append(ch);
                count++;
            }else{
                if(ch == curr){
                    count++;
                }else{
                    if(count > 1){
                        result.append(count);
                    }
                    ch = curr;
                    result.append(ch);
                    count = 1;
                }
            }
        }
        if(count != 1){
            result.append(count);
        }
        return result.toString();
    }
}
