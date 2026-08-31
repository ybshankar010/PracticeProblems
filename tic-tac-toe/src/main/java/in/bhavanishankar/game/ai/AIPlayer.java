package in.bhavanishankar.game.ai;

import in.bhavanishankar.game.Board;
import in.bhavanishankar.game.Move;
import in.bhavanishankar.game.exception.BoardException;

public interface AIPlayer {

    Move nextMove(Move previousMove,Board board) throws BoardException;
}
