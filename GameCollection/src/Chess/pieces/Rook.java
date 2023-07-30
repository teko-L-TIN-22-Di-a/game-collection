package Chess.pieces;
import Chess.util.Chessboard;
import Chess.util.MoveCoordinates;
import Chess.util.MoveSet;

import java.util.ArrayList;

public class Rook extends BasePiece {
    public Rook(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<MoveCoordinates>();
        int moveX = move.cordX;
        int moveY = move.cordY;
        ArrayList<int[]> cardinalCoordinates = MoveSet.getCardinalCoordinates(moveX, moveY);

        for (int[] coordinates : cardinalCoordinates) {
            int newX = coordinates[0];
            int newY = coordinates[1];

            if (!(newX == moveX && newY == moveY) && newX >= 0 && newX < Chessboard.rows && newY >= 0 && newY < Chessboard.cols) {
                moves.add(new MoveCoordinates(newX, newY));
            }
        }

        return moves;
    }
}
