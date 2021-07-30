/**
 * This class represents the Odd-Even game
 * 
 * @author: Martina Maximovich
 * @date: 02/27/21
 * @uni: mm5775
 */

import java.util.Scanner; 

public class Game { 
    
    private int humanTokens; // The # of tokens a user playing the game has
    private ComputerPlayer computerPlayer; // Computer player playing w/ human
    private ComputerPlayer player1; // Computer player 1 for simulated game
    private ComputerPlayer player2; // Computer player 2 for simulated game
    private String humanChoice; // User choice to be even or odd player
    
    
   
/* This version of the game constructor is for Part 1.
 * It takes no parameters and initializes the instance
 * variables: humanTokens, computerPlayer, humanChoice. */
    public Game() {
        humanTokens = 0;
        computerPlayer = new ComputerPlayer(0.5); 
        humanChoice = "";
    }
    
/* This version of the game constructor is for Part 2.
 * It requires two doubles as parameters and initializes
 * the instance variables: player1, player2. */
    public Game (double t1, double t2) {
        player1 = new ComputerPlayer(t1);
        player2 = new ComputerPlayer(t2);
        
    }
    
// This method prints the current scoreboard of the odd-even game.
    private void printResults() {
        System.out.println("\nScoreboard");
        System.out.println("You: " + humanTokens);
        System.out.println("Computer: " + computerPlayer.getComputerScore());
        
    }

// This method allows a user to play as the odd player.
    private void oddPlay() {  
        int computerMove = computerPlayer.computerMove();
        
        System.out.println("\nPlease enter 1 or 2 to play."); 
        Scanner scanner = new Scanner(System.in); 
        int playerMove = Integer.parseInt(scanner.next()); 
        
        int moveSum = computerMove + playerMove;
        System.out.println("\nThe computer chose " + computerMove + 
                          ", so the sum of your moves is " + moveSum + ".");
        
        if (moveSum % 2 == 0) {
            humanTokens -= moveSum; 
            computerPlayer.addTokens(moveSum);
            
            System.out.println("The sum of your moves is even, so " + 
                               "you have lost " + moveSum + " tokens!");
            printResults();
        }
        
        else {
            humanTokens += moveSum;
            computerPlayer.subtractTokens(moveSum);
            
            System.out.println("The sum of your moves is odd, so " + 
                               "you have gained " + moveSum + " tokens!");
            printResults();
        }
        
        playAgain();
        
    } 
    

// This method allows the user to play as the even player.    
    private void evenPlay() {  
        int computerMove = computerPlayer.computerMove();
        
        System.out.println("\nPlease enter 1 or 2 to play."); 
        Scanner scanner = new Scanner(System.in); 
        int playerMove = Integer.parseInt(scanner.next()); 
        
        int moveSum = computerMove + playerMove;
        System.out.println("\nThe computer chose " + computerMove + 
                          ", so the sum of your moves is " + moveSum + ".");
        
        if (moveSum % 2 == 0) {
            humanTokens += moveSum; 
            computerPlayer.subtractTokens(moveSum);
            
            System.out.println("The sum of your moves is even, so " + 
                               "you have gained " + moveSum + " tokens!");
            printResults(); 
        }
        
        else {
            humanTokens -= moveSum;
            computerPlayer.addTokens(moveSum);
            
            System.out.println("The sum of your moves is odd, so " + 
                               "you have lost " + moveSum + " tokens!");
            printResults();
        }
        
        playAgain();
        
    } 
    

/* This method allows the user to use whether they would like to
 * be the odd or even player and then executes the appropriate
 * play method. */ 
    private void oddOrEven() {
        gameRules();
        
        System.out.println("\nWould you like to be the even player" +
                          " or the odd player? Please enter" +
                           " odd or even.");
        
        Scanner oddOrEven = new Scanner(System.in);
        humanChoice = oddOrEven.next();
        
        if (humanChoice.equals("even")) {
            evenPlay();
        }
        
        else if (humanChoice.equals("odd")) {
            oddPlay();
        }
        
    }
    
    
// This public method calls the oddOrEven() method to begin the game.
    public void play() {
        oddOrEven();
    }

// This method prints the rules of the game.    
    private void gameRules() {
         System.out.println("Welcome to the game! Here are the rules: there " +
                          "are two players, an odd player and an even player." +
                          "\nEach player will simultaneously declare 1 or 2." +
                           " If the sum of the players' moves is even, the" +
                           "\neven player will gain that amount of tokens" +
                           " and the odd player will lose that amount of" +
                           "\ntokens. If the sum of the players' moves is" +
                           " odd, the odd player will gain that amount of" +
                           "\ntokens and the even player will lose that" +
                           " amount of tokens.");
    } 
    
    
        
/* This method allows the user to choose whether to play again or not
 * and prints the outcome of the game if they choose not to. */   
    private void playAgain() {
        System.out.println("\nWould you like to play another round? Enter" +
            " 'yes' or 'no'.");
        
        Scanner scanner = new Scanner(System.in);
        String playAgain = scanner.next();
        
        if (playAgain.equals("yes") && humanChoice.equals("even")) {
            evenPlay();
        }
        
        else if (playAgain.equals("yes") && humanChoice.equals("odd")) {
            oddPlay();
        }
        
        else if (playAgain.equals("no")) {
            
            if (humanTokens > 0) {
               System.out.println("You have won this game!");
            }
            else {
               System.out.println("The computer has won this game!");
            } 
            
        }
       
    }
    
     
/** This version of the play method is for Part 2.
 * This public method takes a single int as a parameter which is the
 * number of computer vs. computer games that should be played. */
    public void play(int games) {
        int numberOfGames = games;
        int p1Move;
        int p2Move;
        int moveSum = 0;
        
        for (int i = 0; i < games; i++) {
            p1Move = player1.computerMove();
            p2Move = player2.computerMove();
            moveSum = p1Move + p2Move;
            
            if (moveSum % 2 == 0) { 
                player2.addTokens(moveSum); 
                player1.subtractTokens(moveSum);
            }
            
            else {
                player1.addTokens(moveSum);
                player2.subtractTokens(moveSum);
            }
            
        }
        
    }
    
// This is an accessor method that returns player1's token balance.
    public int getP1Score() {
        return player1.getComputerScore();
        
    }
  
    
// This is an accessor method that returns player2's token balance.
    public int getP2Score() {
        return player2.getComputerScore();
        
    }  
    
}