package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece piece){
        if(board[row][column] != null){
            return false;
        }
        board[row][column] = piece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> freeCells = new ArrayList<>();
        for(int i=0; i<size;i++){
            for (int j=0; j<size;j++){
                if(board[i][j] == null){
                    freeCells.add(new Pair<>(i,j));
                }
            }
        }
        return freeCells;
    }

}
