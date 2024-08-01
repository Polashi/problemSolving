package com.epam.goldmanSachs;

public class StringCompression {
    public static void main(String[] args) {
        char[] arr = {'a','a','a','b','b','c'};
        System.out.println(compress(arr));
    }

    private static String compress(char[] str){
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        for(int i=0; i<str.length; i++){
            if(prev == ' '){
                prev = str[i];
                sb.append(prev);
            }else{
                if(prev == str[i]){
                    count++;
                }else{
                    if(count != 1){
                        sb.append(count);
                    }
                    prev = str[i];
                    count = 1;
                    sb.append(prev);
                }
            }
        }
        if(count != 1){
            sb.append(count);
        }
        return sb.toString();
    }
}
