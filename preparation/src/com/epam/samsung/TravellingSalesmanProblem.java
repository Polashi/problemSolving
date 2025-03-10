package com.epam.samsung;
import java.util.*;

public class TravellingSalesmanProblem {
    static final int INF = 1_000_000_000;
    static int[][] cost, dp;
    static boolean[] visited;
    static int N;

    public static int getMinCost(int currentCity, int visitedCount) {
        if (visitedCount == N) {
            return (cost[currentCity][0] > 0) ? cost[currentCity][0] : INF; // Return to start
        }

        if (dp[currentCity][visitedCount] != -1) {
            return dp[currentCity][visitedCount]; // Return cached result
        }

        int minCost = INF;
        visited[currentCity] = true;

        for (int nextCity = 0; nextCity < N; nextCity++) {
            if (!visited[nextCity] && cost[currentCity][nextCity] > 0) { // Valid move
                int newCost = cost[currentCity][nextCity] + getMinCost(nextCity, visitedCount + 1);
                minCost = Math.min(minCost, newCost);
            }
        }

        visited[currentCity] = false; // Backtrack
        return dp[currentCity][visitedCount] = minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            N = sc.nextInt();
            cost = new int[N][N];
            dp = new int[N][N + 1]; // DP table
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cost[i][j] = sc.nextInt();
                }
            }

            for (int[] row : dp) Arrays.fill(row, -1); // Initialize DP table

            System.out.println(getMinCost(0, 1)); // Start from city 0, visited 1 city
        }
        sc.close();
    }
}

