
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;


/**
 *
 * @author Uer
 */
public class TicTacToeBoardSinglePlayer extends javax.swing.JFrame {
    public static String symbol;
    private TicTacToeGame game;
    private JLabel slots[];
    private boolean humanFirst = true;
    private boolean isGameOver = false;
    private ImageIcon humanImage;
    private ImageIcon compImage;
    private ImageIcon humanSymbol;
    private ImageIcon compSymbol;
    private ImageIcon nullSymbol;
    private LeaderBoardHandler_SinglePlayer sup;
    private DB db; 
    private boolean hasHumanWon;
    private boolean hasCompWon;
    
    private static Logger logger = Logger.getLogger(TicTacToeBoardSinglePlayer.class);
	
    
   
    public void setSup(LeaderBoardHandler_SinglePlayer sup){
       this.sup = sup;
       this.db = sup.getDb();
       tot_Wins.setText((String)String.valueOf(sup.getWins()));
       tot_Losses.setText((String)String.valueOf(sup.getLosses()));
    }
    
    public TicTacToeBoardSinglePlayer(){
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setLocation((dim.width - jLabel6.getWidth())/2, (dim.height - jLabel6.getHeight())/2);
        setSize(jLabel6.getWidth(), jLabel6.getHeight());
        this.nullSymbol=new ImageIcon("src/Tictactoe/img1.png");
        if (symbol=="X"){
            humanImage = new ImageIcon("src/Tictactoe/imgx.png");
            compImage = new ImageIcon("src/Tictactoe/imgo.png");
            humanSymbol = new ImageIcon("src/Tictactoe/x.png");
            compSymbol = new ImageIcon("src/Tictactoe/0.png");
        }
        else if (symbol=="0"){
            humanImage = new ImageIcon("src/Tictactoe/imgo.png");
            compImage = new ImageIcon("src/Tictactoe/imgx.png");
            humanSymbol = new ImageIcon("src/Tictactoe/0.png");
            compSymbol = new ImageIcon("src/Tictactoe/x.png");
        
        }
        jLabel2.setIcon(humanSymbol);
        jLabel1.setIcon(compSymbol);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitGame = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tot_Losses = new javax.swing.JLabel();
        tot_Wins = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        slot0 = new javax.swing.JLabel();
        slot1 = new javax.swing.JLabel();
        slot2 = new javax.swing.JLabel();
        slot3 = new javax.swing.JLabel();
        slot4 = new javax.swing.JLabel();
        slot5 = new javax.swing.JLabel();
        slot6 = new javax.swing.JLabel();
        slot7 = new javax.swing.JLabel();
        slot8 = new javax.swing.JLabel();
        playAgain1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        newGame = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        leaderboard = new javax.swing.JMenuItem();
        backToMain = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        spStat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        exitGame.setBackground(new java.awt.Color(170, 140, 53));
        exitGame.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        exitGame.setForeground(new java.awt.Color(255, 255, 255));
        exitGame.setText("Exit");
        exitGame.setBorderPainted(false);
        exitGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameActionPerformed(evt);
            }
        });
        getContentPane().add(exitGame);
        exitGame.setBounds(440, 390, 130, 40);

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("YOU");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 50, 60, 40);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("COMPUTER");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 50, 100, 40);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 80, 110, 100);

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("Total Wins");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(360, 190, 110, 50);

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setText("Total Losses");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(470, 190, 120, 50);

        tot_Losses.setFont(new java.awt.Font("Cordia New", 0, 36)); // NOI18N
        tot_Losses.setForeground(new java.awt.Color(0, 102, 0));
        tot_Losses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tot_Losses.setText("0");
        getContentPane().add(tot_Losses);
        tot_Losses.setBounds(450, 250, 140, 42);

        tot_Wins.setFont(new java.awt.Font("Cordia New", 0, 36)); // NOI18N
        tot_Wins.setForeground(new java.awt.Color(0, 102, 0));
        tot_Wins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tot_Wins.setText("0");
        getContentPane().add(tot_Wins);
        tot_Wins.setBounds(330, 250, 130, 42);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 80, 110, 100);

        slot0.setBackground(new java.awt.Color(255, 255, 255));
        slot0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot0.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot0.setMaximumSize(new java.awt.Dimension(100, 100));
        slot0.setMinimumSize(new java.awt.Dimension(100, 100));
        slot0.setOpaque(true);
        slot0.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot0);
        slot0.setBounds(10, 50, 100, 100);

        slot1.setBackground(new java.awt.Color(255, 255, 255));
        slot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot1.setMaximumSize(new java.awt.Dimension(100, 100));
        slot1.setMinimumSize(new java.awt.Dimension(100, 100));
        slot1.setOpaque(true);
        slot1.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot1);
        slot1.setBounds(120, 50, 100, 100);

        slot2.setBackground(new java.awt.Color(255, 255, 255));
        slot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot2.setMaximumSize(new java.awt.Dimension(100, 100));
        slot2.setMinimumSize(new java.awt.Dimension(100, 100));
        slot2.setOpaque(true);
        slot2.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot2);
        slot2.setBounds(230, 50, 100, 100);

        slot3.setBackground(new java.awt.Color(255, 255, 255));
        slot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot3.setMaximumSize(new java.awt.Dimension(100, 100));
        slot3.setMinimumSize(new java.awt.Dimension(100, 100));
        slot3.setOpaque(true);
        slot3.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot3);
        slot3.setBounds(10, 160, 100, 100);

        slot4.setBackground(new java.awt.Color(255, 255, 255));
        slot4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot4.setMaximumSize(new java.awt.Dimension(100, 100));
        slot4.setMinimumSize(new java.awt.Dimension(100, 100));
        slot4.setOpaque(true);
        slot4.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot4);
        slot4.setBounds(120, 160, 100, 100);

        slot5.setBackground(new java.awt.Color(255, 255, 255));
        slot5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot5.setMaximumSize(new java.awt.Dimension(100, 100));
        slot5.setMinimumSize(new java.awt.Dimension(100, 100));
        slot5.setOpaque(true);
        slot5.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot5);
        slot5.setBounds(230, 160, 100, 100);

        slot6.setBackground(new java.awt.Color(255, 255, 255));
        slot6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot6.setMaximumSize(new java.awt.Dimension(100, 100));
        slot6.setMinimumSize(new java.awt.Dimension(100, 100));
        slot6.setOpaque(true);
        slot6.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot6);
        slot6.setBounds(10, 270, 100, 100);

        slot7.setBackground(new java.awt.Color(255, 255, 255));
        slot7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot7.setMaximumSize(new java.awt.Dimension(100, 100));
        slot7.setMinimumSize(new java.awt.Dimension(100, 100));
        slot7.setOpaque(true);
        slot7.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot7);
        slot7.setBounds(120, 270, 100, 100);

        slot8.setBackground(new java.awt.Color(255, 255, 255));
        slot8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/img1.png"))); // NOI18N
        slot8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        slot8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slot8.setMaximumSize(new java.awt.Dimension(100, 100));
        slot8.setMinimumSize(new java.awt.Dimension(100, 100));
        slot8.setOpaque(true);
        slot8.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(slot8);
        slot8.setBounds(230, 270, 100, 100);

        playAgain1.setBackground(new java.awt.Color(170, 140, 53));
        playAgain1.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        playAgain1.setForeground(new java.awt.Color(255, 255, 255));
        playAgain1.setText("Play Again");
        playAgain1.setBorderPainted(false);
        playAgain1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playAgain1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgain1ActionPerformed(evt);
            }
        });
        getContentPane().add(playAgain1);
        playAgain1.setBounds(290, 390, 130, 40);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 598, 460);

        jMenuBar1.setBackground(new java.awt.Color(170, 140, 53));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 51), new java.awt.Color(0, 0, 51), null, null));

        newGame.setText("Game");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New Game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        newGame.add(jMenuItem1);

        leaderboard.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        leaderboard.setText("LeaderBoard");
        leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardActionPerformed(evt);
            }
        });
        newGame.add(leaderboard);

        backToMain.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        backToMain.setText("Back to Main Menu");
        backToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainActionPerformed(evt);
            }
        });
        newGame.add(backToMain);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Exit from TicTacToe");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        newGame.add(Exit);

        jMenuBar1.add(newGame);

        jMenu2.setText("Player");

        spStat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        spStat.setText("Single Player Statistics");
        spStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spStatActionPerformed(evt);
            }
        });
        jMenu2.add(spStat);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitGameActionPerformed

    private void spStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spStatActionPerformed
        SinglePlayerStatistics sp = new SinglePlayerStatistics();
        sp.setSup(this.sup,this);
        sp.show();
        this.setVisible(false);
    }//GEN-LAST:event_spStatActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        isGameOver=false;
        startNewGame();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void playAgain1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgain1ActionPerformed
        isGameOver=false;
        startNewGame();
    }//GEN-LAST:event_playAgain1ActionPerformed
    
    private void updateDatabase(){
            String user;
            user = sup.getName();
            if (hasHumanWon){
                ArrayList<String> winsList = db.selectLocal("user", "SinglePlay_Wins", "name = '" + user + "'" );
                int wins = Integer.parseInt(winsList.get(0));
                wins++;
                String statement = "update user set SinglePlay_Wins = " + wins + " where name = '" + user +"'";
                db.executeLocal(statement);
            }
            else if (hasCompWon){
                ArrayList<String> lossesList = db.selectLocal("user", "SinglePlay_Losses", "name = '" + user + "'" );
                int losses = Integer.parseInt(lossesList.get(0));
                losses++;
                String statement = "update user set SinglePlay_Losses = " + losses + " where name = '" + user +"'";
                db.executeLocal(statement);
            }
            else {
                ArrayList<String> tiesList = db.selectLocal("user", "SinglePlay_Ties", "name = '" + user + "'" );
                int ties = Integer.parseInt(tiesList.get(0));
                ties++;
                String statement = "update user set SinglePlay_Ties = " + ties + " where name = '" + user +"'";
                db.executeLocal(statement);
            
            
            
            }
            
        }
    private void startNewGame(){
        hasHumanWon=false;
        hasCompWon = false;
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
        if (!humanFirst){
            int move = game.getComputerMove();
            setMove(game.COMP_PLAYER,move);
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
                setMove(game.HUMAN_PLAYER,move);
                
                int winner = game.checkForWinner();
                
                if (winner==0){
                    move = game.getComputerMove();
                    setMove(game.COMP_PLAYER,move);
                    winner = game.checkForWinner();
                }
                
                if (winner==1){
                    isGameOver = true;
                    JOptionPane.showMessageDialog(null, "Single Player Mode("+this.sup.getName()+"): Tied !", "GameOver", JOptionPane.INFORMATION_MESSAGE);
                    sup.inTies();
                    updateDatabase();
                    logger.info("Tied");
                                        
                }
                else if (winner==2){
                    isGameOver = true;
                    JOptionPane.showMessageDialog(null, "You win !", "GameOver", JOptionPane.INFORMATION_MESSAGE);
                    hasHumanWon=true;
                    sup.inWins();
                    updateDatabase();
                    tot_Wins.setText((String)String.valueOf(sup.getWins()));
                    tot_Losses.setText((String)String.valueOf(sup.getLosses()));
                    tot_Wins.repaint();
                    tot_Losses.repaint();
                    logger.info("Single Player Mode("+this.sup.getName()+"): You Won");
                }
                else if(winner==3){
                    isGameOver = true;
                    JOptionPane.showMessageDialog(null, "Computer wins !", "GameOver", JOptionPane.INFORMATION_MESSAGE);
                    hasCompWon=true;
                    sup.inLosses();
                    updateDatabase();
                    tot_Wins.setText((String)String.valueOf(sup.getWins()));
                    tot_Losses.setText((String)String.valueOf(sup.getLosses()));
                    tot_Wins.repaint();
                    tot_Losses.repaint();
                    logger.info("Single Player Mode("+this.sup.getName()+"): Computer Won");
                }
                           
            }
        }
    
    }
    
    private void setMove(char player,int location){
        game.setMove(player, location);
       // slots[location].setOpaque(false);
        if (player==TicTacToeGame.HUMAN_PLAYER)
            slots[location].setDisabledIcon(humanImage);
        else 
            slots[location].setDisabledIcon(compImage);
        
        slots[location].setEnabled(false);
    
    
    }
    
   
      
    
    
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
            java.util.logging.Logger.getLogger(TicTacToeBoardSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoardSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoardSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeBoardSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeBoardSinglePlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem backToMain;
    private javax.swing.JButton exitGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem leaderboard;
    private javax.swing.JMenu newGame;
    private javax.swing.JButton playAgain1;
    private javax.swing.JLabel slot0;
    private javax.swing.JLabel slot1;
    private javax.swing.JLabel slot2;
    private javax.swing.JLabel slot3;
    private javax.swing.JLabel slot4;
    private javax.swing.JLabel slot5;
    private javax.swing.JLabel slot6;
    private javax.swing.JLabel slot7;
    private javax.swing.JLabel slot8;
    private javax.swing.JMenuItem spStat;
    private javax.swing.JLabel tot_Losses;
    private javax.swing.JLabel tot_Wins;
    // End of variables declaration//GEN-END:variables
}
