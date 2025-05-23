package com.epam.microsoft.graph;

public class NumberOfIslands {
    public int numberOfConnectedIslands(int V, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int n, int m){
        if(i <0|| j<0 || i>= n || j>= m || grid[i][j] == '0'){
            return;
        }

        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i+1, j, n, m);
            dfs(grid, i-1, j, n, m);
            dfs(grid, i, j+1, n, m);
            dfs(grid, i, j-1, n, m);
        }
        return;
    }
}
