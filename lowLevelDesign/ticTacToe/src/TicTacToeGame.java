import model.*;

import java.util.Deque;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPiece cross = new PlayingPieceX();
        Player player1 = new Player("John", cross);
        PlayingPiece zero = new PlayingPieceO();
        Player player2 = new Player("Roxy", zero);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(4);
    }

    public String playGame(){
        boolean win = false;
        while (!win){
            Player playerTurn = players.removeFirst();
            List<Pair<Integer,Integer>> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                win = true;
                continue;
            }
            System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);
            boolean addPieceSuccessful = gameBoard.addPiece(inputRow,inputColumn, playerTurn.getPiece());
            if(!addPieceSuccessful){
                System.out.println("Incorrect position chosen, try again later");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isWinner(inputRow, inputColumn, playerTurn.getPiece().getType());
            if(winner){
                return playerTurn.getName();
            }
        }
        return "tie";

    }

    private boolean isWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = false;
        boolean columnMatch = false;
        boolean diagonalMatch = false;
        boolean antiDiagonalMatch = false;

        //row wise check
        for(int i=0; i<gameBoard.size; i++){
            if(gameBoard.board[row][i] != null && gameBoard.board[row][i].getType() ==  pieceType){
                rowMatch = true;
            }
        }
        //Column wise check
        for(int i=0; i<gameBoard.size; i++){
            if(gameBoard.board[i][column] != null && gameBoard.board[i][column].getType() == pieceType){
                columnMatch = true;
            }
        }

        for(int i=0, j=0; i<gameBoard.size; i++, j++){
            if(gameBoard.board[i][j] != null && gameBoard.board[i][j].getType() ==  pieceType){
                diagonalMatch = true;
            }
        }

        for(int i=0, j= gameBoard.size-1; i<gameBoard.size; i++, j--){
            if(gameBoard.board[i][j] != null && gameBoard.board[i][j].getType() ==  pieceType){
                antiDiagonalMatch = true;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
