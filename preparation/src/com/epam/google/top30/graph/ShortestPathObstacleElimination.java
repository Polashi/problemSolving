package com.epam.google.top30.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathObstacleElimination {
    static class State{
        int x,y,obstacleLeft, steps;
        State(int x, int y, int obstacleLeft, int steps){
            this.x = x;
            this.y = y;
            this.obstacleLeft = obstacleLeft;
            this.steps = steps;
        }
    }
    public static int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        if(n==1 && m==1) return 0;
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0,0,k,0));
        Set<String> visited = new HashSet<>();
        visited.add(0 + "," + 0 + ","+ k);

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            State currState = queue.poll();
            for(int[] dir: directions){
                int newX = currState.x + dir[0];
                int newY = currState.y + dir[1];
                if(newX == n-1 && newY == m-1) return currState.steps+1;

                if(newX >= 0 && newX<n && newY>=0 && newY<m){
                    int newObstacleLeft = currState.obstacleLeft - grid[newX][newY];
                    String newState = newX + ","+newY+","+ newObstacleLeft;
                    if( newObstacleLeft >=0 && !visited.contains(newState)){
                        queue.offer(new State(newX,newY,newObstacleLeft, currState.steps+1));
                        visited.add(newState);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }

}
