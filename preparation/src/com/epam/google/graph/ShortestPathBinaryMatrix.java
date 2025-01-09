package com.epam.google.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }

        int[][] dist = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        grid[0][0] = 1;
        queue.offer(new Pair(0, 0));
        int[] dr = {0, 0, -1, -1, -1, 1, 1, 1};
        int[] dc = {-1, 1, -1, 0, 1, -1, 0, 1};
        while(!queue.isEmpty()){
            Pair t = queue.poll();
            int row = t.node;
            int col = t.weight;
            for(int i=0; i<8; i++){
                int new_r = row + dr[i];
                int new_c = col + dc[i];
                if(new_r >=0 && new_r <n && new_c >=0 && new_c <m && grid[new_r][new_c] == 0){
                    queue.offer(new Pair(new_r, new_c));
                    grid[new_r][new_c] = grid[row][col] +1;
                }
            }
        }
        if(grid[n-1][m-1] == 0){
            return -1;
        }
        return grid[n-1][m-1];
    }

}


