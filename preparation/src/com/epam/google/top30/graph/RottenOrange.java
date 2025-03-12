package com.epam.google.top30.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    public static void main(String[] args) {

    }

    public static int getMinTime(int[][] grid){
        int rows = grid.length;
        int col = grid[0].length;
        int count_fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }

        int time = 0, rotten = 0;
        int[] dx ={-1,1,0,0}, dy = {0,0,-1,1};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int size = queue.size();
            rotten += size;

            for(int i=0; i<4; i++){
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];
                if(x<0 || x>rows || y<0 || y>col || grid[x][y] == 0 || grid[x][y] == 2) continue;
                grid[x][y] = 2;
                queue.offer(new int[]{x,y});
            }
            if(queue.size() != 0){
                time++;
            }
        }
        return time;
    }
}
