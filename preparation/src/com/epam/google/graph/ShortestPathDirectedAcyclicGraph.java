package com.epam.google.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDirectedAcyclicGraph {
    /*
    * 1. Topo sort with DFS
    * 2. go through the stack elements one by one
    * 3. Compare and fill the distance array one by visiting adj list*/


    public int[] shortestPath(int V, int E, int[][] edges) {
        //1. Create the adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0; i<V;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        // 2. Topological sort using DFS
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                topologicalSort(i, adj, vis, stack);
            }
        }
        //3. Create the distance array from the stack
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while(!stack.isEmpty()){    // 5, 3, 0, 4, 2, 1||
            int node = stack.pop();
            for(int i=0; i<adj.get(node).size(); i++){
                int v = adj.get(node).get(i).node;
                int w = adj.get(node).get(i).weight;
                if(dist[node] + w < dist[v]){
                    dist[v] = w + dist[node];
                }
            }
            for(int i=0; i<V; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    dist[i] = -1;
                }
            }

        }
        return dist;
    }

    public void topologicalSort(int i, List<List<Pair>> adj, int[] vis, Stack<Integer> stack) {
        vis[i] = 1;
        for(Pair neighbour: adj.get(i)){
            int v = neighbour.node;
            if(vis[v] == 0){
                topologicalSort(v, adj, vis, stack);
            }
        }
        stack.push(i);
    }
}
