package Chess.util;

import Chess.pieces.BasePiece;

public class Move {
    public static int currentX;
    public static int currentY;
    public static int newX;
    public static int newY;
    public static BasePiece currentPiece;
    int[][] possibleMoves = new int[8][8];

    public Move(int currX, int currY, BasePiece currPiece) {
        currentX = currX;
        currentY = currY;
        currentPiece = currPiece;
    }

    public static void setNewCoordinates(int x, int y) {
        newX = x;
        newY = y;
    }

    public static boolean validMove() {
        return true;
    }
}
