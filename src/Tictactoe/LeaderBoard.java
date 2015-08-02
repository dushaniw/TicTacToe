/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Uer
 */
public class LeaderBoard extends javax.swing.JFrame {
    LeaderBoardHandler_SinglePlayer sup1;
    LeaderBoardHandler_MultiPlayer sup2;
    boolean playingModeOn = false;
    
    
    public void setMode(){
        this.playingModeOn=true;
    }
    
    /**
     * Creates new form LeaderBoard
     */
    public LeaderBoard() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setLocation((dim.width - jLabel5.getWidth())/2, (dim.height - jLabel5.getHeight())/2);
        setSize(jLabel5.getWidth(), jLabel5.getHeight());
        
    }

    public void setSup(LeaderBoardHandler_SinglePlayer sup1, LeaderBoardHandler_MultiPlayer sup2 ){
        this.sup1 = sup1;
        DB db = sup1.getDb();
        
        this.sup2=sup2;
                
        ArrayList<String> NameList = db.selectLocal("user", "name", null);
        Iterator<String> it = NameList.iterator();
        
        HashMap<String,Integer> singlePlayMap = new HashMap<String,Integer>();
        HashMap<String,Integer> multiPlayMap = new HashMap<String,Integer>();
        
        ArrayList<String> singlePMarkList = db.selectLocal("user", "SinglePlay_Wins", null);
        Iterator<String> itSinglePlayerMark = singlePMarkList.iterator();
        
        ArrayList<String> multiPMarkList = db.selectLocal("user", "MultiPlay_Wins", null);
        Iterator<String> itMultiPlayerMark = multiPMarkList.iterator();
        
        while(it.hasNext()){
            String name = it.next();
            int singlePlayMarks = (Integer.parseInt(itSinglePlayerMark.next()));
            singlePlayMap.put(name, singlePlayMarks);
            int multiPlayMarks = (Integer.parseInt(itMultiPlayerMark.next()));
            multiPlayMap.put(name, multiPlayMarks);
           
        }
        
        LinkedHashMap lmapSinglePlayer = sortHashMapByValuesD(singlePlayMap);
        LinkedHashMap lmapMultiPlayer = sortHashMapByValuesD(multiPlayMap);
        
        Iterator mIt1 = lmapSinglePlayer.entrySet().iterator();
        int j=0;
        ArrayList<String> namesSingle = new ArrayList<String>();        
        while(mIt1.hasNext()&&j<3) {
            j++;
            Map.Entry me1 = (Map.Entry)mIt1.next();
            namesSingle.add((String)me1.getKey());
        }
        if (j==3){               
        splayer1.setText(namesSingle.get(0));
        splayer2.setText(namesSingle.get(1));
        splayer3.setText(namesSingle.get(2));
        }
        else if (j==2){
        splayer1.setText(namesSingle.get(0));
        splayer2.setText(namesSingle.get(1));
        }
        else if (j==1){
        splayer1.setText(namesSingle.get(0));
        }
                  
        Iterator mIt2 = lmapMultiPlayer.entrySet().iterator();
        int i=0;
        ArrayList<String> names = new ArrayList<String>();        
        while(mIt2.hasNext()&&i<3) {
            i++;
            Map.Entry me = (Map.Entry)mIt2.next();
            names.add((String)me.getKey());
        }
        if (i==3){               
        mplayer1.setText(names.get(0));
        mplayer2.setText(names.get(1));
        mplayer3.setText(names.get(2));
        }
        else if (i==2){
        mplayer1.setText(names.get(0));
        mplayer2.setText(names.get(1));
        }
        else if (i==1){
        mplayer1.setText(names.get(0));
        }
            
        }  
            
        
    
    
    public LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
            List mapKeys = new ArrayList(passedMap.keySet());
            List mapValues = new ArrayList(passedMap.values());
            Collections.sort(mapValues,Collections.reverseOrder());
            Collections.sort(mapKeys,Collections.reverseOrder());

            LinkedHashMap sortedMap = new LinkedHashMap();

            Iterator valueIt = mapValues.iterator();
            while (valueIt.hasNext()) {
                Object val = (Integer)valueIt.next();
                Iterator keyIt = mapKeys.iterator();

                while (keyIt.hasNext()) {
                   Object key = (String)keyIt.next();
                    String comp1 = passedMap.get(key).toString();
                    String comp2 = val.toString();

                    if (comp1.equals(comp2)){
                        passedMap.remove(key);
                        mapKeys.remove(key);
                        if((Integer)val!=0){
                            sortedMap.put((String)key, (Integer)val);
                          }
                        break;
                    }

                }
                
            }
            

            return sortedMap;
}
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splayer1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        splayer2 = new javax.swing.JTextField();
        splayer3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mplayer2 = new javax.swing.JTextField();
        mplayer3 = new javax.swing.JTextField();
        mplayer1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        splayer1.setEditable(false);
        splayer1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        splayer1.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(splayer1);
        splayer1.setBounds(360, 150, 210, 28);

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setText("Leader Board");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(183, 11, 280, 42);

        splayer2.setEditable(false);
        splayer2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        splayer2.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(splayer2);
        splayer2.setBounds(360, 220, 210, 28);

        splayer3.setEditable(false);
        splayer3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        splayer3.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(splayer3);
        splayer3.setBounds(360, 290, 210, 28);

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("#2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 220, 22, 22);

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("#1");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 150, 22, 22);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("#3");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 290, 22, 22);

        jLabel9.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("Single Player Mode");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(380, 110, 177, 22);

        mplayer2.setEditable(false);
        mplayer2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mplayer2.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(mplayer2);
        mplayer2.setBounds(60, 220, 210, 28);

        mplayer3.setEditable(false);
        mplayer3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mplayer3.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(mplayer3);
        mplayer3.setBounds(60, 290, 210, 28);

        mplayer1.setEditable(false);
        mplayer1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mplayer1.setForeground(new java.awt.Color(0, 102, 0));
        getContentPane().add(mplayer1);
        mplayer1.setBounds(60, 150, 210, 28);

        jLabel6.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("#1");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(320, 150, 22, 22);

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setText("#2");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(320, 220, 22, 22);

        jLabel8.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setText("#3");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(320, 290, 22, 22);

        jLabel10.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 0));
        jLabel10.setText("Multi Player Mode");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(70, 110, 180, 22);

        back.setBackground(new java.awt.Color(255, 255, 255));
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
        back.setBounds(440, 370, 130, 44);

        jLabel5.setBackground(new java.awt.Color(0, 102, 0));
        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tictactoe/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 600, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        if (!playingModeOn){
            MainMenu ma = new MainMenu();
            ma.show();
        }
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
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaderBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mplayer1;
    private javax.swing.JTextField mplayer2;
    private javax.swing.JTextField mplayer3;
    private javax.swing.JTextField splayer1;
    private javax.swing.JTextField splayer2;
    private javax.swing.JTextField splayer3;
    // End of variables declaration//GEN-END:variables
}
