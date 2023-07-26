package Chess.pieces;

import Chess.util.Chessboard;
import Chess.util.MoveCoordinates;

import java.util.ArrayList;

public class Bishop extends BasePiece {
    public Bishop(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<MoveCoordinates>();
        int moveX = move.cordX;
        int moveY = move.cordY;

        for (int dx = -1; dx <= 1; dx += 2) {
            for (int dy = -1; dy <= 1; dy += 2) {
                int maxStepsX = dx > 0 ? Chessboard.rows - moveX - 1 : moveX;
                int maxStepsY = dy > 0 ? Chessboard.cols - moveY - 1 : moveY;
                int maxSteps = Math.min(maxStepsX, maxStepsY);

                for (int step = 1; step <= maxSteps; step++) {
                    int newX = moveX + dx * step;
                    int newY = moveY + dy * step;
                    if (!(newX == moveX && newY == moveY) && newX >= 0 && newX < Chessboard.rows && newY >= 0 && newY < Chessboard.cols) {
                        moves.add(new MoveCoordinates(newX, newY));
                    }
                }
            }
        }

        return moves;
    }
}
