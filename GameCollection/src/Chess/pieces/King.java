package Chess.pieces;
import Chess.util.Chessboard;
import Chess.util.MoveCoordinates;
import java.util.ArrayList;

import static Chess.util.MoveSet.addKingMoves;
import static Chess.util.MoveSet.addKnightMoves;

public class King extends BasePiece {
    public King(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<>();
        int moveX = move.cordX;
        int moveY = move.cordY;

        moves = addKingMoves(moveX, moveY, moves);

        return moves;
    }
}
