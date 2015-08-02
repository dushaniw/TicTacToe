/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.util.Random;

public class TicTacToeGame {
   private char board[];
   private static final int BOARD_SIZE = 9;
   
   public static final char HUMAN_PLAYER = 'X';
   public static final char COMP_PLAYER = '0';
   public static final char EMPTY_SPACE = ' ';
   
   private Random rand;
   
   public static int getBOARD_SIZE() {  
        return BOARD_SIZE;  
   }  
         
   public TicTacToeGame(){  
              
        board = new char[BOARD_SIZE];  
              
        for (int i = 0; i < BOARD_SIZE; i++)  
            board[i] = EMPTY_SPACE;  
        
        rand = new Random();  
    }  
   
   public void clearBoard(){
        for (int i = 0; i < BOARD_SIZE; i++)  
            board[i] = EMPTY_SPACE;  
             
    }  
   
     
    public void setMove (char player, int location){
        board[location]=player;

    }
    
    public int getComputerMove(){
        int move;
        for (int i=0; i<getBOARD_SIZE();i++){
            if (board[i]!=HUMAN_PLAYER && board[i] != COMP_PLAYER ){
                char curr = board[i];
                board[i]=COMP_PLAYER;
                if (checkForWinner()==3){
                    setMove(COMP_PLAYER,i);
                    return i;
                }
                else {
                    board[i]=curr;
                }
                       
            }
            
        }
    
        for (int i=0; i<getBOARD_SIZE();i++){
            if (board[i]!=HUMAN_PLAYER && board[i] != COMP_PLAYER ){
                char curr = board[i];
                board[i]=HUMAN_PLAYER;
                if (checkForWinner()==2){
                    setMove(COMP_PLAYER,i);
                    return i;
                }
                else {
                    board[i]=curr;
                }
                       
            }
            
        }
        
        do {
            move = rand.nextInt(getBOARD_SIZE());
        }while (board[move]==COMP_PLAYER || board[move]==HUMAN_PLAYER);
        
        setMove(COMP_PLAYER,move);
        return move;
             
    }
    
    public int checkForWinner(){
        for(int i=0; i<=6; i+=3){ //check horizontally
             if((board[i]==HUMAN_PLAYER) && (board[i+1]==HUMAN_PLAYER) && (board[i+2]==HUMAN_PLAYER))
                 return 2;  //human won
              if((board[i]==COMP_PLAYER) && (board[i+1]==COMP_PLAYER) && (board[i+2]==COMP_PLAYER))
                 return 3;  //computer won
        }
        
        for(int i=0; i<3; i++){   // check vertically
             if((board[i]==HUMAN_PLAYER) && (board[i+3]==HUMAN_PLAYER) && (board[i+6]==HUMAN_PLAYER))
                 return 2;
              if((board[i]==COMP_PLAYER) && (board[i+3]==COMP_PLAYER) && (board[i+6]==COMP_PLAYER))
                 return 3;
        }
        //check diagonally seperately
        if (board[0]==HUMAN_PLAYER && board[4]==HUMAN_PLAYER && board[8]==HUMAN_PLAYER) 
            return 2;
        
        if (board[0]==COMP_PLAYER && board[4]==COMP_PLAYER && board[8]==COMP_PLAYER)
            return 3;
        
        if (board[2]==HUMAN_PLAYER && board[4]==HUMAN_PLAYER && board[6]==HUMAN_PLAYER) 
            return 2;
        
        if (board[2]==COMP_PLAYER && board[4]==COMP_PLAYER && board[6]==COMP_PLAYER)
            return 3;
        
         for (int i=0; i<getBOARD_SIZE();i++){
            if (board[i]!=HUMAN_PLAYER && board[i] != COMP_PLAYER ) // check if there are still empty spaces
                return 0;   //game has not over yet
         }
         
         return 1; // game has been tied
    }
}
