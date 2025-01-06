package com.epam.google.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {

    }
    public static int getDistinctIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> ans = new ArrayList<>();
                    dfs(i, j, grid, vis, i, j, ans, delrow, delcol, n, m);
                    set.add(ans);

                }
            }
        }
        return set.size();
    }

    private static void dfs(int row, int col, int[][] grid, int[][] vis, int row0, int col0, ArrayList<String> ans, int[] delrow, int[] delcol, int n, int m){
        vis[row][col]= 1;
        ans.add(toString(row-row0, col-col0));

        for(int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, vis, row0, col0, ans, delrow, delcol, n, m);
            }
        }
    }

    private static String toString(int rd, int cd){
        return Integer.toString(rd) + " " + Integer.toString(cd);
    }
}
