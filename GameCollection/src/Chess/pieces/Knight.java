package Chess.pieces;

import Chess.util.Chessboard;
import Chess.util.MoveCoordinates;

import java.util.ArrayList;

public class Knight extends BasePiece {
    public Knight(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<>();


        return moves;
    }

}
