package com.epam.google;



public class RangeSumQuery2D {
    int[][] tree;
    int[][] num;
    int m;
    int n;

    public RangeSumQuery2D(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        tree = new int[m+1][n+1];
        num = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }
    public void update(int row, int col, int value) {
        if(m == 0 || n ==0){
            return;
        }
        int del = value - num[row][col];
        num[row][col] = value;
        for(int i=row+1; i<=m; i += i & (-i)){
            for(int j=col+1; j<=n; j+= j & (-j)){
                tree[i][j] += del;
            }
        }
    }
    private int sumRegion(int r1, int c1, int r2, int c2){
        if(m == 0 || n ==0){
            return 0;
        }
        return sum(r2+1,c2+1) + sum(r1,c1) - sum(r1, c2+1) - sum(r2+1, c1);
    }
    private int sum(int row, int col){
        int sum = 0;
        for(int i=row; i<m; i-= i&(-i)){
            for(int j=col; j<n; j-=j&(-j)){
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
