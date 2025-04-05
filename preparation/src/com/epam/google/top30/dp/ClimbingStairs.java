package com.epam.google.top30.dp;

public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public int noOfWays(int steps){
        int[] dp = new int[steps];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=steps; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[steps];

    }
}
