package in.bhavanishankar.game.ai;

import in.bhavanishankar.game.Board;
import in.bhavanishankar.game.Move;
import in.bhavanishankar.game.exception.BoardException;

import java.util.ArrayList;
import java.util.List;

public class RandomPlayer implements AIPlayer {

    private List<String> candidateMoves;
    private char aiPiece = '-';

    public RandomPlayer(char aiPiece){
        candidateMoves = new ArrayList<>();

        for (int i=0;i<Board.ROWS;++i) {
            for (int j=0;j<Board.COLS;++j) {
                candidateMoves.add(i+"_"+j);
            }
        }
        this.aiPiece = aiPiece;
    }

    @Override
    public Move nextMove(Move previousMove, Board board) throws BoardException {
        if (this.candidateMoves.isEmpty()) {
            throw new BoardException("Game Over");
        }
        this.candidateMoves.remove(previousMove.getRow()+"_"+previousMove.getCol());
        String nextMove = this.candidateMoves.removeFirst();
        String[] positions = nextMove.split("_");
        return new Move(Integer.parseInt(positions[0]),Integer.parseInt(positions[1]),this.aiPiece);
    }
}
