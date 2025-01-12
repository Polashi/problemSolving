package com.epam.google.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NoOfWaysToArriveDestination {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i< roads.length; i++){ // because undirected graph
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x,y)->(Long.compare(x.distance,y.distance)));
        minHeap.offer(new Pair(0,0));
        long mod = (int) (1e9+7);
        while (!minHeap.isEmpty()){
            Pair pair = minHeap.poll();
            long node = pair.node;
            long distance = pair.distance;
            for(int i=0; i<adj.get((int) node).size();i++){
                long adj_node = adj.get((int) node).get(i).node;
                long adj_dist = adj.get((int) node).get(i).distance;
                if(adj_dist + distance < dist[(int) adj_node]){
                    dist[(int) adj_node] = adj_dist + distance;
                    minHeap.offer(new Pair(adj_node, adj_dist+distance));
                    ways[(int) adj_node] = ways[(int) node];
                }else if(adj_dist + distance == dist[(int) adj_node]){
                    ways[(int) adj_node] = (ways[(int) adj_node] + ways[(int) node])%mod;
                }
            }
        }
        return (int) (ways[n-1]%mod);

    }
    class Pair{
        long node, distance;
        Pair(long n, long d){
            node = n;
            distance = d;
        }
    }
}
