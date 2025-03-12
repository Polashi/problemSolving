package com.epam.google.top30.graph;

import com.epam.goldmanSachs.PowerOf10;
import com.epam.google.graph.DisjointSet;
import com.epam.google.graph.Edge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinCost {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

    }
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points.length; j++){
                if(i != j){
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int weight = Math.abs(x1-x2) + Math.abs(y1-y2);
                    Edge edge = new Edge(i, j, weight);
                    edges.add(edge);
                }
            }
        }
        DisjointSet disjointSet = new DisjointSet(points.length);
        Collections.sort(edges); // sort the edge list based on weight in ascending order
        int minCost = 0;
        for(Edge edge: edges){
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;

            if(disjointSet.findUltimateParent(u) ==  disjointSet.findUltimateParent(v)){
                minCost += w;
                disjointSet.unionByRank(u,v);
            }
        }
        return minCost;
    }
}
