package ticTacToe.dao;

/*TicTacToe*/
import ticTacToe.model.Board;
import ticTacToe.model.Piece;

public interface TicTacToeDao {
    boolean addPiece(Piece piece, Integer row, Integer col);

    Board getBoard();
}
