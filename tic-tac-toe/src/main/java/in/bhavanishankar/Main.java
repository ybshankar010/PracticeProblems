package in.bhavanishankar;

import in.bhavanishankar.game.Board;
import in.bhavanishankar.game.GameUtils;
import in.bhavanishankar.game.Move;
import in.bhavanishankar.game.ai.AIPlayer;
import in.bhavanishankar.game.ai.RandomPlayer;
import in.bhavanishankar.game.exception.BoardException;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws BoardException {
        Scanner inputScanner = new Scanner(System.in);
        Board tictactoe = new Board();
        char userPiece = 'X',aiPiece = 'O';
        boolean isWinner = false;
        AIPlayer aiPlayer = new RandomPlayer(aiPiece);
        int count =0;
        while ( !isWinner && count < 9 ) {
            IO.println("Enter row and colum :: ");
            int userRowMove = inputScanner.nextInt();
            int userColMove = inputScanner.nextInt();
            Move userMove = new Move(userRowMove,userColMove,userPiece);
            tictactoe.movePiece(userMove);
            IO.println("Player move done "+userMove);
            isWinner = GameUtils.isWinner(tictactoe);
            if(isWinner) {
                IO.println("*****USER "+userPiece+" IS WINNER*****");
            }
            ++count;
            if (!isWinner && count != 9) {
                Move aiMove =aiPlayer.nextMove(userMove,tictactoe);
                tictactoe.movePiece(aiMove);
                IO.println("Player move done "+aiMove);
                isWinner = GameUtils.isWinner(tictactoe);
                if(isWinner) {
                    IO.println("*****AI "+aiPiece+" IS WINNER*****");
                    break;
                }
                ++count;
            }

            IO.println("=======================");
            IO.println(tictactoe);
            IO.println("=======================");
        }

        if (!isWinner) {
            IO.println("*****GAME DRAW*****");
        }
    }
}
