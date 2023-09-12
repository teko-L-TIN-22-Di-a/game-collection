package ch.teko.loefflee;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;

public class Buttons extends javax.swing.JFrame {

    static String winMessage = "";

    static boolean exit = true;

    public Buttons() {
        initComponents();
    }

    private GameBoard gameBoard = new GameBoard();

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        playerPositions = new ArrayList<Integer>();
        cpuPositions = new ArrayList<Integer>();
        ButtonBack = new javax.swing.JPanel();
        ButtonTL = new javax.swing.JButton();
        ButtonTR = new javax.swing.JButton();
        ButtonTM = new javax.swing.JButton();
        ButtonML = new javax.swing.JButton();
        ButtonMR = new javax.swing.JButton();
        ButtonMM = new javax.swing.JButton();
        ButtonBL = new javax.swing.JButton();
        ButtonBR = new javax.swing.JButton();
        ButtonBM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTLActionPerformed(evt);
            }
        });

        ButtonTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTRActionPerformed(evt);
            }
        });

        ButtonTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTMActionPerformed(evt);
            }
        });

        ButtonML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMLActionPerformed(evt);
            }
        });

        ButtonMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMRActionPerformed(evt);
            }
        });

        ButtonMM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMMActionPerformed(evt);
            }
        });

        ButtonBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBLActionPerformed(evt);
            }
        });

        ButtonBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBRActionPerformed(evt);
            }
        });

        ButtonBM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonBackLayout = new javax.swing.GroupLayout(ButtonBack);
        ButtonBack.setLayout(ButtonBackLayout);
        ButtonBackLayout.setHorizontalGroup(
            ButtonBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonBackLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(ButtonBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ButtonBackLayout.createSequentialGroup()
                        .addComponent(ButtonBL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ButtonBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ButtonBackLayout.createSequentialGroup()
                            .addComponent(ButtonML, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonMM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonMR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ButtonBackLayout.createSequentialGroup()
                            .addComponent(ButtonTL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonTM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonTR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        ButtonBackLayout.setVerticalGroup(
            ButtonBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonBackLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(ButtonBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonTM, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(ButtonTR, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(ButtonTL, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(ButtonBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonMM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonMR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonML, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ButtonBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonBM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 526, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTLActionPerformed
        setMove(ButtonTL, 1);
    }//GEN-LAST:event_ButtonTLActionPerformed

    private void ButtonTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTMActionPerformed
        setMove(ButtonTM, 2);
    }//GEN-LAST:event_ButtonTMActionPerformed

    private void ButtonTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTRActionPerformed
        setMove(ButtonTR, 3);
    }//GEN-LAST:event_ButtonTRActionPerformed

    private void ButtonMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMLActionPerformed
        setMove(ButtonML, 4);
    }//GEN-LAST:event_ButtonMLActionPerformed

    private void ButtonMMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMMActionPerformed
        setMove(ButtonMM, 5);
    }//GEN-LAST:event_ButtonMMActionPerformed

    private void ButtonMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMRActionPerformed
        setMove(ButtonMR, 6);
    }//GEN-LAST:event_ButtonMRActionPerformed

    private void ButtonBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBLActionPerformed
        setMove(ButtonBL, 7);
    }//GEN-LAST:event_ButtonBLActionPerformed

    private void ButtonBMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBMActionPerformed
        setMove(ButtonBM, 8);
    }//GEN-LAST:event_ButtonBMActionPerformed

    private void ButtonBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBRActionPerformed
        setMove(ButtonBR, 9);
    }//GEN-LAST:event_ButtonBRActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main() {
        new Buttons().setVisible(true);
    }

    public void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        var color = Color.LIGHT_GRAY;

        if (user.equals("player")) {
            symbol = 'X';
            color = Color.red;
            playerPositions.add(pos);

        } else if (user.equals("cpu")) {
            symbol = 'O';
            color = Color.blue;
            cpuPositions.add(pos);

        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                ButtonTL.setBackground(color);
                break;

            case 2:
                gameBoard[0][1] = symbol;
                ButtonTM.setBackground(color);
                break;

            case 3:
                gameBoard[0][2] = symbol;
                ButtonTR.setBackground(color);
                break;

            case 4:
                gameBoard[1][0] = symbol;
                ButtonML.setBackground(color);
                break;

            case 5:
                gameBoard[1][1] = symbol;
                ButtonMM.setBackground(color);
                break;

            case 6:
                gameBoard[1][2] = symbol;
                ButtonMR.setBackground(color);
                break;

            case 7:
                gameBoard[2][0] = symbol;
                ButtonBL.setBackground(color);
                break;

            case 8:
                gameBoard[2][1] = symbol;
                ButtonBM.setBackground(color);
                break;

            case 9:
                gameBoard[2][2] = symbol;
                ButtonBR.setBackground(color);
                break;
        }
    }

    private void cpuPosition() {
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
            cpuPos = rand.nextInt(9) + 1;
        }
        placePiece(gameBoard.gameBoard, cpuPos, "cpu");

    }

    public static gameState checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCollumn = Arrays.asList(1, 4, 7);
        List midCollumn = Arrays.asList(2, 5, 8);
        List rightCollumn = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCollumn);
        winning.add(midCollumn);
        winning.add(rightCollumn);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                winMessage = "Congratulations, you won!";
                return gameState.player;
            } else if (cpuPositions.containsAll(l)) {
                winMessage = "Game over!";
                return gameState.cpu;
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                winMessage = "Tie!";
                return gameState.tie;
            }
        }

        return gameState.none;
    }

    enum gameState {
        player,
        cpu,
        tie,
        none;
    }

    private static void checkResult() {
        /*   if (gameState.player) {
            return
        } else if (gameState.cpu) {

        } else if (gameState.tie) {

        }*/
    }

    private void setMove(JButton button, int coord) {
        if (!playerPositions.stream().anyMatch(x -> x == coord) && !cpuPositions.stream().anyMatch(y -> y == coord)) {
            placePiece(gameBoard.gameBoard, coord, "player");
            gameState result = checkWinner();
            if (result == gameState.none) {
                cpuPosition();
                result = checkWinner();
            }

            if (result != gameState.none) {
                String[] options = {"Replay", "Exit"};
                var selection = JOptionPane.showOptionDialog(null,
                        winMessage,
                        "Game has ended",
                        0, 3, null, options, options[0]);
                if (selection == 0) {
                    RestartGame();
                }
                if (selection == 1 || selection == -1) {
                    dispose();
                    //Hauptmenü öffnen
                }
            }
        }
    }

    private void RestartGame() {
        gameBoard = new GameBoard();
        var color = Color.LIGHT_GRAY;
        ButtonTL.setBackground(color);
        ButtonTM.setBackground(color);
        ButtonTR.setBackground(color);
        ButtonML.setBackground(color);
        ButtonMM.setBackground(color);
        ButtonMR.setBackground(color);
        ButtonBL.setBackground(color);
        ButtonBM.setBackground(color);
        ButtonBR.setBackground(color);
        cpuPositions = new ArrayList<Integer>();
        playerPositions = new ArrayList<Integer>();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBL;
    private javax.swing.JButton ButtonBM;
    private javax.swing.JButton ButtonBR;
    private javax.swing.JPanel ButtonBack;
    private javax.swing.JButton ButtonML;
    private javax.swing.JButton ButtonMM;
    private javax.swing.JButton ButtonMR;
    private javax.swing.JButton ButtonTL;
    private javax.swing.JButton ButtonTM;
    private javax.swing.JButton ButtonTR;
    // End of variables declaration//GEN-END:variables
}
