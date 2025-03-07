package com.epam.samsung;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {

    }

    public static boolean isBipartite(int[][] graph){
        int n = graph.length;
        int m = graph[0].length;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
            for(int j=0; j<m; j++){
                adjList.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!checkColor(i, n, adjList, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkColor(int index, int size, List<List<Integer>> adjList, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        color[index] = 1;
        queue.add(index);

        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int current: adjList.get(node)){
                if(color[current] == -1){
                    color[current] = 1 - color[node];
                    queue.add(current);
                }else{
                    if(color[current] == color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
