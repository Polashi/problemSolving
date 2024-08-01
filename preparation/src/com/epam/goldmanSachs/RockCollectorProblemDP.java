package com.epam.goldmanSachs;

public class RockCollectorProblemDP {
    public static void main(String[] args) {

    }
    public static int[][] findMaxPath(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for(int i=0; i<rows;i++){
            dp[i][0] = grid[i][0];
        }
        for(int j=0; j<rows;j++){
            dp[0][j] = grid[0][j];
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        int i = rows -1;
        int j = cols -1;
        int[][] path = new int[rows][cols];
        path[i][j] = 1;
        while(i>0 || j>0){
            if(i>0 && dp[i-1][j] == dp[i][j] -grid[i][j]){
                i--;
            }else{
                j--;
            }
            path[i][j] = 1;
        }
        return path;
    }
}
