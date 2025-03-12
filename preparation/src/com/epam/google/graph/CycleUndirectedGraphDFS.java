package com.epam.google.graph;

import java.util.Arrays;



public class CycleUndirectedGraphDFS {
    public static void main(String[] args) {

    }

    public static boolean icCyclePresent(int v, int[][] adj){
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        for(int i=0; i<v; i++){
            if(!visited[i]){
                if( dfs(i, -1, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, int[][] adjList, boolean[] visited){
        visited[node] = false;
        for(int next: adjList[node]){
            if(next == parent) {
                continue;
            }
            if(visited[next] || dfs(next, node, adjList, visited)){
                return true;
            }
        }
        return false;

    }
}
