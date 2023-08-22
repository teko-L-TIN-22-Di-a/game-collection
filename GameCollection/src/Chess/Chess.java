package Chess;

import Chess.util.Chessboard;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Chess extends JFrame {
    public static Chessboard chessboard;
    public static JFrame mainFrame;

    public static void main() {
        mainFrame = new JFrame("Chess");
        chessboard = new Chessboard();

        mainFrame.add(chessboard.getGUI());
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(mainFrame.getSize());
        mainFrame.setVisible(true);
    }
}
