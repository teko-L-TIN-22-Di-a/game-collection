package Chess.util;

import Chess.pieces.BasePiece;
import Chess.pieces.PieceEnum;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Chessboard extends JPanel {
    public static int rows = 8;
    public static int cols = 8;
    public static JPanel chessboard = new JPanel() {
        @Override
        public final Dimension getPreferredSize() {
            Dimension d = super.getPreferredSize();
            Dimension prefSize = null;
            Component c = getParent();
            if (c == null) {
                prefSize = new Dimension(
                        (int)d.getWidth(),(int)d.getHeight());
            } else if (c!=null &&
                    c.getWidth()>d.getWidth() &&
                    c.getHeight()>d.getHeight()) {
                prefSize = c.getSize();
            } else {
                prefSize = d;
            }
            int w = (int) prefSize.getWidth();
            int h = (int) prefSize.getHeight();
            // the smaller of the two sizes
            int s = (w>h ? h : w);
            return new Dimension(s,s);
        }
    };
    public static Square[][] squares = new Square[rows][cols];


    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    public static JLabel message = new JLabel(
            "WHITE's turn");

    public static JLabel gameStateMessageWhite = new JLabel("");
    public static JLabel gameStateMessageBlack = new JLabel("");

    public final void initializeGui() {
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(message);
        tools.addSeparator();
        tools.add(gameStateMessageWhite);
        tools.addSeparator();
        tools.add(gameStateMessageBlack);

    }

    public Chessboard() {
        initChessboard();
        initializeGui();
    }

    public void initChessboard() {
        initGameState();
        chessboard.setLayout(new GridLayout(8,8));
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        Color ochre = new Color(204,119,34);
        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessboard);
        gui.add(boardConstrain);

        boardConstrain.addComponentListener(new ResizeListener());


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                initPieces(row, col);

                if ((row % 2 == 0 && col % 2 != 0) || (row % 2 != 0 && col % 2 == 0)) {
                    squares[row][col].setBackgroundSquare(Color.black);
                } else {
                    squares[row][col].setBackgroundSquare(Color.white);
                }

                chessboard.add(squares[row][col].squarePanel);
            }
        }
    }

    private void initGameState() {
        GameState.initGameState();
    }

    public void initPieces(int row, int col) {
        if (row == 0 || row == 7) {
            BasePiece.PieceColor color = row == 0 ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;
            if (col == 0) {
                squares[row][col] = new Square(PieceEnum.Rook, color, row, col);
            } else if (col == 1) {
                squares[row][col] = new Square(PieceEnum.Knight, color, row, col);
            } else if (col == 2) {
                squares[row][col] = new Square(PieceEnum.Bishop, color, row, col);
            } else if (col == 3) {
                squares[row][col] = new Square(PieceEnum.Queen, color, row, col);
            } else if (col == 4) {
                squares[row][col] = new Square(PieceEnum.King, color, row, col);
            } else if (col == 5) {
                squares[row][col] = new Square(PieceEnum.Bishop, color, row, col);
            } else if (col == 6) {
                squares[row][col] = new Square(PieceEnum.Knight, color, row, col);
            } else if (col == 7) {
                squares[row][col] = new Square(PieceEnum.Rook, color, row, col);
            }
        } else if (row == 1 || row == 6) {
            BasePiece.PieceColor color = row == 1 ? BasePiece.PieceColor.BLACK : BasePiece.PieceColor.WHITE;
            squares[row][col] = new Square(PieceEnum.Pawn, color, row, col);
        } else {
            squares[row][col] = new Square(row, col);
        }
    }

    public JPanel getChessboard() {
        return chessboard;
    }

    public JPanel getGUI() {
        return gui;
    }

    public static Square[][] getSquares() {
        return squares;
    }
}
