/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Uer
 */
public class MultiplayerUserInfo extends javax.swing.JFrame {

    /**
     * Creates new form MultiplayerUserInfo
     */
    public MultiplayerUserInfo() {
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

        player1Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        play = new javax.swing.JButton();
        player2Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        player1Name.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        player1Name.setForeground(new java.awt.Color(0, 102, 0));
        player1Name.setText("Player1");
        getContentPane().add(player1Name);
        player1Name.setBounds(190, 110, 310, 50);

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Player1");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 110, 80, 50);

        back.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(51, 204, 0));
        back.setText("Back");
        back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(190, 300, 180, 40);

        play.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        play.setForeground(new java.awt.Color(51, 204, 0));
        play.setText("Play TicTacToe");
        play.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play);
        play.setBounds(400, 300, 180, 40);

        player2Name.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        player2Name.setForeground(new java.awt.Color(0, 102, 0));
        player2Name.setText("Player2");
        getContentPane().add(player2Name);
        player2Name.setBounds(190, 200, 310, 50);

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("Enter Your Names");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 20, 380, 45);

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setText("Player2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 197, 80, 50);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 598, 473);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        DB db = new DB();
        db.connectLocal();
        String name1 = player1Name.getText();
        String name2 = player2Name.getText();
        

        ArrayList<String> nameList = db.selectLocal("user", "name", null);

         if (!nameList.contains(name1)){
            TableRecord table = new TableRecord();
            Record record = new Record(3, name1, "name");
            table.addRecord(record);
            record = new Record(0, "0", "MultiPlay_Wins");
            table.addRecord(record);
            record = new Record(0, "0", "MultiPlay_Losses");
            table.addRecord(record);
            record = new Record(0, "0", "MultiPlay_Ties");
            table.addRecord(record);
            
            record = new Record(0, "0", "SinglePlay_Wins");
            table.addRecord(record);
            record = new Record(0, "0", "SinglePlay_Losses");
            table.addRecord(record);
            record = new Record(0, "0", "SinglePlay_Ties");
            table.addRecord(record);
            db.addLocal("user", table);
            
            }
        if (!nameList.contains(name2)){
            TableRecord table = new TableRecord();
            Record record = new Record(3, name2, "name");
            table.addRecord(record);
            
            record = new Record(0, "0", "SinglePlay_Wins");
            table.addRecord(record);
            record = new Record(0, "0", "SinglePlay_Losses");
            table.addRecord(record);
            record = new Record(0, "0", "SinglePlay_Ties");
            table.addRecord(record);
            
            record = new Record(0, "0", "MultiPlay_Wins");
            table.addRecord(record);
            record = new Record(0, "0", "MultiPlay_Losses");
            table.addRecord(record);
            record = new Record(0, "0", "MultiPlay_Ties");
            table.addRecord(record);
            
            db.addLocal("user", table);
        
        
        }
        
        LeaderBoardHandler_MultiPlayer support = new LeaderBoardHandler_MultiPlayer(db,name1,name2);

        TicTacToeBoardMultiPlayer multiPlay = new TicTacToeBoardMultiPlayer();
        multiPlay.setSup(support);
        multiPlay.show();
        this.dispose();

    }//GEN-LAST:event_playActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        MainMenu m=new MainMenu();
        m.show();
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(MultiplayerUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiplayerUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiplayerUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiplayerUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiplayerUserInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton play;
    private javax.swing.JTextField player1Name;
    private javax.swing.JTextField player2Name;
    // End of variables declaration//GEN-END:variables
}
