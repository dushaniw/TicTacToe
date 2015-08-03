/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Uer
 */
public class MainMenu extends javax.swing.JFrame {
      /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setLocation((dim.width - jLabel4.getWidth())/2, (dim.height - jLabel4.getHeight())/2);
        setSize(jLabel4.getWidth()-20, jLabel4.getHeight()-40);
        
        
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        multiPlayer = new javax.swing.JButton();
        singlePlayer = new javax.swing.JButton();
        leaderboard = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Cooper Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 0));
        jLabel1.setText("TicTacToe ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 160, 332, 41);

        multiPlayer.setBackground(new java.awt.Color(255, 255, 153));
        multiPlayer.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        multiPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/multPlayer.jpg"))); // NOI18N
        multiPlayer.setText("Multi Player");
        multiPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiPlayerActionPerformed(evt);
            }
        });
        getContentPane().add(multiPlayer);
        multiPlayer.setBounds(180, 370, 430, 70);

        singlePlayer.setBackground(new java.awt.Color(255, 255, 153));
        singlePlayer.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        singlePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/singleplayer.jpg"))); // NOI18N
        singlePlayer.setText("Single Player");
        singlePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlePlayerActionPerformed(evt);
            }
        });
        getContentPane().add(singlePlayer);
        singlePlayer.setBounds(190, 240, 410, 60);

        leaderboard.setBackground(new java.awt.Color(255, 255, 153));
        leaderboard.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        leaderboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/leaderboard.jpg"))); // NOI18N
        leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardActionPerformed(evt);
            }
        });
        getContentPane().add(leaderboard);
        leaderboard.setBounds(180, 520, 430, 60);

        exit.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/exitBtn.jpg"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(460, 690, 140, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/menue.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 780, 810);
        jLabel4.getAccessibleContext().setAccessibleName("jLabel4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderboardActionPerformed
        DB db = new DB();
        db.connectLocal();
        LeaderBoardHandler_SinglePlayer sup1 = new LeaderBoardHandler_SinglePlayer(db);
        LeaderBoardHandler_MultiPlayer sup2 = new LeaderBoardHandler_MultiPlayer(db);
        LeaderBoard b1 = new LeaderBoard();
        b1.setSup(sup1,sup2);
        b1.show();
        this.dispose();

    }//GEN-LAST:event_leaderboardActionPerformed

    private void singlePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayerActionPerformed
        SingleUserInfo singlePlay = new SingleUserInfo();
        singlePlay.show();
        this.dispose();
    }//GEN-LAST:event_singlePlayerActionPerformed

    private void multiPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiPlayerActionPerformed
        MultiplayerUserInfo multiPlay = new MultiplayerUserInfo();
        multiPlay.show();
        this.dispose();
    }//GEN-LAST:event_multiPlayerActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton leaderboard;
    private javax.swing.JButton multiPlayer;
    private javax.swing.JButton singlePlayer;
    // End of variables declaration//GEN-END:variables
}
