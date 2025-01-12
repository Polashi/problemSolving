package com.epam.google.dynamicPrograming;

/*Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. At a time the
frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps from a stair i to stair
j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. We need to
return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.*/

import java.util.Arrays;

public class FrogJump {
    public int minEnergy(int[] height){
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<height.length; i++){
            int jumpOne = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int jumpTwo = Integer.MAX_VALUE;
            if(i>1){
                jumpTwo = dp[i-2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n-1];
    }
}
