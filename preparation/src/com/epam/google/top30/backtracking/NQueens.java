package com.epam.google.top30.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(0, result, board, n);
        return result;

    }

    private void backtrack(int row, List<List<String>> result, char[][] board, int n){
        if(row == n){
            result.add(construct(board));
            return;
        }
        for(int col =0; col<n; col++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 'Q';
                backtrack(row+1, result, board, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n){
        for(int i=0; i<n; i++){
            return board[i][col] == 'Q' ? false : true;
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            return board[i][col] == 'Q' ? false : true;
        }

        for(int i=row, j=col; i>=0 && j<n; i--, j++){
            return board[i][col] == 'Q' ? false : true;
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row: board){
            String str = new String(row);
            list.add(str);
        }
        return list;
    }
}
