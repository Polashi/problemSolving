package com.epam.google.graph;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        // adj.add(new ArrayList<>());
        // for (int neighbor : graph[i]) {
        // adj.get(i).add(neighbor);
        // }
        // }

        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkColor(i, n, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkColor(int index, int size, int[] color, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        color[index] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int node : adj.get(vertex)) {
                if (color[node] == -1) {
                    color[node] = 1 - color[vertex];
                    queue.add(node);
                } else if (color[node] == color[vertex]) {
                    return false;
                }
            }
        }
        return true;
    }


}
