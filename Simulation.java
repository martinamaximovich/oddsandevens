/**
 * This class runs simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that adavantage.
 * 
 * @author: Martina Maximovich
 * @date: 02/27/21
 * @uni: mm5775
 */


public class Simulation {
    
    public static void main(String[] args) {
        int currentTokens = 0; // stores # of tokens in each game
        double maxWinnings = -200001; // stores maximum maxMin value
        double p1Strategy = 0.0; // stores optimal threshold for player1
        double minAvgWinnings; // min avg tokens at player1 optimal threshold
        int numberOfGames = 50000; // # of games played per threshold combo
        
        for (double t1 = 0; t1 <= 1.00; t1 += 0.02) {
            int maxMin = 150001; // max minimum # tokens player1 gains in t1
            
            for (double t2 = 0; t2 <= 1.00; t2 += 0.02) {
                Game g = new Game(t1, t2); // creates new game
                g.play(numberOfGames); // play 50000 games
                
                currentTokens = g.getP1Score();

                // updates maxMin if lower token balance found for game in t1
                if (currentTokens < maxMin) { 
                    maxMin = currentTokens;
                }        
               
            }
            
            // updates maxWinnings and p1Strategy if better strategy found
            if (maxMin > maxWinnings) {  
                    maxWinnings = maxMin;
                    p1Strategy = t1;
            }
            
        }
        
        minAvgWinnings = (maxWinnings / numberOfGames); 
        
        System.out.println("Player 1 Optimal Threshold: " +
                           String.format("%.2f", p1Strategy) +
                           "\nPlayer 1 Minimum Average Winnings: " + 
                           String.format("%.4f", minAvgWinnings) + " tokens.");
        
    }
    
}
    
    


