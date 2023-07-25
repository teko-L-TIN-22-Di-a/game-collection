package Chess;

import Chess.util.Chessboard;
import javax.swing.*;

public class Chess extends JFrame {
    public static Chessboard chessboard;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
        chessboard = new Chessboard();

        frame.add(chessboard.getChessboard());
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
