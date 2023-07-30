package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import java.util.ArrayList;

import static Chess.util.Chessboard.squares;

public class MoveSet {
    private static final int[][] knightMoveSet = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    public static boolean isValidPosition(int newX, int newY, int moveX, int moveY) {
        //Draw a valid move if it's not the position of the piece itself, not out of bounds of the 8x8 grid
        return !(newX == moveX && newY == moveY) && newX >= 0 && newX < Chessboard.rows && newY >= 0 && newY < Chessboard.cols;
    }

    public static ArrayList<MoveCoordinates> addKingMoves(int moveX, int moveY, ArrayList<MoveCoordinates> moves) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = moveX + dx;
                int newY = moveY + dy;

                if (isValidPosition(newX, newY, moveX, moveY)) {
                    moves.add(new MoveCoordinates(newX, newY));
                }
            }
        }
        return moves;
    }

    public static ArrayList<MoveCoordinates> addPawnMoves(int moveX, int moveY, ArrayList<MoveCoordinates> moves, BasePiece.PieceColor color) {
        if (color == BasePiece.PieceColor.WHITE) {
            if (moveX == 6) {
                moves.add(new MoveCoordinates(moveX - 2, moveY));
            }
            if (moveX != 0) {
                moves.add(new MoveCoordinates(moveX - 1, moveY));
            }
        } else if (color == BasePiece.PieceColor.BLACK) {
            if (moveX == 1) {
                moves.add(new MoveCoordinates(moveX + 2, moveY));
            }
            if (moveX != 7) {
                moves.add(new MoveCoordinates(moveX + 1, moveY));
            }
        }
        return moves;
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
                //dx > 0 == North, dx < 0 == South
                int maxStepsX = dx > 0 ? Chessboard.rows - moveX - 1 : moveX;

                //dy > 0 == East, dy < 0 == West
                int maxStepsY = dy > 0 ? Chessboard.cols - moveY - 1 : moveY;
                int maxSteps = Math.min(maxStepsX, maxStepsY);

                boolean currentDirectionBlocked = false;
                //Loop through all intercardinal steps for each direction
                for (int step = 1; step <= maxSteps; step++) {
                    int newX = moveX + dx * step;
                    int newY = moveY + dy * step;
                    if (!currentDirectionBlocked && isValidPosition(newX, newY, moveX, moveY)) {
                        if (squares[newX][newY].currentPiece == null) {
                            moves.add(new MoveCoordinates(newX, newY));
                        } else {
                            if (squares[newX][newY].currentPiece.color != Move.currentPiece.color) {
                                moves.add(new MoveCoordinates(newX, newY));
                            }
                            currentDirectionBlocked = true;
                        }
                    }
                }
            }
        }

        return moves;
    }

    public static ArrayList<int[]> getCardinalCoordinates(int x, int y) {
        ArrayList<int[]> coordinates = new ArrayList<>();
        boolean BlockingPieceNorth = false;
        boolean BlockingPieceEast = false;
        boolean BlockingPieceSouth = false;
        boolean BlockingPieceWest = false;

        for (int i = 1; i < Chessboard.rows; i++) {
            // West
            if (y - i >= 0 && !BlockingPieceWest) {
                if (squares[x][y - i].currentPiece == null) {
                    coordinates.add(new int[]{x, y - i});
                } else {
                    if (squares[x][y - i].currentPiece.color != Move.currentPiece.color) {
                        coordinates.add(new int[]{x, y - i});
                    }
                    BlockingPieceWest = true;
                }
            }

            // East
            if (y + i <= 7 && !BlockingPieceEast) {
                if (squares[x][y + i].currentPiece == null) {
                    coordinates.add(new int[]{x, y + i});
                } else {
                    if (squares[x][y + i].currentPiece.color != Move.currentPiece.color) {
                        coordinates.add(new int[]{x, y + i});
                    }
                    BlockingPieceEast = true;
                }
            }

            // South
            if (x + i <= 7 && !BlockingPieceSouth) {
                if (squares[x + i][y].currentPiece == null) {
                    coordinates.add(new int[]{x + i, y});
                } else {
                    if (squares[x + i][y].currentPiece.color != Move.currentPiece.color) {
                        coordinates.add(new int[]{x + i, y});
                    }
                    BlockingPieceSouth = true;
                }
            }

            // North
            if (x - i >= 0 && !BlockingPieceNorth) {
                if (squares[x - i][y].currentPiece == null) {
                    coordinates.add(new int[]{x - i, y});
                } else {
                    if (squares[x - i][y].currentPiece.color != Move.currentPiece.color) {
                        coordinates.add(new int[]{x - i, y});
                    }
                    BlockingPieceNorth = true;
                }
            }
        }

        return coordinates;
    }
}
