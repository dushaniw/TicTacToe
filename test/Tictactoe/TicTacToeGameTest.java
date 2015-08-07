/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uer
 */
public class TicTacToeGameTest {
    
    public TicTacToeGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getBOARD_SIZE method, of class TicTacToeGame.
     */
    @Test
    public void testGetBOARD_SIZE() {
        TicTacToeGame instance = new TicTacToeGame();
        assertTrue(9==instance.getBOARD_SIZE());
    }

  
    /**
     * Test of getComputerMove method, of class TicTacToeGame.
     */
    @Test
    public void testGetComputerMove() {
        TicTacToeGame instance = new TicTacToeGame();
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 0);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 1);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 4);
        assertTrue(8==instance.getComputerMove());
        
        instance.clearBoard();
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 0);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 5);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 1);
        assertTrue(2==instance.getComputerMove());
        
        instance.clearBoard();
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 0);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 4);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 3);
        assertTrue(6==instance.getComputerMove());
        
        instance.clearBoard();
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 0);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 3);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 4);
        assertTrue(8==instance.getComputerMove());
        
        
    }

    /**
     * Test of checkForWinner method, of class TicTacToeGame.
     */
    @Test
    public void testCheckForWinner() {
        
        TicTacToeGame instance = new TicTacToeGame();
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 0);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 1);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 4);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 3);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 8);
        assertTrue(2==instance.checkForWinner());
    
        instance.clearBoard();
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 0);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 2);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 8);
        instance.setMove(TicTacToeGame.COMP_PLAYER, 4);
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 5);
        instance.setMove(TicTacToeGame.COMP_PLAYER,instance.getComputerMove());
        assertTrue(3==instance.checkForWinner());
        
        instance.clearBoard();
        instance.setMove(TicTacToeGame.HUMAN_PLAYER, 2);
        instance.setMove(TicTacToeGame.COMP_PLAYER,instance.getComputerMove());
        assertTrue(0==instance.checkForWinner());          
        
    }
    
}
