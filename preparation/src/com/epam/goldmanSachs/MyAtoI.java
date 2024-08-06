package com.epam.goldmanSachs;

public class MyAtoI {
    public static void main(String[] args) {

    }

    public static int atoi(String str){

        str = str.trim(); // step 1. remove extra space
        if(str.isEmpty()){
            return 0;
        }
        long ans = 0;
        boolean neg = false;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(i==0){
                if(ch == '-'){
                    neg = true;
                }
                continue;
            }
            if(ch >= '0' && ch<='9'){
                ans = ans*10 + ch - '0';
                if(neg){
                    long check = -ans;
                    if(check <Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }else{
                    if(ans > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
            }else{
                break;
            }
        }
        if(neg){
            ans = -ans;
        }
        return (int) ans;

    }
}
