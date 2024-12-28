package com.epam.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ZeroArrayTransformation {
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        int[][] queries = {{0,2}};
        System.out.println(isZeroArray(nums, queries));
    }
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] noOfUpdates = new int[nums.length+1];
        for(int[] query: queries){
            noOfUpdates[query[0]]++;
            noOfUpdates[query[1]+1]--;
        }
        for(int i=0; i< nums.length; i++){
            noOfUpdates[i] += (i-1 >= 0) ? noOfUpdates[i-1]: 0;
            if(noOfUpdates[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}
