package com.epam.google.dynamicPrograming;

/*In the previous question, the frog was allowed to jump either one or two steps at a time. In this question, the frog
is allowed to jump up to ‘K’ steps at a time. If K=4, the frog can jump 1,2,3, or 4 steps at every index.*/

import java.util.Arrays;

public class FrogJumpDistanceK {
    public int findMinEnergy(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<n; i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    int jump = dp[i-j] + Math.abs(height[i] - height[i-1]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
    }


}
