package com.epam.google.graph;

import java.util.Arrays;

public class BellmanFordAlgorithm {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i=0; i<V-1; i++){
            for(int[] e: edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
