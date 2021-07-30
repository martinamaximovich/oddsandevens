/**
 * This class represents a computer
 * player in the Odd-Even game
 * 
 * @author: Martina Maximovich
 * @date: 02/27/21
 * @uni: mm5775 
 */

public class ComputerPlayer {
    private double t; // The threshold of the computer player.
    private int tokenBalance; // The amount of tokens the computer player has.

/* This constructor accepts a double as input and initializes 
 * the instance variables t and tokenBalance. */     
    public ComputerPlayer(double threshold) {
        t = threshold;
        tokenBalance = 0;
    }

// This public method generates a move in the game for the computer player.    
    public int computerMove() {
        double number = Math.random(); 
        int computerMove;
        
        if (number > t) {
            computerMove = 2;
        }
        else {
            computerMove = 1;     
        }
  
        return computerMove; 
    }

// This public method accepts an int as input and adds tokens to the 
// computer player.    
    public void addTokens(int amt) {
        tokenBalance += amt;
    }

// This public method accepts an int as input and subtracts tokens from 
// the computer player. 
    public void subtractTokens(int amt) {
        tokenBalance -= amt;
    }

// This is an accessor method for the instance variable tokenBalance.    
    public int getComputerScore() {
        return tokenBalance;
    }
    
    
}