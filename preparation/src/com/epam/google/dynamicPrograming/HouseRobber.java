package com.epam.google.dynamicPrograming;

/*Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two
elements of the subsequence are adjacent elements in the array.*/

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }
            int notPick = nums[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
}
