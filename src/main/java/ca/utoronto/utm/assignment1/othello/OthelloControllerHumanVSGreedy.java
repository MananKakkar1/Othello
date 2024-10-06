package ca.utoronto.utm.assignment1.othello;

/**
 * This controller uses the Model classes to allow the Human player P1 to play
 * the computer P2. The computer, P2 uses a greedy strategy. 
 * 
 * @author arnold
 *
 */
public class OthelloControllerHumanVSGreedy {
	
	/**
	 * Run main to play a Human (P1) against the computer P2. 
	 * The computer uses a greedy strategy, that is, it picks the first
	 * move which maximizes its number of token on the board.
	 * The output should be almost identical to that of OthelloControllerHumanVSHuman.
	 * @param args
	 */
	protected Othello othello;
	PlayerHuman player1;
	PlayerGreedy player2;

	/**
	 * Constructs a new OthelloControllerHumanVSGreedy with a new Othello game, it simulates a Human Vs PlayerGreedy
	 * game at the console.
	 */
	public OthelloControllerHumanVSGreedy() {
		this.othello = new Othello();
		this.player1 = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
	}

	/**
	 * This method is the main game loop that continues until the game is over. In each loop, it prints the current
	 * state of the board, retrieves each player's moves and updates the board accordingly. This method alternates between
	 * each player and also accounts for the case where the player has no more possible moves left, and skips that player's
	 * turn.
	 */
	public void play() {
		while (!othello.isGameOver()) {
			this.report();

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

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}

	/**
	 * Reports the move made by the player to the console.
	 * @param whosTurn The character representing the player making the current move (P1 or P2).
	 * @param move The move made by the current player (row, col).
	 */
	private void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}

	/**
	 * Reports the current state of the board including the number of pieces of each player and whose turn it is next.
	 */
	private void report() {

		String s = othello.getBoardString() + OthelloBoard.P1 + ":"
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  "
				+ othello.getWhosTurn() + " moves next";
		System.out.println(s);
	}


	/**
	 * Reports the final state of the game including the number of pieces of each player and declares the winner of the
	 * game.
	 */
	private void reportFinal() {

		String s = othello.getBoardString() + OthelloBoard.P1 + ":"
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2)
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}

	/**
	 * Run main to play Human Vs PlayerGreedy against each other at the console.
	 * @param args
	 */
	public static void main(String[] args) {
		OthelloControllerHumanVSGreedy oc = new OthelloControllerHumanVSGreedy();
		oc.play();
	}
}
