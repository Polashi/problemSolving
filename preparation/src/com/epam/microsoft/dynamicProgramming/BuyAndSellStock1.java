package com.epam.microsoft.dynamicProgramming;

public class BuyAndSellStock1 {
    public static int getMaxProfit(int[] prices){
        int min_buy = prices[0];
        int max_profit = 0;
        for(int i=0; i< prices.length; i++){
            int profit = prices[i] - min_buy;
            max_profit = Math.max(profit, max_profit);
            min_buy = Math.min(min_buy, prices[i]);
        }
        return max_profit;
    }
}
