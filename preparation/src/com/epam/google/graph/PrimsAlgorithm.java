package com.epam.google.graph;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {

    }

    public static int minimumSpanningTree(int V, int E, List<List<int[]>> adj){
        //1. Min heap to store pairs
        //2. get one by one and do dfs
        // 3. take sum variable to return min sum
        PriorityQueue<Pair> min_heap = new PriorityQueue<>((x,y)-> x.weight-y.weight);
        int sum = 0;
        int[] vis = new int[V];
        min_heap.offer(new Pair(0,0));
        while(!min_heap.isEmpty()){
            Pair pair = min_heap.poll();
            int node = pair.node;
            int weight = pair.weight;
            if(vis[node] == 1){
                continue;
            }
            vis[node] = 1;
            sum += weight;
            for (int i=0; i<adj.get(node).size(); i++){
                int adj_node = adj.get(node).get(i)[0];
                int adj_weight = adj.get(node).get(i)[1];
                if(vis[adj_node] == 0){
                    min_heap.offer(new Pair(adj_node,adj_weight));
                }
            }
        }
        return sum;
    }
}
