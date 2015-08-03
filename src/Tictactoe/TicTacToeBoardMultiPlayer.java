/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Uer
 */
public class TicTacToeBoardMultiPlayer extends javax.swing.JFrame {
    private JLabel slots[];
    private boolean isGameOver = false;
    private ImageIcon circle;
    private ImageIcon cross;
    private LeaderBoardHandler_MultiPlayer sup;
    private DB db;
    private boolean hasPlayer1Won;
    private boolean hasPlayer2Won;
    private TicTacToeGame game;
    private char curr_Turn=game.HUMAN_PLAYER;
    private ImageIcon nullSymbol;
    
     public void setSup(LeaderBoardHandler_MultiPlayer sup){
       this.sup = sup;
       this.db = sup.getDb();
    }
    /**
     * Creates new form TicTacToeBoardMultiPlayer
     */
    public TicTacToeBoardMultiPlayer() {
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setLocation((dim.width - jLabel5.getWidth())/2, (dim.height - jLabel5.getHeight())/2);
        setSize(jLabel5.getWidth(), jLabel5.getHeight());
        cross = new ImageIcon("src/Tictactoe/imgx.jpg");
        circle = new ImageIcon("src/Tictactoe/imgo.jpg");
        this.nullSymbol=new ImageIcon("src/Tictactoe/img1.jpg");
        slots= new JLabel[TicTacToeGame.getBOARD_SIZE()];
        slots[0]=slot0;
        slots[1]=slot1;
        slots[2]=slot2;
        slots[3]=slot3;
        slots[4]=slot4;
        slots[5]=slot5;
        slots[6]=slot6;
        slots[7]=slot7;
        slots[8]=slot8;
        game = new TicTacToeGame();   
        startNewGame();
    }
    private void startNewGame(){
        hasPlayer1Won=false;
        hasPlayer2Won = false;
        game.clearBoard();
        for(int i=0;i<9;i++){
            slots[i].setIcon(this.nullSymbol);
            slots[i].setEnabled(true);
            slots[i].addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    CheckSlotClick(e);
                
                }
            });
                    
                    
        }
}
    
    
    private void CheckSlotClick(MouseEvent e){
        int move = 0;
        if (!isGameOver){
            for(int i=0;i<9;i++){
                if (e.getSource()==slots[i]){
                    move = i;
                    break;
                }
            }
            
        if(slots[move].isEnabled()){
            if (this.curr_Turn==game.HUMAN_PLAYER){
                setMove(game.HUMAN_PLAYER,move);
                this.curr_Turn=game.COMP_PLAYER;
            }
            else if (this.curr_Turn==game.COMP_PLAYER){
                setMove(game.COMP_PLAYER,move);
                this.curr_Turn=game.HUMAN_PLAYER;
            }
            
            
                int winner = game.checkForWinner();
                
                if (winner==1){
                    isGameOver = true;
                    JOptionPane.showMessageDialog(null, "Tied !", "GameOver", JOptionPane.INFORMATION_MESSAGE);
                    sup.inTies1();
                    sup.inTies2();
                    updateDatabase();
                                        
                }
                else if (winner==2){
                    isGameOver = true;
                    JOptionPane.showMessageDialog(null, "Player1 wins !", "GameOver", JOptionPane.INFORMATION_MESSAGE);
                    hasPlayer1Won=true;
                    sup.inWins1();
                    sup.inLosses2();
                    updateDatabase();
                 }
                else if(winner==3){
                    isGameOver = true;
                    JOptionPane.showMessageDialog(null, "Player2 wins !", "GameOver", JOptionPane.INFORMATION_MESSAGE);
                    hasPlayer2Won=true;
                    sup.inLosses1();
                    sup.inWins2();
                    updateDatabase();
                }
                else if (winner==0){
                    //nothing
                }
                
                
                           
            }
        }
    
    }
    
       private void setMove(char player,int location){
        game.setMove(player, location);
        //slots[location].setOpaque(false);
        if (player==TicTacToeGame.HUMAN_PLAYER)
            slots[location].setDisabledIcon(cross);
        else 
            slots[location].setDisabledIcon(circle);
        
        slots[location].setEnabled(false);
    
    
    }
       
       
       private void updateDatabase(){
            String user1;
            String user2;
            user1 = sup.getName1();
            user2 = sup.getName2();
            
            if (hasPlayer1Won){
                ArrayList<String> winsList = db.selectLocal("user", "MultiPlay_Wins", "name = '" + user1 + "'" );
                int wins = Integer.parseInt(winsList.get(0));
                wins++;
                String statement = "update user set MultiPlay_Wins = " + wins + " where name = '" + user1 +"'";
                db.executeLocal(statement);
                
                ArrayList<String> lossesList = db.selectLocal("user", "MultiPlay_Losses", "name = '" + user2 + "'" );
                int losses = Integer.parseInt(lossesList.get(0));
                losses++;
                statement = "update user set MultiPlay_Losses = " + losses + " where name = '" + user2 +"'";
                db.executeLocal(statement);
                
            }
            else if (hasPlayer2Won){
                
                ArrayList<String> winsList = db.selectLocal("user", "MultiPlay_Wins", "name = '" + user2 + "'" );
                int wins = Integer.parseInt(winsList.get(0));
                wins++;
                String statement = "update user set MultiPlay_Wins = " + wins + " where name = '" + user2 +"'";
                db.executeLocal(statement);
                
                ArrayList<String> lossesList = db.selectLocal("user", "MultiPlay_Losses", "name = '" + user1 + "'" );
                int losses = Integer.parseInt(lossesList.get(0));
                losses++;
                statement = "update user set MultiPlay_Losses = " + losses + " where name = '" + user1 +"'";
                db.executeLocal(statement);
                
                
            }
            else {
                ArrayList<String> tiesList1 = db.selectLocal("user", "MultiPlay_Ties", "name = '" + user1 + "'" );
                int ties1 = Integer.parseInt(tiesList1.get(0));
                ties1++;
                String statement = "update user set MultiPlay_Ties = " + ties1 + " where name = '" + user1 +"'";
                db.executeLocal(statement);
            
                ArrayList<String> tiesList2 = db.selectLocal("user", "MultiPlay_Ties", "name = '" + user2 + "'" );
                int ties2 = Integer.parseInt(tiesList2.get(0));
                ties2++;
                statement = "update user set MultiPlay_Ties = " + ties2 + " where name = '" + user2 +"'";
                db.executeLocal(statement);
            
            }
            
        }   
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        playAgain = new javax.swing.JButton();
        slot4 = new javax.swing.JLabel();
        slot8 = new javax.swing.JLabel();
        slot7 = new javax.swing.JLabel();
        slot1 = new javax.swing.JLabel();
        slot0 = new javax.swing.JLabel();
        slot2 = new javax.swing.JLabel();
        slot5 = new javax.swing.JLabel();
        slot3 = new javax.swing.JLabel();
        slot6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newGame = new javax.swing.JMenuItem();
        leaderboard = new javax.swing.JMenuItem();
        backToMain = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mpStat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(100, 100));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/x .jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 90, 83, 94);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/0.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 100, 71, 76);

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Player1");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 60, 90, 30);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Player2");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 60, 90, 30);

        playAgain.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        playAgain.setForeground(new java.awt.Color(51, 204, 0));
        playAgain.setText("Play Again");
        playAgain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainActionPerformed(evt);
            }
        });
        getContentPane().add(playAgain);
        playAgain.setBounds(370, 320, 180, 50);

        slot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot4.setMaximumSize(new java.awt.Dimension(100, 100));
        slot4.setMinimumSize(new java.awt.Dimension(100, 100));
        slot4.setOpaque(true);
        slot4.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot4);
        slot4.setBounds(130, 180, 100, 100);

        slot8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot8.setMaximumSize(new java.awt.Dimension(100, 100));
        slot8.setMinimumSize(new java.awt.Dimension(100, 100));
        slot8.setOpaque(true);
        slot8.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot8);
        slot8.setBounds(240, 290, 100, 100);

        slot7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot7.setMaximumSize(new java.awt.Dimension(100, 100));
        slot7.setMinimumSize(new java.awt.Dimension(100, 100));
        slot7.setOpaque(true);
        slot7.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot7);
        slot7.setBounds(130, 290, 100, 100);

        slot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot1.setMaximumSize(new java.awt.Dimension(100, 100));
        slot1.setMinimumSize(new java.awt.Dimension(100, 100));
        slot1.setOpaque(true);
        slot1.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot1);
        slot1.setBounds(130, 70, 100, 100);

        slot0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot0.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot0.setMaximumSize(new java.awt.Dimension(100, 100));
        slot0.setMinimumSize(new java.awt.Dimension(100, 100));
        slot0.setOpaque(true);
        slot0.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot0);
        slot0.setBounds(20, 70, 100, 100);

        slot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot2.setMaximumSize(new java.awt.Dimension(100, 100));
        slot2.setMinimumSize(new java.awt.Dimension(100, 100));
        slot2.setOpaque(true);
        slot2.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot2);
        slot2.setBounds(240, 70, 100, 100);

        slot5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot5.setMaximumSize(new java.awt.Dimension(100, 100));
        slot5.setMinimumSize(new java.awt.Dimension(100, 100));
        slot5.setOpaque(true);
        slot5.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot5);
        slot5.setBounds(240, 180, 100, 100);

        slot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot3.setMaximumSize(new java.awt.Dimension(100, 100));
        slot3.setMinimumSize(new java.awt.Dimension(100, 100));
        slot3.setOpaque(true);
        slot3.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot3);
        slot3.setBounds(20, 180, 100, 100);

        slot6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.jpg"))); // NOI18N
        slot6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot6.setMaximumSize(new java.awt.Dimension(100, 100));
        slot6.setMinimumSize(new java.awt.Dimension(100, 100));
        slot6.setOpaque(true);
        slot6.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot6);
        slot6.setBounds(20, 290, 100, 100);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -10, 640, 490);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 51));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 51), new java.awt.Color(0, 0, 51), null, null));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 51));

        jMenu1.setText("Game");

        newGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        jMenu1.add(newGame);

        leaderboard.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        leaderboard.setText("LeaderBoard");
        leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardActionPerformed(evt);
            }
        });
        jMenu1.add(leaderboard);

        backToMain.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        backToMain.setText("Back to Main Menu");
        backToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainActionPerformed(evt);
            }
        });
        jMenu1.add(backToMain);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit from Tic Tac Toe");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Player");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        mpStat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mpStat.setText("Multi Player Statisctics");
        mpStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpStatActionPerformed(evt);
            }
        });
        jMenu2.add(mpStat);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainActionPerformed
        isGameOver=false;
        startNewGame();
    }//GEN-LAST:event_playAgainActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        MultiPlayerStatistics mp = new MultiPlayerStatistics();
        mp.setSup(this.sup);
        mp.show();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void backToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainActionPerformed
        MainMenu m = new MainMenu();
         m.show();
        this.dispose();
    }//GEN-LAST:event_backToMainActionPerformed

    private void leaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderboardActionPerformed
        LeaderBoardHandler_SinglePlayer sup1 = new LeaderBoardHandler_SinglePlayer(db);
        LeaderBoardHandler_MultiPlayer sup2 = new LeaderBoardHandler_MultiPlayer(db);
        LeaderBoard b1 = new LeaderBoard();
         b1.setMode();
        b1.setSup(sup1, sup2);
         b1.show();
        
    }//GEN-LAST:event_leaderboardActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        isGameOver=false;
        startNewGame();
    }//GEN-LAST:event_newGameActionPerformed

    private void mpStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpStatActionPerformed
        MultiPlayerStatistics mp = new MultiPlayerStatistics();
        mp.setSup(this.sup);
        mp.show();
    }//GEN-LAST:event_mpStatActionPerformed

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
            java.util.logging.Logger.getLogger(TicTacToeBoardMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoardMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoardMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoardMultiPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeBoardMultiPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem backToMain;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem leaderboard;
    private javax.swing.JMenuItem mpStat;
    private javax.swing.JMenuItem newGame;
    private javax.swing.JButton playAgain;
    private javax.swing.JLabel slot0;
    private javax.swing.JLabel slot1;
    private javax.swing.JLabel slot2;
    private javax.swing.JLabel slot3;
    private javax.swing.JLabel slot4;
    private javax.swing.JLabel slot5;
    private javax.swing.JLabel slot6;
    private javax.swing.JLabel slot7;
    private javax.swing.JLabel slot8;
    // End of variables declaration//GEN-END:variables
}
