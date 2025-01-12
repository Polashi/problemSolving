package com.epam.google.graph;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<DestPrice>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i=0; i<m; i++){
            adj.get(flights[i][0]).add(new DestPrice(flights[i][1], flights[i][2]));
        }
        Queue<StopDestPrice> queue = new LinkedList<>();
        queue.offer(new StopDestPrice(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;
        while(!queue.isEmpty()){
            StopDestPrice point = queue.poll();
            int stops = point.stop;
            int dest = point.dest;
            int price = point.price;
            if(stops > k){
                continue;
            }
            for(DestPrice dp: adj.get(dest)){
                int adjNode = dp.destination;
                int edgeWeight = dp.price;
                if(edgeWeight + price < dist[adjNode] && stops <= k){
                    dist[adjNode] = edgeWeight+price;
                    queue.offer(new StopDestPrice(stops+1, adjNode, edgeWeight+price));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
    class StopDestPrice{
        int stop, dest, price;
        StopDestPrice(int stop, int dest, int price){
            this.stop = stop;
            this.dest = dest;
            this.price = price;
        }
    }

    class DestPrice{
        int destination;
        int price;
        DestPrice(int d, int p){
            destination = d;
            price = p;
        }
    }
}

