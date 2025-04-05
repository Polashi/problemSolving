package com.epam.google.top30.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    public static int longestIncreasingSubsequence(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // considering all elements individually are the longest subsequence
        int maxLIS = 1;

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(dp[i], maxLIS);
        }
        return maxLIS;


    }
}
