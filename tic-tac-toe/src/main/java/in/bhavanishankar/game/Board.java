package in.bhavanishankar.game;

import in.bhavanishankar.game.exception.BoardException;

public class Board {

    public static final int ROWS = 3;
    public static final int COLS = 3;

    private char[][] board;

    public Board() {
        this.board = new char[ROWS][COLS];

        for (int i=0;i<ROWS;++i) {
            for(int j=0;j<COLS;++j) {
                this.board[i][j] = Move.INIT_POSITION;
            }
        }
    }

    public boolean isInBoundaries(int row, int col) {
        return (row>=0 && row < ROWS) &&(col>=0 && col<COLS);
    }
    public boolean isValidMove(int row, int col) {
        return isInBoundaries(row,col)
                && (board[row][col] == Move.INIT_POSITION);
    }

    public void movePiece(Move move) throws BoardException {
        if (!isValidMove(move.getRow(),move.getCol())){
            IO.println("Invalid Move");
            throw new BoardException("Invalid Move");
        }
        board[move.getRow()][move.getCol()] = move.getValue();
    }

    public char getPiece(int row, int col) throws BoardException {
        if (!isInBoundaries(row,col)) {
            throw new BoardException("Invalid Access");
        }

        return board[row][col];
    }


    @Override
    public String toString() {

        StringBuilder boardString = new StringBuilder();
        for (char[] row : board){
            for (char col : row){
                boardString.append(col).append(" ");
            }
            boardString.append("\n");
        }

        return boardString.toString();
    }
}
