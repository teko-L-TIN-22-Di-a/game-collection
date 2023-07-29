package ch.teko.loefflee;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Buttons extends javax.swing.JFrame {

    public Buttons() {
        initComponents();
    }

    private GameBoard gameBoard = new GameBoard();

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        if (ButtonTL.getText() == "") {
            ButtonTL.setText("X");
            placePiece(gameBoard.gameBoard, 1, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonTLActionPerformed

    private void ButtonTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTMActionPerformed
        if (ButtonTM.getText() == "") {
            ButtonTM.setText("X");
            placePiece(gameBoard.gameBoard, 2, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonTMActionPerformed

    private void ButtonTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTRActionPerformed
        if (ButtonTR.getText() == "") {
            ButtonTR.setText("X");
            placePiece(gameBoard.gameBoard, 3, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonTRActionPerformed

    private void ButtonMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMLActionPerformed
        if (ButtonML.getText() == "") {
            ButtonML.setText("X");
            placePiece(gameBoard.gameBoard, 4, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonMLActionPerformed

    private void ButtonMMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMMActionPerformed
        if (ButtonMM.getText() == "") {
            ButtonMM.setText("X");
            placePiece(gameBoard.gameBoard, 5, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonMMActionPerformed

    private void ButtonMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMRActionPerformed
        if (ButtonMR.getText() == "") {
            ButtonMR.setText("X");
            placePiece(gameBoard.gameBoard, 6, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonMRActionPerformed

    private void ButtonBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBLActionPerformed
        if (ButtonBL.getText() == "") {
            ButtonBL.setText("X");
            placePiece(gameBoard.gameBoard, 7, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonBLActionPerformed

    private void ButtonBMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBMActionPerformed
        if (ButtonBM.getText() == "") {
            ButtonBM.setText("X");
            placePiece(gameBoard.gameBoard, 8, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonBMActionPerformed

    private void ButtonBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBRActionPerformed
        if (ButtonBR.getText() == "") {
            ButtonBR.setText("X");
            placePiece(gameBoard.gameBoard, 9, "player");
            gameState result = checkWinner();
            cpuPosition();
            result = checkWinner();
        }
    }//GEN-LAST:event_ButtonBRActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Buttons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buttons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buttons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buttons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buttons().setVisible(true);
            }
        });
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
                ButtonTL.setText(String.valueOf(symbol));
                ButtonTL.setBackground(color);
                break;

            case 2:
                gameBoard[0][1] = symbol;
                ButtonTM.setText(String.valueOf(symbol));
                ButtonTM.setBackground(color);
                break;

            case 3:
                gameBoard[0][2] = symbol;
                ButtonTR.setText(String.valueOf(symbol));
                ButtonTR.setBackground(color);
                break;

            case 4:
                gameBoard[1][0] = symbol;
                ButtonML.setText(String.valueOf(symbol));
                ButtonML.setBackground(color);
                break;

            case 5:
                gameBoard[1][1] = symbol;
                ButtonMM.setText(String.valueOf(symbol));
                ButtonMM.setBackground(color);
                break;

            case 6:
                gameBoard[1][2] = symbol;
                ButtonMR.setText(String.valueOf(symbol));
                ButtonMR.setBackground(color);
                break;

            case 7:
                gameBoard[2][0] = symbol;
                ButtonBL.setText(String.valueOf(symbol));
                ButtonBL.setBackground(color);
                break;

            case 8:
                gameBoard[2][1] = symbol;
                ButtonBM.setText(String.valueOf(symbol));
                ButtonBM.setBackground(color);
                break;

            case 9:
                gameBoard[2][2] = symbol;
                ButtonBR.setText(String.valueOf(symbol));
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
                return gameState.player;
            } else if (cpuPositions.containsAll(l)) {
                return gameState.cpu;
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
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
