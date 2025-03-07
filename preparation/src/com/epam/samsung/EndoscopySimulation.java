package com.epam.samsung;

import java.util.LinkedList;
import java.util.Queue;

/*
    Possible Problem Statement
    Given a grid of size N×M, where:
    0 represents open paths.
    1 represents obstacles (walls, blockages).
    An entry point (start position of the endoscope) is provided.
    The endoscope can move up, down, left, or right.
    The goal is to simulate the movement of the endoscope and count the number of open cells it can explore.
*/
public class EndoscopySimulation {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static int simulateEndoscopy(int[][] grid, int startX, int startY){
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx <n && ny>=0 && ny<m && grid[nx][ny]==0 && !visited[nx][ny]){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;


    }
}
