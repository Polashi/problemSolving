package com.epam.google.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src-1] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x,y)->x.distance-y.distance);
        minHeap.offer(new Pair(src, 0));
        while (!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            int node = p.node;
            int weight = p.distance;
            for(Pair pair : adj.get(node)){
                int adj_node = pair.node;
                int adj_weight = pair.distance;
                if(adj_weight + weight < dist[adj_node]){
                    dist[adj_node] = adj_weight+ weight;
                    minHeap.offer(new Pair(adj_node,adj_weight+ weight));
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }else{
                ans = Math.max(ans, dist[i]);
            }
        }
        return ans;
    }

    private class Pair {
        int node, distance;
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }

    }
}
