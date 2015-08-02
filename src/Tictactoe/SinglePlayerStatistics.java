/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Uer
 */
public class SinglePlayerStatistics extends javax.swing.JFrame {
    LeaderBoardHandler_SinglePlayer sup;
    /**
     * Creates new form SinglePlayerStatistics
     */
    public SinglePlayerStatistics() {
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setLocation((dim.width - jLabel6.getWidth())/2, (dim.height - jLabel6.getHeight())/2);
        setSize(jLabel6.getWidth(), jLabel6.getHeight());
    }

    public void setSup(LeaderBoardHandler_SinglePlayer sup){
        this.sup=sup;
        player.setText((String)String.valueOf(sup.getName()));
        wins.setText((String) String.valueOf(sup.getWins()));
        losses.setText((String) String.valueOf(sup.getLosses()));
        ties.setText((String) String.valueOf(sup.getTied()));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        player = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        losses = new javax.swing.JTextField();
        wins = new javax.swing.JTextField();
        exit = new javax.swing.JButton();
        ties = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("Player Statistics - Single Player Mode");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 10, 460, 42);

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Total Wins");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 200, 110, 30);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Total Losses");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 200, 120, 30);

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Player Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 130, 22);

        player.setEditable(false);
        player.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        player.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(player);
        player.setBounds(170, 110, 310, 40);

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("Total Ties");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 200, 100, 30);

        losses.setEditable(false);
        losses.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        losses.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(losses);
        losses.setBounds(240, 240, 70, 50);

        wins.setEditable(false);
        wins.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        wins.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(wins);
        wins.setBounds(60, 240, 70, 50);

        exit.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(51, 204, 0));
        exit.setText("Exit");
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(440, 340, 140, 40);

        ties.setEditable(false);
        ties.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ties.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(ties);
        ties.setBounds(440, 240, 70, 50);

        jLabel6.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 598, 473);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(SinglePlayerStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinglePlayerStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinglePlayerStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinglePlayerStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinglePlayerStatistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField losses;
    private javax.swing.JTextField player;
    private javax.swing.JTextField ties;
    private javax.swing.JTextField wins;
    // End of variables declaration//GEN-END:variables
}
