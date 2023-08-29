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
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.setMinimumSize(mainFrame.getSize());
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(mainFrame,
                        "Are you sure you want to close the game?", "Close Game?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

    }
}
