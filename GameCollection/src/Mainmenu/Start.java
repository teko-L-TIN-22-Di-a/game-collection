package Mainmenu;

import Chess.util.Chessboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
    public static JFrame mainFrame;
    public static JPanel titlePanel = new JPanel();
    public static JPanel buttonPanel = new JPanel();
    private static JPanel gui = new JPanel();
    private static JButton buttonChess = new JButton("Chess");
    private static JButton buttonTicTacToe = new JButton("Tic Tac Toe");
    private static  JLabel titleLabel;

    public static void main(String[] args) {
        mainFrame = new JFrame("Game Collection");
        new GroupLayout(gui);

        titleLabel = new JLabel();
        titleLabel.setText("Select the game to play");

        buttonTicTacToe.setPreferredSize(new Dimension(100,100));
        buttonChess.setPreferredSize(new Dimension(100,100));

        buttonChess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chess.Chess.main();
            }
        });
        buttonTicTacToe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.teko.loefflee.Buttons.main();
            }
        });

        titlePanel.add(titleLabel);
        buttonPanel.add(buttonTicTacToe);
        buttonPanel.add(buttonChess);

        gui.add(titlePanel, "Title");
        gui.add(buttonPanel, "Button");


        mainFrame.add(gui);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(mainFrame.getSize());
        mainFrame.setVisible(true);
    }
}
