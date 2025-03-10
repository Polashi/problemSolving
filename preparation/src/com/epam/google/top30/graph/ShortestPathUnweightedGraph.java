package com.epam.google.top30.graph;

import java.util.*;

public class ShortestPathUnweightedGraph {
    public static void main(String[] args) {

    }

    public static int[] shortestPath(int[][] edges, int N, int M, int source) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distance[source] = 0;
        visited[source] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    distance[adj] = distance[node] + 1;
                    queue.offer(adj);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }

}
