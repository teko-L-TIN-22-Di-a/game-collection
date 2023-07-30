package Chess.pieces;
import Chess.util.MoveCoordinates;
import java.util.ArrayList;

public class Queen extends BasePiece {
    public Queen(PieceEnum type, PieceColor color) {
        super.initBasePiece(type, color);
    }

    public ArrayList<MoveCoordinates> checkMove(MoveCoordinates move) {
        ArrayList<MoveCoordinates> moves = new ArrayList<MoveCoordinates>();

        return moves;
    }
}
