package com.epam.microsoft.array;

public class EvaluateBooleanExpression {
    public static void main(String[] args) {

    }

    public static int evaluate(StringBuffer string){
        int n = string.length();
        for(int i=0; i<n; i += 2){
            if(i+1 < n && i+2<n){
                if(string.charAt(i+1) == 'A'){
                    if(string.charAt(i+2) == '0' || string.charAt(i) == '0'){
                        string.setCharAt(i+2,'0');
                    }else {
                        string.setCharAt(i+2, '1');
                    }
                }else if(i+1 < n && string.charAt(i+1) == 'B'){
                    if(string.charAt(i+2) == '0' && string.charAt(i) == '0'){
                        string.setCharAt(i+2,'0');
                    }else {
                        string.setCharAt(i+2, '1');
                    }
                }else{
                    if(string.charAt(i+2) ==  string.charAt(i)){
                        string.setCharAt(i+2,'0');
                    }else {
                        string.setCharAt(i+2, '1');
                    }
                }
            }
        }
        return string.charAt(n-1) - '0';
    }
}
