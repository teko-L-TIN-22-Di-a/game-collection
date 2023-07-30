package Chess.util;

import java.util.ArrayList;

public class MoveSet {
    private static final int[][] knightMoveSet = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    public static boolean isValidPosition(int newX, int newY, int moveX, int moveY) {
       return !(newX == moveX && newY == moveY) && newX >= 0 && newX < Chessboard.rows && newY >= 0 && newY < Chessboard.cols;
    }

    public static ArrayList<MoveCoordinates> addKnightMoves(int moveX, int moveY, ArrayList<MoveCoordinates> moves) {
        for (int[] move : knightMoveSet) {
            int newX = moveX + move[0];
            int newY = moveY + move[1];

            if (isValidPosition(newX, newY, moveX, moveY)) {
                moves.add(new MoveCoordinates(newX, newY));
            }
        }

        return moves;
    }

    public static ArrayList<MoveCoordinates> addCardinalMoves(int moveX, int moveY, ArrayList<MoveCoordinates> moves) {
        ArrayList<int[]> cardinalCoordinates = MoveSet.getCardinalCoordinates(moveX, moveY);

        for (int[] coordinates : cardinalCoordinates) {
            int newX = coordinates[0];
            int newY = coordinates[1];

            if (isValidPosition(newX, newY, moveX, moveY)) {
                moves.add(new MoveCoordinates(newX, newY));
            }
        }

        return moves;
    }

    public static ArrayList<MoveCoordinates> addIntercardinalMoves(int moveX, int moveY, ArrayList<MoveCoordinates> moves) {
        for (int dx = -1; dx <= 1; dx += 2) {
            for (int dy = -1; dy <= 1; dy += 2) {
                int maxStepsX = dx > 0 ? Chessboard.rows - moveX - 1 : moveX;
                int maxStepsY = dy > 0 ? Chessboard.cols - moveY - 1 : moveY;
                int maxSteps = Math.min(maxStepsX, maxStepsY);

                for (int step = 1; step <= maxSteps; step++) {
                    int newX = moveX + dx * step;
                    int newY = moveY + dy * step;
                    if (isValidPosition(newX, newY, moveX, moveY)) {
                        moves.add(new MoveCoordinates(newX, newY));
                    }
                }
            }
        }

        return moves;
    }

    public static ArrayList<int[]> getCardinalCoordinates(int x, int y) {
        ArrayList<int[]> coordinates = new ArrayList<>();

        for(int i = 0; i < Chessboard.rows; i++) {
            // West
            if (y - i >= 0) {
                coordinates.add(new int[]{x, y - i});
            }

            // East
            if (y + i <= 7) {
                coordinates.add(new int[]{x, y + i});
            }

            // East
            if (x + i <= 7) {
                coordinates.add(new int[]{x + i, y});
            }

            // West
            if (x - i >= 0) {
                coordinates.add(new int[]{x - i, y});
            }
        }

        return coordinates;
    }
}
