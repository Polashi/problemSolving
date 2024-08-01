package com.epam.goldmanSachs;

import java.util.Arrays;

public class MeanMedianMode {
    public static double findMean(int[] arr){
        long sum = 0;
        for(int num: arr){
            sum+= num;
        }
        if(sum > Integer.MAX_VALUE){
            throw new ArithmeticException("Beyond Integer range");
        }
        return (double) sum/arr.length;
    }

    public static int[] findMode(int[] arr){
        int[] freq = new int[101];
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }
        int max_freq = 0;
        for(int f: freq){
            max_freq = Math.max(max_freq,f);
        }
        int[] mode = new int[0];
        for(int i=0; i<freq.length; i++){
            if(freq[i] == max_freq){
                mode = Arrays.copyOf(mode, mode.length+1);
                mode[mode.length-1] = i;
            }
        }
        return mode;
    }

    public static double median(int[] array){
        return 0;
    }
}
