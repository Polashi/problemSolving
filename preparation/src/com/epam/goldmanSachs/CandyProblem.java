package com.epam.goldmanSachs;

import java.util.Arrays;

public class CandyProblem {
    public static void main(String[] args) {

    }

    private static int candy(int[] ratings){
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // min 1 everyone should get
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i]++;
            }
        }

        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        int totalCandies = 0;
        for(int candy: candies){
            totalCandies += candy;
        }
        return totalCandies;
    }
}
