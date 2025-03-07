package com.epam.samsung;

import java.util.ArrayList;
import java.util.Arrays;


public class BurstBalloons {
    public static int getMaxCoins(int[] nums){
        ArrayList<Integer> coins = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        coins.add(1);
        coins.add(0,1);
        int n = nums.length;

        int[][] dp = new int[n+2][n+2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return getMaxCoinsHelper(1, n, coins, dp);
    }

    private static int getMaxCoinsHelper(int i, int j, ArrayList<Integer> coins, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxCoins = Integer.MIN_VALUE;
        for(int index=i; index<=j; index++){
            int cost = coins.get(i-1)*coins.get(index)*coins.get(j+1) +
                    getMaxCoinsHelper(i, index-1, coins, dp) +
                    getMaxCoinsHelper(index+1, j, coins, dp);
            if(cost > maxCoins){
                maxCoins = Math.max(cost, maxCoins);
            }
        }
        return dp[i][j] = maxCoins;
    }
}
