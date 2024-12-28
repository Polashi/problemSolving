package com.epam.google;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] findDistance(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] ==  1){
                    distance[i][j] = 0;
                }else {
                    distance[i][j] = -1; // unvisited
                }
            }
        }
        int[] delr = {-1,0,+1,0};
        int[] delc = {0,-1,0,+1};

        while(!queue.isEmpty()){
            int[] arr = queue.peek();
            int row = arr[0];
            int col = arr[1];
            int steps = arr[2];

            for(int i=0; i<4; i++){
                int new_row = row + delr[i];
                int new_col = col + delc[i];
                if(new_row >=0 && new_row<n && new_col >=0 && new_col<m && distance[new_row][new_row] == -1){
                    distance[new_row][new_col] = steps+1;
                    queue.add(new int[]{new_row, new_col, steps+1});
                }
            }
        }
        return distance;
    }

}
