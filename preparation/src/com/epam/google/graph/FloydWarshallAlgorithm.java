package com.epam.google.graph;

public class FloydWarshallAlgorithm {
    public void shortestDistance(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                if(i==j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int k = 0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == Integer.MAX_VALUE){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
