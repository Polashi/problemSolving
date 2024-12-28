package com.epam.google;

public class ReplaceOWithX {
    public static void main(String[] args) {
    }

    public static char[][] modifyGrid(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,-1,0,1};

        for(int j=0; j<m; j++){
            if(vis[0][j] == 0 && grid[0][j] == 'O'){
                dfs(0, j, grid, vis, delrow, delcol, n, m);
            }
            if(vis[n-1][j] == 0 && grid[n-1][j] == 'O'){
                dfs(n-1, j, grid, vis, delrow, delcol, n, m);
            }
        }
        for(int i=0; i<n; i++){
            if(vis[i][0] == 0 && grid[i][0] == 'O'){
                dfs(i, 0, grid, vis, delrow, delcol, n, m);
            }
            if(vis[i][m-1] == 0 && grid[i][m-1] == 'O'){
                dfs(i, m-1, grid, vis, delrow, delcol, n, m);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
            }
        }
        return grid;
    }

    private static void  dfs(int row, int col, char[][] grid, int[][] vis, int[] delrow, int[] delcol, int n, int m){
        vis[row][col] = 1;
        for(int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >=0 && nrow <n && ncol >=0 && ncol <m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'O'){
                dfs(nrow, ncol, grid, vis, delrow, delcol, n, m);
            }
        }
    }
}
