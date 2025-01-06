package com.epam.google.graph;

import java.util.*;

public class ShortestPathUndirectedGraphUnitWeight {
    public int[] shortestPath(int V, int E, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor : adj.get(node)){
                if(dist[node] + 1 < dist[neighbor]){
                    dist[neighbor]= 1+ dist[node];
                    queue.offer(neighbor);
                }
            }
        }
        for (int i=0; i<V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;

    }
}
