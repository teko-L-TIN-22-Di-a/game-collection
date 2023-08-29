package Mainmenu;

import Chess.util.Chessboard;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
    public static JFrame mainFrame;
    public static JLabel title = new JLabel("GAME COLLECTION");
    private static final JPanel gui = new JPanel(new BorderLayout(3, 3));

    public static void main(String[] args) {
        mainFrame = new JFrame("Game Collection");
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(title);

        JButton buttonChess = new JButton("Chess");
        buttonChess.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chess.Chess.main();
            }
        });

        tools.add(buttonChess); // TODO - add functionality!
        tools.addSeparator();

        JButton buttonTicTacToe = new JButton("Tic Tac Toe");
        buttonTicTacToe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.teko.loefflee.Buttons.main();
            }
        });
        tools.add(buttonTicTacToe); // TODO - add functionality!
        mainFrame.add(gui);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(mainFrame.getSize());
        mainFrame.setVisible(true);
    }
}
