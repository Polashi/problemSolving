package com.epam.google.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
//Applicable to graphs that can contain circles and Topological sort is not applicable to them
public class DijkstraAlgo {
    public ArrayList<Integer> dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((x,y) -> x.weight - y.weight);
        int[] dist = new int[V];
        dist[src] = 0;
        minHeap.add(new Pair(src, 0));
        while(!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            int node = p.node;
            int weight = p.weight;
            for(int i=0; i<adj.get(node).size(); i++){
                int neighbor_node = adj.get(node).get(i).node;
                int neighbor_weight = adj.get(node).get(i).weight;
                if(weight + neighbor_weight < dist[neighbor_node]){
                    dist[neighbor_node] = weight + neighbor_weight;
                    minHeap.add(new Pair(neighbor_node, dist[neighbor_node]));
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : dist) {
            arrayList.add(num); // Autoboxing from int to Integer
        }
        return arrayList;
    }
}

