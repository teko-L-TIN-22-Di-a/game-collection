package Chess.pieces;
import Chess.util.MoveCoordinates;
import java.util.ArrayList;

public class Pawn extends BasePiece {
    public Pawn(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<MoveCoordinates>();
        int moveX = move.cordX;
        int moveY = move.cordY;

        if(this.color == PieceColor.WHITE) {
            if(moveX == 6) {
                moves.add(new MoveCoordinates(moveX - 2, moveY));
            }
            moves.add(new MoveCoordinates(moveX - 1, moveY));
        } else if(this.color == PieceColor.BLACK) {
            if(moveX == 1) {
                moves.add(new MoveCoordinates(moveX + 2, moveY));
            }
            moves.add(new MoveCoordinates(moveX + 1, moveY));
        }

        return moves;
    }
}
