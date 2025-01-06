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
                boolean isPresent = dfs(i, -1, adj, visited);
                if(isPresent){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int u, int parent, int[][] adj, boolean[] vis){
        vis[u] = false;
        for(int v: adj[u]){
            if(v == parent) {
                continue;
            }
            if(vis[v]){
                return true;
            }
            if(dfs(v, u, adj, vis)){
                return true;
            }
        }
        return false;

    }
}
