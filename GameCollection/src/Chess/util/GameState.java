package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import javax.swing.*;
import java.util.ArrayList;

import static Chess.Chess.mainFrame;
import static Chess.pieces.PieceEnum.King;
import static Chess.util.Chessboard.squares;
import static Chess.util.GameStateChecks.*;

public class GameState {
    public static BasePiece.PieceColor CurrentColorMove;
    public static ArrayList<BasePiece> CaughtWhitePieces;
    public static ArrayList<BasePiece> CaughtBlackPieces;
    public static boolean CheckStateWhite;
    public static boolean CheckStateBlack;
    public static MoveCoordinates KingWhite;
    public static MoveCoordinates KingBlack;

    public static void initGameState() {
        CurrentColorMove = BasePiece.PieceColor.WHITE;
    }

    public static void updateGameState() {
        DangerousSquares = new ArrayList<>();

        findKingPositions();
        checkColorInCheckState();
        switchCurrentColorMove();
    }

    private static void checkColorInCheckState() {
        setDangerousSquares();

        // Check for attacks from different pieces to the opponent's king position
        if (currentKingInDanger()) {
            JOptionPane.showMessageDialog(mainFrame, "Check for " + CurrentColorMove);
            if (CurrentColorMove == BasePiece.PieceColor.WHITE) {
                CheckStateWhite = true;
            } else {
                CheckStateBlack = true;
            }
        } else {
            if (CurrentColorMove == BasePiece.PieceColor.WHITE) {
                CheckStateWhite = false;
            } else {
                CheckStateBlack = false;
            }
        }
    }

    private static boolean currentKingInDanger() {
        int kingX = CurrentColorMove == BasePiece.PieceColor.WHITE ? KingWhite.cordX : KingBlack.cordX;
        int kingY = CurrentColorMove == BasePiece.PieceColor.WHITE ? KingWhite.cordY : KingBlack.cordY;

        for (MoveCoordinates dangerSquare : DangerousSquares) {
            if(dangerSquare.cordX == kingX && dangerSquare.cordY == kingY) {
                return true;
            }
        }

        return false;
    }

    private static void setDangerousSquares() {
        isAttackedByKnight();
        isAttackedByPawn();
        isAttackedByQueen();
        isAttackedByRook();
        isAttackedByBishop();
        isAttackedByKing();
    }

    private static void switchCurrentColorMove() {
        CurrentColorMove = CurrentColorMove == BasePiece.PieceColor.WHITE ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;
    }

    private static void findKingPositions() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (squares[x][y].currentPiece != null && squares[x][y].currentPiece.pieceType == King) {
                    if (squares[x][y].currentPiece.color == BasePiece.PieceColor.WHITE) {
                        KingWhite = new MoveCoordinates(x, y);
                    } else {
                        KingBlack = new MoveCoordinates(x, y);
                    }
                }
            }
        }
    }

    public static void putPieceInCaughtSet(BasePiece piece) {
        if (piece.color == BasePiece.PieceColor.WHITE) {
            CaughtWhitePieces.add(piece);
        } else {
            CaughtBlackPieces.add(piece);
        }
    }
}
