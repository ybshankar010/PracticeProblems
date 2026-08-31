package in.bhavanishankar.game;

import in.bhavanishankar.game.exception.BoardException;

public class GameUtils {

    public static boolean isWinner(Board board) throws BoardException {
        char curr_value,prev_value;
        boolean isSame;

        // Check if the rows have prices filled
        for (int i=0;i<Board.ROWS;++i) {
            prev_value = '#';
            isSame = true;
            for (int j=0;j<Board.COLS;++j) {
                curr_value = board.getPiece(i,j);
                if (prev_value != '#' && (prev_value != curr_value)){
                    isSame = false;
                }
                prev_value = curr_value;
            }
            if (isSame && prev_value != '#' && prev_value != '-') {
                return true;
            }
        }

        // check if cols have pieces filled
        for (int j=0;j<Board.COLS;++j) {
            prev_value = '#';
            isSame = true;
            for (int i=0;i<Board.ROWS;++i) {
                curr_value = board.getPiece(i,j);
                if (prev_value != '#' && (prev_value != curr_value)) {
                    isSame = false;
                }
                prev_value = curr_value;
            }
            if (isSame && prev_value != '#' && prev_value != '-') {
                return true;
            }
        }

        // check for diagonals if they are filled
        isSame = true;
        prev_value = '#';
        for (int i=0;i<Board.ROWS;++i) {
            isSame = true;
            curr_value = board.getPiece(i,i);
            if (prev_value != '#' && (prev_value != curr_value)) {
                isSame = false;
            }
            prev_value = curr_value;
        }
        if (isSame && prev_value != '#' && prev_value != '-') {
            return true;
        }

        isSame = true;
        prev_value = '#';
        for (int j=0;j<Board.COLS;++j) {
            isSame = true;
            curr_value = board.getPiece(j,Board.COLS-j-1);
            if (prev_value != '#' && (prev_value != curr_value)) {
                isSame = false;
            }
            prev_value = curr_value;
        }
        if (isSame && prev_value != '#' && prev_value != '-') {
            return true;
        }

        return false;
    }

}
