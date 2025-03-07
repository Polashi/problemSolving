package com.epam.samsung;

import java.util.Arrays;
import java.util.List;

public class WormholeDetection {
    static class Edge{
        int src, dest, weight;
        Edge(int s, int d, int w){
            src = s;
            dest = d;
            weight = w;
        }
    }

    public static boolean detectWormhole(int n, List<Edge> edges){
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(Edge edge: edges){
            if(distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]){
                distance[edge.dest]  = distance[edge.src] + edge.weight;
            }
        }
        for(Edge edge: edges){
            if(distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]){
                return true; // Negative cycle detected
            }
        }
        return false;
    }
}
