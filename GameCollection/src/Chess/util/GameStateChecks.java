package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import java.util.ArrayList;

import static Chess.util.Chessboard.squares;
import static Chess.util.MoveSet.*;

public class GameStateChecks {
    public static ArrayList<MoveCoordinates> CurrentPiecesToCheck = new ArrayList<>();
    public static ArrayList<MoveCoordinates> DangerousSquares = new ArrayList<>();

    public static void isAttackedByKnight() {
        BasePiece.PieceColor enemyColor = GameState.CurrentColorMove;

        //Fill CurrentPiecesToCheck
        setCurrentPiecesToCheck(PieceEnum.Knight, enemyColor);
        fillDangerousSquares(PieceEnum.Knight, enemyColor);
    }

    public static void isAttackedByPawn() {
        BasePiece.PieceColor enemyColor = GameState.CurrentColorMove;

        //Fill CurrentPiecesToCheck
        setCurrentPiecesToCheck(PieceEnum.Pawn, enemyColor);
        fillDangerousSquares(PieceEnum.Pawn, enemyColor);

    }

    public static void isAttackedByQueen() {
        BasePiece.PieceColor enemyColor = GameState.CurrentColorMove;

        //Fill CurrentPiecesToCheck
        setCurrentPiecesToCheck(PieceEnum.Queen, enemyColor);
        fillDangerousSquares(PieceEnum.Queen, enemyColor);

    }

    public static void isAttackedByBishop() {
        BasePiece.PieceColor enemyColor = GameState.CurrentColorMove;
        //Fill CurrentPiecesToCheck
        setCurrentPiecesToCheck(PieceEnum.Bishop, enemyColor);
        fillDangerousSquares(PieceEnum.Bishop, enemyColor);

    }

    public static void isAttackedByRook() {
        BasePiece.PieceColor enemyColor = GameState.CurrentColorMove;
        //Fill CurrentPiecesToCheck
        setCurrentPiecesToCheck(PieceEnum.Rook, enemyColor);
        fillDangerousSquares(PieceEnum.Rook, enemyColor);


    }

    public static void isAttackedByKing() {
        BasePiece.PieceColor enemyColor = GameState.CurrentColorMove;
        //Fill CurrentPiecesToCheck
        setCurrentPiecesToCheck(PieceEnum.King, enemyColor);
        fillDangerousSquares(PieceEnum.King, enemyColor);

    }

    private static void fillDangerousSquares(PieceEnum type, BasePiece.PieceColor enemyColor) {
        for (MoveCoordinates pieceSquare : CurrentPiecesToCheck) {
            switch(type) {
                case Knight -> addKnightMoves(pieceSquare.cordX, pieceSquare.cordY, DangerousSquares);
                case Pawn -> addPawnMoves(pieceSquare.cordX, pieceSquare.cordY, DangerousSquares, enemyColor);
                case Queen -> {
                    addIntercardinalMoves(pieceSquare.cordX, pieceSquare.cordY, DangerousSquares);
                    addCardinalMoves(pieceSquare.cordX, pieceSquare.cordY, DangerousSquares);
                }
                case Bishop -> addIntercardinalMoves(pieceSquare.cordX, pieceSquare.cordY, DangerousSquares);
                case Rook -> addCardinalMoves(pieceSquare.cordX, pieceSquare.cordY, DangerousSquares);
                case King -> addKingMoves(pieceSquare.cordX, pieceSquare.cordY, DangerousSquares);
            }
        }
    }

    private static void setCurrentPiecesToCheck(PieceEnum type, BasePiece.PieceColor colorToCheck) {
        ArrayList<MoveCoordinates> pieces = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                BasePiece currentPiece = squares[x][y].currentPiece;
                if (currentPiece != null && currentPiece.pieceType == type && currentPiece.color == colorToCheck) {
                    pieces.add(new MoveCoordinates(x, y));
                }
            }
        }

        CurrentPiecesToCheck = pieces;
    }
}
