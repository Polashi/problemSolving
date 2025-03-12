package com.epam.google.graph;

public class Edge implements Comparable<Edge>{
    public int source, destination, weight;
    public Edge(int s, int d, int w){
        source = s;
        destination = d;
        weight = w;
    }
    @Override
    public int compareTo(Edge newEdge){
        return this.weight - newEdge.weight;
    }
}
