package Chess;

import Chess.util.Chessboard;
import javax.swing.*;

public class Chess extends JFrame {
    public static Chessboard chessboard;
    public static JFrame mainFrame;

    public static void main(String[] args) {
        mainFrame = new JFrame("Chess");
        chessboard = new Chessboard();

        mainFrame.add(chessboard.getChessboard());
        mainFrame.setSize(700,700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
