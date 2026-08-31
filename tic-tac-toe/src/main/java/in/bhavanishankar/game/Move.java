package in.bhavanishankar.game;

public class Move {
    public static char INIT_POSITION = '-';

    private int row, col;
    private char value;

    public Move() {
        row = col = -1;
        value = '-';
    }
    public Move(int row, int col, char value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.row+","+this.col+"::"+this.value;
    }
}
