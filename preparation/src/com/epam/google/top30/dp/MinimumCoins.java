package com.epam.google.top30.dp;

public class MinimumCoins {

    // Function to count the ways to make change
    static long countWaysToMakeChange(int[] arr, int T) {
        int n = arr.length;
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTaken = dp[ind - 1][target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = Math.min(notTaken, taken);
            }
        }

        return dp[n - 1][T];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr,target));
    }
}



