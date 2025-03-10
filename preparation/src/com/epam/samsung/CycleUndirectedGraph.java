package com.epam.samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUndirectedGraph {
    public static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] vis = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        Arrays.fill(vis, false);

        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(cycleExists(i, parent, vis, adjList)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean cycleExists(int node, int[] parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjList){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node, -1});
        visited[node] = true;

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int curr = arr[0];
            int par = arr[1];
            for(Integer next: adjList.get(curr)){
                if(!visited[next]){
                    queue.add(new int[]{next, curr});
                    visited[next] = true;
                }else if(par != next){
                    return true;
                }
            }
        }
        return false;
    }
}
