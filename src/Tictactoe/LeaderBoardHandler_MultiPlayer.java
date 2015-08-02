/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.util.ArrayList;

/**
 *
 * @author Uer
 */
public class LeaderBoardHandler_MultiPlayer {
    
    DB db;
    String name1;
    String name2;
    int wins1;
    int wins2;
    int losses1;
    int losses2;
    int ties1;
    int ties2;
    
    
    public LeaderBoardHandler_MultiPlayer(DB db){
        this.db=db;
    }
    
    
    public LeaderBoardHandler_MultiPlayer(DB db, String name1,String name2){
        this.db = db;
        this.name1 = name1;
        ArrayList<String> winsList1 = db.selectLocal("user", "MultiPlay_Wins", "name = '" + name1 + "'" );
        wins1 = Integer.parseInt(winsList1.get(0));
        ArrayList<String> lossesList1 = db.selectLocal("user", "MultiPlay_Losses", "name = '" + name1 + "'" );
        losses1 = Integer.parseInt(lossesList1.get(0));
        ArrayList<String> TiesList1 = db.selectLocal("user", "MultiPlay_Ties", "name = '" + name1 + "'" );
        ties1 = Integer.parseInt(TiesList1.get(0));
        
        this.name2 = name2;
        ArrayList<String> winsList2 = db.selectLocal("user", "MultiPlay_Wins", "name = '" + name2 + "'" );
        wins2 = Integer.parseInt(winsList2.get(0));
        ArrayList<String> lossesList2 = db.selectLocal("user", "MultiPlay_Losses", "name = '" + name2 + "'" );
        losses2 = Integer.parseInt(lossesList2.get(0));
        ArrayList<String> TiesList2 = db.selectLocal("user", "MultiPlay_Ties", "name = '" + name2 + "'" );
        ties2 = Integer.parseInt(TiesList2.get(0));
        
    }
    
    public DB getDb() {
        return db;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }
    public int getLosses1() {
        return losses1;
    }

    public int getLosses2() {
        return losses2;
    }
    
    public int getTies1(){
        return ties1;
    }
    
    public int getTies2(){
        return ties2;
    }
    
    public void inLosses1(){
       losses1++;
    }
    public void inLosses2(){
        losses2++;
    }

    public void inTies1(){
        ties1++;
    }
    
    public void inTies2(){
        ties2++;
    }
    
    public int getWins1() {
        return wins1;
    }

    public int getWins2() {
        return wins2;
    }
    public void inWins1(){
       wins1++;
    }
    public void inWins2(){
        wins2++;
    }
    
    
    
}    
    
    
    
    

