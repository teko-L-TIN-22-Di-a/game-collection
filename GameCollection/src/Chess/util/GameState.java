package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import javax.swing.*;
import java.util.ArrayList;

import static Chess.Chess.mainFrame;
import static Chess.pieces.PieceEnum.King;
import static Chess.util.Chessboard.squares;
import static Chess.util.GameStateChecks.*;
import static Chess.util.MoveSet.addKingMoves;

public class GameState {
    public static BasePiece.PieceColor CurrentColorMove;
    //    public static BasePiece.PieceColor EnemyColor;
    public static ArrayList<BasePiece> CaughtWhitePieces;
    public static ArrayList<BasePiece> CaughtBlackPieces;
    public static boolean CheckStateWhite;
    public static boolean CheckStateBlack;
    public static MoveCoordinates KingWhite;
    public static MoveCoordinates KingBlack;

    public static void initGameState() {
        CurrentColorMove = BasePiece.PieceColor.WHITE;
//        EnemyColor = BasePiece.PieceColor.BLACK;
    }

    public static void updateGameState() {
        DangerousSquaresWhite = new ArrayList<>();
        DangerousSquaresBlack = new ArrayList<>();

        findKingPositions();
        checkColorInCheckState();
        switchCurrentColors();
    }

    private static void checkColorInCheckState() {
        setDangerousSquares();
        kingInDanger();
    }

    private static void kingInDanger() {
        int kingBlackX = KingBlack.cordX;
        int kingBlackY = KingBlack.cordY;
        int kingWhiteX = KingWhite.cordX;
        int kingWhiteY = KingWhite.cordY;


        for (MoveCoordinates dangerSquare : DangerousSquaresBlack) {
            if (dangerSquare.cordX == kingWhiteX && dangerSquare.cordY == kingWhiteY) {
                CheckStateWhite = true;
                //Can the King escape or is it game over?
                ArrayList<MoveCoordinates> kingMoves = new ArrayList<>();
                addKingMoves(kingWhiteX, kingWhiteY, kingMoves, BasePiece.PieceColor.WHITE);

                boolean gameOverWhite = true;

                for(MoveCoordinates kingMove : kingMoves) {
                    if(gameOverWhite && !DangerousSquaresBlack.stream().anyMatch(x -> x.cordX == kingMove.cordX && x.cordY == kingMove.cordY)
                    ) {
                        gameOverWhite = false;
                    }
                }

                if(gameOverWhite) {
                    JOptionPane.showMessageDialog(mainFrame, "White lost");
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "White King in Check");
                }
                break;
            } else {
                CheckStateWhite = false;
            }
        }

        for (MoveCoordinates dangerSquare : DangerousSquaresWhite) {
            if (dangerSquare.cordX == kingBlackX && dangerSquare.cordY == kingBlackY) {
                CheckStateBlack = true;
                //Can the King escape or is it game over?
                ArrayList<MoveCoordinates> kingMoves = new ArrayList<>();
                addKingMoves(kingBlackX, kingBlackY, kingMoves, BasePiece.PieceColor.BLACK);

                boolean gameOverBlack = true;

                for(MoveCoordinates kingMove : kingMoves) {
                    if(gameOverBlack && !DangerousSquaresWhite.stream().anyMatch(x -> x.cordX == kingMove.cordX && x.cordY == kingMove.cordY)
                    ) {
                        gameOverBlack = false;
                    }
                }

                //Can you kill a dangerous piece? Are you safe then?
                //Compare all dangerous moves from the enemy color with your pieces possible moves and re-check with the new ArrayList if the piece
                //would get removed
                if(gameOverBlack) {
                    gameOverBlack = checkIfCheckCanBeRemovedForBlack();
                }

                if(gameOverBlack) {
                    JOptionPane.showMessageDialog(mainFrame, "Black lost");
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Black King in Check");
                }
                break;
            } else {
                CheckStateBlack = false;
            }
        }
    }

    private static boolean checkIfCheckCanBeRemovedForBlack() {
        ArrayList<MoveCoordinates> whitePiecesCords = new ArrayList<>();

        for(MoveCoordinates x : DangerousSquaresBlack) {
            Square currentSquare = squares[x.cordX][x.cordY];
            if(currentSquare.currentPiece != null && currentSquare.currentPiece.color == BasePiece.PieceColor.WHITE) {
                whitePiecesCords.add(x);
            }
        }

        if(whitePiecesCords.stream().count() > 0) {
            for (MoveCoordinates pieceWhite : whitePiecesCords) {
                //Different approach
//                setDangerousSquaresTheoretical(pieceWhite);
            }
        }

        return true;
    }

    private static void setDangerousSquares() {
        setAllAttackMoves();
    }

    private static void setDangerousSquaresTheoretical(MoveCoordinates pieceWhite) {
//        setAllAttackMovesTheoretical(pieceWhite, BasePiece.PieceColor.WHITE);
    }

    private static void switchCurrentColors() {
        CurrentColorMove = CurrentColorMove == BasePiece.PieceColor.WHITE ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;
//        EnemyColor = EnemyColor == BasePiece.PieceColor.WHITE ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;
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
