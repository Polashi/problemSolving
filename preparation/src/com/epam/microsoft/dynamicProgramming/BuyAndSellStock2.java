package com.epam.microsoft.dynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStock2 {
    public static int getMaxProfit(int[] prices, int n){
        if(n==0){
            return 0;
        }
        int[][] dp = new int[n+1][2];

        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }
        dp[n][0] = dp[n][1] = 0;
        int maxProfit = 0;
        for(int day=n; day >=0; day--){
            for(int buy=0; buy<2; buy++){
                if(buy == 0){ // buy true
                    maxProfit = Math.max(-prices[day] + dp[day+1][1],  dp[day+1][0] );
                }else{
                    maxProfit = Math.max(prices[day] + dp[day+1][0], dp[day+1][1]);
                }
                dp[day][buy] = maxProfit;
            }
        }
        return dp[0][0];
    }

}
