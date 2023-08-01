package Chess.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import static Chess.util.Chessboard.squares;

public class ResizeListener extends ComponentAdapter {
    public void componentResized(ComponentEvent e) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(squares[x][y].currentPiece != null) {
                    Component squarePanel = squares[x][y].squarePanel;
                    int panelWidth = squarePanel.getWidth();
                    int panelHeight = squarePanel.getHeight();
                    JLabel iconLabel = squares[x][y].currentPiece.pieceIcon;
                    ImageIcon pieceIcon = (ImageIcon)iconLabel.getIcon();
                    Image image = pieceIcon.getImage();

                    image = image.getScaledInstance(panelWidth-20, panelHeight-20, Image.SCALE_SMOOTH);
                    iconLabel.setIcon(new ImageIcon(image));
                }
            }
        }
    }
}
