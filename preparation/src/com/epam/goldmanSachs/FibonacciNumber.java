package com.epam.goldmanSachs;

public class FibonacciNumber {
    public static void main(String[] args) {

    }
    public static int getNthFibo(int n){
        if(n<=1){
            return n;
        }
        int[] fb = new int[n+1];
        fb[0] = 0;
        fb[1] = 1;

        for(int i=2; i<=n;i++){
            fb[i] = fb[i-2]+fb[i-1];
        }
        return fb[n];
    }
}
