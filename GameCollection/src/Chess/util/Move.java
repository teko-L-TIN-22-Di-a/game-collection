package Chess.util;

import Chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Move {
    public static MoveCoordinates currentCords;
    public static MoveCoordinates newCords;
    public static BasePiece currentPiece;
    public static ArrayList<MoveCoordinates> possibleMoves;

    public Move(int currX, int currY, BasePiece currPiece) {
        currentCords = new MoveCoordinates(currX, currY);
        currentPiece = currPiece;

        initPossibleMoves();
    }

    private void initPossibleMoves() {
        switch (currentPiece.pieceType) {
            case Knight -> possibleMoves = ((Knight) currentPiece).checkMove(currentCords);
            case Bishop -> possibleMoves = ((Bishop) currentPiece).checkMove(currentCords);
            case Queen -> possibleMoves = ((Queen) currentPiece).checkMove(currentCords);
            case Rook -> possibleMoves = ((Rook) currentPiece).checkMove(currentCords);
            case Pawn -> possibleMoves = ((Pawn) currentPiece).checkMove(currentCords);
            case King -> possibleMoves = ((King) currentPiece).checkMove(currentCords);
        }
    }

    public static ArrayList<MoveCoordinates> getPossibleMoves() {
        return possibleMoves;
    }

    public static void setNewCoordinates(int x, int y) {
        newCords = new MoveCoordinates(x, y);
    }

    public static boolean validMove() {
        boolean moveValid = false;

        for (int i = 0; i < possibleMoves.size(); i++) {
            if (possibleMoves.get(i).cordX == newCords.cordX && possibleMoves.get(i).cordY == newCords.cordY) {
                moveValid = true;
            }
        }
        //Check moveset for possible moves and if coordinates old -> new match that


        return moveValid;
    }
}
