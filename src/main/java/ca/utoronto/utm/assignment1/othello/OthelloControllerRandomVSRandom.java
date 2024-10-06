package ca.utoronto.utm.assignment1.othello;

/**
 * Determine whether the first player or second player has the advantage when
 * both are playing a Random Strategy.
 * 
 * Do this by creating two players which use a random strategy and have them
 * play each other for 10000 games. What is your conclusion, does the first or
 * second player have some advantage, at least for a random strategy? 
 * State the null hypothesis H0, the alternate hypothesis Ha and 
 * about which your experimental results support. Place your short report in
 * randomVsRandomReport.txt.
 * 
 * @author arnold
 *
 */
public class OthelloControllerRandomVSRandom {
	/**
	 * Run main to execute the simulation and print out the two line results.
	 * Output looks like 
	 * Probability P1 wins=.75 
	 * Probability P2 wins=.20
	 * @param args
	 */
	protected Othello othello;
	PlayerRandom player1;
	PlayerRandom player2;

	/**
	 * Constructs a new OthelloControllerRandomVsRandom with a new Othello game, to simulate a
	 * match between 2 Random Players.
	 */
	public OthelloControllerRandomVSRandom() {
		this.othello = new Othello();
		this.player1 = new PlayerRandom(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerRandom(this.othello, OthelloBoard.P2);
	}

	/**
	 * This method is the main game loop that continues until the game is over. In each loop, each player's moves are retrieved
	 * and the board is updated accordingly. This method alternates between each player and also accounts for the case
	 * where the player has no more possible moves left, and skips that player's turn.
	 */
	public void play() {
		while (!othello.isGameOver()) {
			Move move = null;
			char whosTurn = othello.getWhosTurn();

			if (whosTurn == OthelloBoard.P1) {
				move = player1.getMove();}
				if (move == null) {
					move = player2.getMove();
				}
			if (whosTurn == OthelloBoard.P2) {
				move = player2.getMove();}
				if (move == null) {
					move = player1.getMove();
				}
			othello.move(move.getRow(), move.getCol());
		}
	}
	/**
	 * The main method to execute the simulation of multiple games (numGames) played between
	 * the 2 Random players, printing the probabilities of each player's
	 * victory after running the specified number of games.
	 * @param args
	 */
	public static void main(String[] args) {
		int p1wins = 0, p2wins = 0, numGames = 10000;
		for (int i = 0; i < numGames; i++) {
			OthelloControllerRandomVSRandom oc = new OthelloControllerRandomVSRandom();
			oc.play();
			if (oc.othello.getWinner() == OthelloBoard.P1) {
				p1wins++;
			}
			else if (oc.othello.getWinner() == OthelloBoard.P2) {
				p2wins++;
			}
		}
		System.out.println("Probability P1 wins=" + (float) p1wins / numGames);
		System.out.println("Probability P2 wins=" + (float) p2wins / numGames);
	}
}
