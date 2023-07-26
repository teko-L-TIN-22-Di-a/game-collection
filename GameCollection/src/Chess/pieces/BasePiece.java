package Chess.pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BasePiece {
    public enum PieceColor {
        WHITE, BLACK
    }

    public static final int SQUARE_DIMENSION = 50;
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
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_king_1x.png");
                break;
            case Pawn:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_pawn_1x.png");
                break;
            case Rook:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_rook_1x.png");
                break;
            case Queen:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_queen_1x.png");
                break;
            case Bishop:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_bishop_1x.png");
                break;
            case Knight:
                this.pieceIcon = this.createImage("GameCollection/src/Chess/assets/" + colorString + "_knight_1x.png");
                break;
        }
    }

    public JLabel createImage(String path) {
        try {
            Image pieceImage = new ImageIcon(path).getImage();
            pieceImage = pieceImage.getScaledInstance(SQUARE_DIMENSION, SQUARE_DIMENSION, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(pieceImage));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            throw null;
        }
    }
}
