package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Chessboard extends JPanel {
    public static int rows = 8;
    public static int cols = 8;
    public static JPanel chessboard = new JPanel();
    public static Square[][] squares = new Square[rows][cols];

    public Chessboard() {
        drawChessboard();
    }

    public void drawChessboard() {
        chessboard.setLayout(new GridLayout(rows, rows));

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                initPieces(row, col);

                if ((row % 2 == 0 && col % 2 != 0) || (row % 2 != 0 && col % 2 == 0)) {
                    squares[row][col].setBackgroundSquare(Color.black);
                } else {
                    squares[row][col].setBackgroundSquare(Color.white);
                }

                chessboard.add(squares[row][col].squarePanel);
            }
        }
    }

    public void initPieces(int row, int col) {
        if (row == 0 || row == 7) {
            BasePiece.PieceColor color = row == 0 ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;
            if (col == 0) {
                squares[row][col] = new Square(PieceEnum.Rook, color, row, col);
            } else if (col == 1) {
                squares[row][col] = new Square(PieceEnum.Knight, color, row, col);
            } else if (col == 2) {
                squares[row][col] = new Square(PieceEnum.Bishop, color, row, col);
            } else if (col == 3) {
                squares[row][col] = new Square(PieceEnum.Queen, color, row, col);
            } else if (col == 4) {
                squares[row][col] = new Square(PieceEnum.King, color, row, col);
            } else if (col == 5) {
                squares[row][col] = new Square(PieceEnum.Bishop, color, row, col);
            } else if (col == 6) {
                squares[row][col] = new Square(PieceEnum.Knight, color, row, col);
            } else if (col == 7) {
                squares[row][col] = new Square(PieceEnum.Rook, color, row, col);
            }
        } else if(row == 1 || row == 6) {
            BasePiece.PieceColor color = row == 1 ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;
            squares[row][col] = new Square(PieceEnum.Pawn, color, row, col);
        } else {
            squares[row][col] = new Square(row, col);
        }
    }

//    private JLabel getPieceImageLabel(BasePiece piece) {
//        Image pieceImage = new ImageIcon(getClass().getResource(piece.getImageFileName())).getImage();
//        pieceImage = pieceImage.getScaledInstance(SQUARE_DIMENSION, SQUARE_DIMENSION, Image.SCALE_SMOOTH);
//        JLabel pieceImageLabel = new JLabel(new ImageIcon(pieceImage));
//        return pieceImageLabel;
//    }

    public JPanel getChessboard() {
        return chessboard;
    }

    public static Square[][] getSquares() {
        return squares;
    }
}
