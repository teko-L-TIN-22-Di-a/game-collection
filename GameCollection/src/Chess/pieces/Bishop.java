package Chess.pieces;

import Chess.util.MoveCoordinates;
import Chess.util.MoveSet;

import java.util.ArrayList;

public class Bishop extends BasePiece {
    public Bishop(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<MoveCoordinates>();
        int moveX = move.cordX;
        int moveY = move.cordY;

       moves = MoveSet.addIntercardinalMoves(moveX, moveY, moves);

        return moves;
    }
}
