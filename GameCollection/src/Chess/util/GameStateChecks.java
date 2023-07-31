package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import java.util.ArrayList;

import static Chess.util.Chessboard.squares;
import static Chess.util.MoveSet.*;

public class GameStateChecks {
    public static ArrayList<MoveCoordinates> CurrentPiecesToCheck = new ArrayList<>();
    public static ArrayList<MoveCoordinates> DangerousSquaresBlack = new ArrayList<>();
    public static ArrayList<MoveCoordinates> DangerousSquaresWhite = new ArrayList<>();

    public static void setAllAttackMoves() {
        for (BasePiece.PieceColor color : BasePiece.PieceColor.values()) {
            for (PieceEnum pieceType : PieceEnum.values()) {
                setCurrentPiecesToCheck(pieceType, color);
                fillDangerousSquares(pieceType, color, false);
            }
        }
    }

    private static void fillDangerousSquares(PieceEnum type, BasePiece.PieceColor color, boolean theoretical) {
        if (theoretical) {
//            if (color == BasePiece.PieceColor.WHITE) {
//                setMovesHelper(type, DangerousSquaresWhiteTheoretical, BasePiece.PieceColor.WHITE, CurrentPiecesToCheckTheoretical);
//            } else {
//                setMovesHelper(type, DangerousSquaresBlackTheoretical, BasePiece.PieceColor.BLACK, CurrentPiecesToCheckTheoretical);
//            }
        } else {
            if (color == BasePiece.PieceColor.WHITE) {
                setMovesHelper(type, DangerousSquaresWhite, BasePiece.PieceColor.WHITE, CurrentPiecesToCheck);
            } else {
                setMovesHelper(type, DangerousSquaresBlack, BasePiece.PieceColor.BLACK, CurrentPiecesToCheck);
            }
        }

    }

    public static void setMovesHelper(PieceEnum type, ArrayList<MoveCoordinates> dangerousSquares, BasePiece.PieceColor color, ArrayList<MoveCoordinates> piecesToCheck) {
        for (MoveCoordinates pieceSquare : piecesToCheck) {
            switch (type) {
                case Knight -> addKnightMoves(pieceSquare.cordX, pieceSquare.cordY, dangerousSquares, color);
                case Pawn -> addPawnMoves(pieceSquare.cordX, pieceSquare.cordY, dangerousSquares, color);
                case Queen -> {
                    addIntercardinalMoves(pieceSquare.cordX, pieceSquare.cordY, dangerousSquares, color);
                    addCardinalMoves(pieceSquare.cordX, pieceSquare.cordY, dangerousSquares, color);
                }
                case Bishop -> addIntercardinalMoves(pieceSquare.cordX, pieceSquare.cordY, dangerousSquares, color);
                case Rook -> addCardinalMoves(pieceSquare.cordX, pieceSquare.cordY, dangerousSquares, color);
                case King -> addKingMoves(pieceSquare.cordX, pieceSquare.cordY, dangerousSquares, color);
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


//    public static ArrayList<MoveCoordinates> CurrentPiecesToCheckTheoretical = new ArrayList<>();
//    public static ArrayList<MoveCoordinates> DangerousSquaresBlackTheoretical = new ArrayList<>();
//    public static ArrayList<MoveCoordinates> DangerousSquaresWhiteTheoretical = new ArrayList<>();
//
//    public static void setAllAttackMovesTheoretical(MoveCoordinates pieceToRemove, BasePiece.PieceColor pieceColor) {
//        for (PieceEnum pieceType : PieceEnum.values()) {
//            setCurrentPiecesToCheckTheoretical(pieceType, pieceColor, pieceToRemove);
//            fillDangerousSquares(pieceType, pieceColor, true);
//        }
//    }
//
//    private static void setCurrentPiecesToCheckTheoretical(PieceEnum type, BasePiece.PieceColor colorToCheck, MoveCoordinates pieceToRemove) {
//        ArrayList<MoveCoordinates> pieces = new ArrayList<>();
//        for (int x = 0; x < 8; x++) {
//            for (int y = 0; y < 8; y++) {
//                if (!(x == pieceToRemove.cordX && y == pieceToRemove.cordY)) {
//                    BasePiece currentPiece = squares[x][y].currentPiece;
//                    if (currentPiece != null && currentPiece.pieceType == type && currentPiece.color == colorToCheck) {
//                        pieces.add(new MoveCoordinates(x, y));
//                    }
//                }
//            }
//        }
//
//        CurrentPiecesToCheckTheoretical = pieces;
//    }
}
