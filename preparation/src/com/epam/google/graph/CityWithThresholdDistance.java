package com.epam.google.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CityWithThresholdDistance {
    public static void main(String[] args) {
        int[][] input = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(findTheCity(5, input, 2));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int m = edges.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int[] edge : edges) {
            int row = edge[0];
            int col = edge[1];
            int distance = edge[2];
            matrix[row][col] = distance;
            matrix[col][row] = distance;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
        Map<Integer, Integer> cityDistanceCount = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    cityDistanceCount.put(i, cityDistanceCount.getOrDefault(i, 0) + 1);
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        for (int city : cityDistanceCount.keySet()) {
            minCount = Math.min(cityDistanceCount.get(city), minCount);
        }
        ArrayList<Integer> cities = new ArrayList<>();
        for (int city : cityDistanceCount.keySet()) {
            if (cityDistanceCount.get(city) == minCount) {
                cities.add(city);
            }
        }
        return cities.get(cities.size() - 1);


    }
}
