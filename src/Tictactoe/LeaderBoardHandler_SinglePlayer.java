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
public class LeaderBoardHandler_SinglePlayer {
    DB db;
    String name;
    int wins;
    int losses;
    int ties;
    
    
    public LeaderBoardHandler_SinglePlayer(DB db){
        this.db=db;
    }
    
  
    public LeaderBoardHandler_SinglePlayer(DB db, String name){
        this.db = db;
        this.name = name;
        ArrayList<String> winsList = db.selectLocal("user", "SinglePlay_Wins", "name = '" + name + "'" );
        wins = Integer.parseInt(winsList.get(0));
        ArrayList<String> lossesList = db.selectLocal("user", "SinglePlay_Losses", "name = '" + name + "'" );
        losses = Integer.parseInt(lossesList.get(0));
        ArrayList<String> TiesList = db.selectLocal("user", "SinglePlay_Ties", "name = '" + name + "'" );
        ties = Integer.parseInt(TiesList.get(0));
        
    }
    
    public DB getDb() {
        return db;
    }

    public String getName() {
        return name;
    }

    public int getLosses() {
        return losses;
    }

    public void inLosses(){
       losses++;
    }
   
    public int getWins() {
        return wins;
    }

    public void inWins(){
       wins++;
    }
    
    public int getTied(){
        return ties;
    }
    
    public void inTies(){
        ties++;
    }  
    
    
    
}
