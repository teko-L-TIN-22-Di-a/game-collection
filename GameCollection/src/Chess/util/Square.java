package Chess.util;

import Chess.pieces.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

        this.currentPiece = type != null ?
                switch (type) {
                    case Bishop -> new Bishop(type, color);
                    case King -> new King(type, color);
                    case Pawn -> new Pawn(type, color);
                    case Rook -> new Rook(type, color);
                    case Queen -> new Queen(type, color);
                    case Knight -> new Knight(type, color);
                } : null;

        Border squareBorder = BorderFactory.createLineBorder(Color.black);
        this.squarePanel.setBorder(squareBorder);

        if (currentPiece != null) {
            this.squarePanel.add(currentPiece.pieceIcon, "push, align center");
        }

    }

    public void setBackgroundSquare(Color color) {
        this.squarePanel.setBackground(color);
    }

    public void showPossibleMoves(ArrayList<MoveCoordinates> moveList) {
        var squares = getSquares();

        for (int i = 0; i < moveList.size(); i++) {
            squares[moveList.get(i).cordX][moveList.get(i).cordY].squarePanel.setBorder(BorderFactory.createLineBorder(Color.red));
        }
    }

    public void removePossibleMoves(ArrayList<MoveCoordinates> moveList) {
        var squares = getSquares();
        for (int i = 0; i < moveList.size(); i++) {
            squares[moveList.get(i).cordX][moveList.get(i).cordY].squarePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }

    public void initMove() {
        new Move(this.coordinateX, this.coordinateY, this.currentPiece);
        showPossibleMoves(Move.getPossibleMoves());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.currentPiece != null) {
            this.initMove();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        var squares = getSquares();
        removePossibleMoves(Move.getPossibleMoves());

        if (squares[Move.currentCords.cordX][Move.currentCords.cordY].squarePanel.getComponents().length > 0 && Move.validMove()) {
            Square originalSquare = squares[Move.currentCords.cordX][Move.currentCords.cordY];
            Square destinationSquare = squares[Move.newCords.cordX][Move.newCords.cordY];
            destinationSquare.squarePanel.removeAll();
            destinationSquare.squarePanel.add(originalSquare.squarePanel.getComponent(0));
            destinationSquare.squarePanel.repaint();
            originalSquare.squarePanel.removeAll();
            originalSquare.squarePanel.repaint();
            destinationSquare.currentPiece = originalSquare.currentPiece;
            originalSquare.currentPiece = null;
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