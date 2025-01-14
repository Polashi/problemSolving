package com.epam.google.dynamicPrograming;

import java.util.Arrays;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses
 * were broken into on the same night. Given an integer array nums representing the amount of money of each house, return
 * the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robUtil(nums, 0, n-2), robUtil(nums, 1, n-1));
    }

    private int robUtil(int[] nums, int start, int end){
       int prev1 = 0; //dp[i-1]
       int prev2 = 0; //dp[i-2]
       for(int i=start; i<=end; i++){
           int curr = Math.max(prev1, prev2+nums[i]);
           prev1 = prev2;
           prev2 = curr;
        }
       return prev1;
    }
}
