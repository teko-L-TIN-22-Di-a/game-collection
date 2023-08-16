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
    public static ArrayList<BasePiece> CaughtWhitePieces;
    public static ArrayList<BasePiece> CaughtBlackPieces;
    public static boolean CheckStateWhite;
    public static boolean CheckStateBlack;
    public static MoveCoordinates KingWhite;
    public static MoveCoordinates KingBlack;

    public static void initGameState() {
        CurrentColorMove = BasePiece.PieceColor.WHITE;
        CheckStateBlack = false;
        CheckStateWhite = false;
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

                //Can the king free itself?
                for (MoveCoordinates kingMove : kingMoves) {
                    if (gameOverWhite) {
                        gameOverWhite = simulateKingMove(kingMove.cordX, kingMove.cordY, BasePiece.PieceColor.BLACK);
                    }
                }

                //Can another piece kill a dangerous piece? Are you safe then?
                //Compare all dangerous moves from the enemy color with your pieces possible moves and re-check with the new ArrayList if the piece
                //would get removed
                if(gameOverWhite) {
                    gameOverWhite = canCheckmateBeRemovedByAnotherPiece(gameOverWhite, BasePiece.PieceColor.BLACK);
                }


                if (gameOverWhite) {
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

                //Can the king free itself?
                for (MoveCoordinates kingMove : kingMoves) {
                    if (gameOverBlack) {
                        gameOverBlack = simulateKingMove(kingMove.cordX, kingMove.cordY, BasePiece.PieceColor.WHITE);
                    }
                }

                //Can another piece kill a dangerous piece? Are you safe then?
                //Compare all dangerous moves from the enemy color with your pieces possible moves and re-check with the new ArrayList if the piece
                //would get removed
                if(gameOverBlack) {
                    gameOverBlack = canCheckmateBeRemovedByAnotherPiece(gameOverBlack, BasePiece.PieceColor.WHITE);
                }

                if (gameOverBlack) {
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

    private static boolean simulateKingMove(int kingX, int kingY, BasePiece.PieceColor enemyColor) {
        boolean checkmate = true;

        ArrayList<MoveCoordinates> dangerousSquares = enemyColor == BasePiece.PieceColor.WHITE ? DangerousSquaresWhite : DangerousSquaresBlack;

        if (squares[kingX][kingY].currentPiece == null && !dangerousSquares.stream().anyMatch(x -> x.cordX == kingX && x.cordY == kingY)) {
            checkmate = false;
        } else if (squares[kingX][kingY].currentPiece != null) {
            MoveCoordinates pieceToRemove = new MoveCoordinates(kingX, kingY);
            //Backup and remove the piece temporarily
            BasePiece backupPieceDestination = squares[kingX][kingY].currentPiece;
            squares[kingX][kingY].currentPiece = null;
            setDangerousSquaresTheoretical(pieceToRemove, enemyColor, false);
            ArrayList<MoveCoordinates> dangerousSquaresTheoretical = enemyColor == BasePiece.PieceColor.WHITE ? DangerousSquaresWhiteTheoretical : DangerousSquaresBlackTheoretical;

            if (!dangerousSquaresTheoretical.stream().anyMatch(x -> x.cordX == kingX && x.cordY == kingY)) {
                checkmate = false;
            } else {
                checkmate = true;
            }

            //return the piece to original position
            squares[kingX][kingY].currentPiece = backupPieceDestination;
        }

        return checkmate;
    }

    private static boolean canCheckmateBeRemovedByAnotherPiece(boolean gameOver, BasePiece.PieceColor enemyColor) {
        ArrayList<MoveCoordinates> enemyPiecesCords = new ArrayList<>();
        BasePiece.PieceColor defenderColor = enemyColor == BasePiece.PieceColor.WHITE ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;

        //Remove one piece at a time and check if king would be safe if it is removed (and can be removed)
        setDangerousSquaresTheoretical(null, defenderColor, true);
        ArrayList<MoveCoordinates> dangerousSquaresTheoreticalDefender = enemyColor == BasePiece.PieceColor.WHITE ? DangerousSquaresBlackTheoretical : DangerousSquaresWhiteTheoretical;

        for (MoveCoordinates x : dangerousSquaresTheoreticalDefender) {
            Square currentSquare = squares[x.cordX][x.cordY];
            if (currentSquare.currentPiece != null && currentSquare.currentPiece.color == enemyColor) {
                enemyPiecesCords.add(x);
            }
        }

        if (enemyPiecesCords.stream().count() > 0) {
            for (MoveCoordinates enemyPiece : enemyPiecesCords) {
//                BasePiece backupPieceDestination = squares[enemyPiece.cordX][enemyPiece.cordY].currentPiece;
//                squares[enemyPiece.cordX][enemyPiece.cordY].currentPiece = null;

                //Remove one piece at a time and check if king would be safe if it is removed (and can be removed)
                setDangerousSquaresTheoretical(enemyPiece, enemyColor, true);
                ArrayList<MoveCoordinates> dangerousSquaresTheoreticalAttacker = enemyColor == BasePiece.PieceColor.WHITE ? DangerousSquaresWhiteTheoretical : DangerousSquaresBlackTheoretical;

                //Is king safe now?
                BasePiece.PieceColor kingToCheck = enemyColor == BasePiece.PieceColor.WHITE ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;

                int kingX = kingToCheck == BasePiece.PieceColor.BLACK ? KingBlack.cordX : KingWhite.cordX;
                int kingY = kingToCheck == BasePiece.PieceColor.BLACK ? KingBlack.cordY : KingWhite.cordY;

                if (!dangerousSquaresTheoreticalAttacker.stream().anyMatch(x -> x.cordX == kingX && x.cordY == kingY)) {
                    gameOver = false;
                } else {
                    gameOver = true;
                }

                //return the piece to original position
//                squares[enemyPiece.cordX][enemyPiece.cordY].currentPiece = backupPieceDestination;
            }
        }

        return gameOver;
    }

    private static void setDangerousSquares() {
        setAllAttackMoves();
    }

    private static void setDangerousSquaresTheoretical(MoveCoordinates pieceToRemove, BasePiece.PieceColor color, boolean withoutKing) {
        DangerousSquaresWhiteTheoretical = new ArrayList<>();
        DangerousSquaresBlackTheoretical = new ArrayList<>();
        setAllAttackMovesTheoretical(pieceToRemove, color, withoutKing);
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

    //Not implemented
    public static void putPieceInCaughtSet(BasePiece piece) {
        if (piece.color == BasePiece.PieceColor.WHITE) {
            CaughtWhitePieces.add(piece);
        } else {
            CaughtBlackPieces.add(piece);
        }
    }
}
