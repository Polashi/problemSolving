package com.epam.google.graph;

import java.util.PriorityQueue;
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple1> queue = new PriorityQueue<>((x,y)->x.distance-y.distance);
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        queue.offer(new Tuple1(0,0,0));
        int[] del_row = {-1,0,1,0};
        int[] del_col = {0,-1,0,1};
        while (!queue.isEmpty()){
            Tuple1 tuple = queue.poll();
            int row = tuple.row;
            int col = tuple.col;
            int distance = tuple.distance;
            if(row == n-1 && col == m-1){
                return distance;
            }
            for(int i=0; i<4; i++){
                int new_row = row + del_row[i];
                int new_col = col + del_col[i];
                if(new_row >=0 && new_row<n && new_col>=0 && new_col <m){
                    int new_dist = Math.max(distance, Math.abs(heights[row][col]-heights[new_row][new_col]));
                    if(new_dist < dist[new_row][new_col]){
                        dist[new_row][new_col] = new_dist;
                        queue.offer(new Tuple1(new_row,new_col, new_dist));
                    }
                }
            }
        }
        return 0;
    }
}
class Tuple1{
    int row, col, distance;
    Tuple1(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
