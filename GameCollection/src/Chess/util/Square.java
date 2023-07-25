package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Chess.util.Chessboard.getSquares;


public class Square implements MouseListener {
    public JPanel squarePanel;
    public BasePiece currentPiece;
    public int coordinateX;
    public int coordinateY;

    public Square(int row, int col) {
        this.initSquare(null, null, row, col);
    }

    public Square(PieceEnum type, BasePiece.PieceColor color, int row, int col) {
        this.initSquare(type, color, row, col);
    }

    public void initSquare(PieceEnum type, BasePiece.PieceColor color, int row, int col) {
        this.coordinateX = row;
        this.coordinateY = col;

        this.squarePanel = new JPanel();
        this.squarePanel.addMouseListener(this);

        this.squarePanel.setAlignmentX(JLabel.CENTER);
        this.squarePanel.setAlignmentY(JLabel.CENTER);

        this.currentPiece = type != null ? new BasePiece(type, color) : null;

        Border squareBorder = BorderFactory.createLineBorder(Color.black);
        this.squarePanel.setBorder(squareBorder);

        if (currentPiece != null) {
            this.squarePanel.add(currentPiece.pieceIcon, "push, align center");
        }
    }

    public void setBackgroundSquare(Color color) {
        this.squarePanel.setBackground(color);
    }

    public void showPossibleMoves() {
        var squares = getSquares();
        if (squares[this.coordinateX][this.coordinateY].currentPiece != null) {
            if (squares[this.coordinateX][this.coordinateY].currentPiece.color == BasePiece.PieceColor.BLACK) {
                squares[this.coordinateX + 1][this.coordinateY].setBackgroundSquare(Color.red);
            } else {
                squares[this.coordinateX - 1][this.coordinateY].setBackgroundSquare(Color.red);
            }
        }
    }

    public void removePossibleMoves() {
        var squares = getSquares();
        if (squares[this.coordinateX][this.coordinateY].currentPiece != null) {
            if (squares[this.coordinateX][this.coordinateY].currentPiece.color == BasePiece.PieceColor.BLACK) {
                squares[this.coordinateX + 1][this.coordinateY].setBackgroundSquare(Color.red);
            } else {
                squares[this.coordinateX - 1][this.coordinateY].setBackgroundSquare(Color.red);
            }
        }
    }

    public void initMove() {
        new Move(this.coordinateX, this.coordinateY, this.currentPiece);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.initMove();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        var squares = getSquares();

        if (squares[Move.currentX][Move.currentY].squarePanel.getComponents().length > 0 && Move.validMove()) {
            JPanel originalPanel = squares[Move.currentX][Move.currentY].squarePanel;
            JPanel destinationPanel = squares[Move.newX][Move.newY].squarePanel;
            destinationPanel.removeAll();
            destinationPanel.add(originalPanel.getComponent(0));
            destinationPanel.repaint();
            originalPanel.removeAll();
            originalPanel.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Move.setNewCoordinates(this.coordinateX, this.coordinateY);
//        System.out.println("New Coordinates: " + this.coordinateX + " " + this.coordinateY);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (this.currentPiece != null) {
//            this.currentPiece.emptyPiece();
//        }
    }

}