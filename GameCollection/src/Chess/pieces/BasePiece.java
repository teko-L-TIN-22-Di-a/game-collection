package Chess.pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BasePiece {
    public enum PieceColor {
        WHITE, BLACK
    }

    public static final int SQUARE_DIMENSION = 60;
    public PieceEnum pieceType;
    public JLabel pieceIcon;
    public PieceColor color;

    public BasePiece() {
    }

    public BasePiece(PieceEnum type, PieceColor color) {
        this.initBasePiece(type, color);
    }

    public void initBasePiece(PieceEnum type, PieceColor color) {
        this.color = color;
        this.pieceType = type;
        String colorString = color == PieceColor.WHITE ? "w" : "b";

        switch (type) {
            case King:
                //init image
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_king_2x.png");
                break;
            case Pawn:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_pawn_2x.png");
                break;
            case Rook:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_rook_2x.png");
                break;
            case Queen:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_queen_2x.png");
                break;
            case Bishop:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_bishop_2x.png");
                break;
            case Knight:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_knight_2x.png");
                break;
        }
    }

    public JLabel createImage(String path) {
        try {
            Image pieceImage = new ImageIcon(path).getImage();
            pieceImage = pieceImage.getScaledInstance(SQUARE_DIMENSION, SQUARE_DIMENSION, Image.SCALE_SMOOTH);
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(pieceImage));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            return label;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            throw null;
        }
    }
}
