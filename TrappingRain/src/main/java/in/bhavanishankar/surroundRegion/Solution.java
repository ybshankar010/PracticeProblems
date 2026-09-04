package in.bhavanishankar.surroundRegion;

public class Solution {
    private static final int[] ROW_TRAVERSAL = {-1,1,0,0};
    private static final int[] COL_TRAVERSAL = {0,0,1,-1};

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i=0;i<rows;++i) {
            for (int j=0;j<cols;++j) {
                if (isOnEdge(i,j,rows,cols) && board[i][j] == 'O') {
                    performDFS(i,j,board);
                }
            }
        }

        for (int i=0;i<rows;++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'X') {
                    continue;
                }
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void performDFS(int row, int col,char[][] board){
        int rows = board.length,cols = board[0].length;
        board[row][col] = '#';

        for (int i=0;i<ROW_TRAVERSAL.length;++i) {
            int next_row_idx = row + ROW_TRAVERSAL[i];
            int next_col_idx = col + COL_TRAVERSAL[i];
            if (isInBounds(next_row_idx,next_col_idx,rows,cols)
                    && board[next_row_idx][next_col_idx] == 'O') {
                    performDFS(next_row_idx,next_col_idx,board);
            }
        }
    }

    private boolean isOnEdge(int row,int col, int rows,int cols) {
        return (row == 0 || row == rows-1) || (col == 0 || col == cols-1);
    }

    private boolean isInBounds(int nextRowIdx, int nextColIdx, int rows, int cols) {
        return (nextRowIdx>=0 && nextRowIdx<rows) &&(nextColIdx >=0 && nextColIdx< cols);
    }
}
