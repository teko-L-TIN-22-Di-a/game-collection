package Chess.pieces;

import Chess.util.MoveCoordinates;

import java.util.ArrayList;

import static Chess.util.MoveSet.addPawnMoves;

public class Pawn extends BasePiece {
    public Pawn(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<MoveCoordinates>();
        int moveX = move.cordX;
        int moveY = move.cordY;

        moves = addPawnMoves(moveX, moveY, moves, this.color);

        return moves;
    }
}
