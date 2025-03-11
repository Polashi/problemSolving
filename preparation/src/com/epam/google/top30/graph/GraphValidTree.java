package com.epam.google.top30.graph;

import java.util.*;

public class GraphValidTree {
    public static boolean isValidTree(int n, int[][] edges){
        if(edges.length != n-1){
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int adj: adjList.get(node)){
                if(visited.contains(adj)){
                    continue;
                }
                visited.add(adj);
                queue.offer(adj);
            }
        }
        return visited.size() == n; //check if all nodes were visited
    }
}
