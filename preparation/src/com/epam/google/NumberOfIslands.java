package com.epam.google;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
    }

    public static int islands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; i++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j, int n, int m){
        if(i>=n || j>=m || i<0 || j<0){
            return;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i-1, j, n, m);
            dfs(grid, i+1, j, n, m);
            dfs(grid, i, j-1, n, m);
            dfs(grid, i, j+1, n, m);
        }
    }
}
