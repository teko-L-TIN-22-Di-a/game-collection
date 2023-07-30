package Chess.pieces;
import Chess.util.Chessboard;
import Chess.util.MoveCoordinates;
import java.util.ArrayList;

public class King extends BasePiece {
    public King(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<>();
        int moveX = move.cordX;
        int moveY = move.cordY;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = moveX + dx;
                int newY = moveY + dy;

                if (!(newX == moveX && newY == moveY) && newX >= 0 && newX < Chessboard.rows && newY >= 0 && newY < Chessboard.cols) {
                    moves.add(new MoveCoordinates(newX, newY));
                }
            }
        }
        return moves;
    }
}
