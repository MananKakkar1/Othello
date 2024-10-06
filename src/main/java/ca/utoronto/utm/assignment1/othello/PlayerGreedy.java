package ca.utoronto.utm.assignment1.othello;

/**
 * PlayerGreedy makes a move by considering all possible moves that the player
 * can make. Each move leaves the player with a total number of tokens.
 * getMove() returns the first move which maximizes the number of
 * tokens owned by this player. In case of a tie, between two moves,
 * (row1,column1) and (row2,column2) the one with the smallest row wins. In case
 * both moves have the same row, then the smaller column wins.
 * 
 * Example: Say moves (2,7) and (3,1) result in the maximum number of tokens for
 * this player. Then (2,7) is returned since 2 is the smaller row.
 * 
 * Example: Say moves (2,7) and (2,4) result in the maximum number of tokens for
 * this player. Then (2,4) is returned, since the rows are tied, but (2,4) has
 * the smaller column.
 * 
 * See the examples supplied in the assignment handout.
 * 
 * @author arnold
 *
 */

public class PlayerGreedy extends Player{

	/**
	 * Constructs a PlayerGreedy with the specified Othello game instance and player character.
	 * This constructor calls the superclass constructor to initialize the game instance and player.
	 * @param othello is the game instance that this player participates in.
	 * @param player is the character representing this player (P1 or P2).
	 */
	public PlayerGreedy(Othello othello, char player) {
		super(othello, player);
	}

	/**
	 * This method checks all possible moves for the player and returns the move that maximizes the number of tokens
	 * owned by the player. If multiple moves lead to the same amount of maximum tokens, the first move with the maximum
	 * tokens is returned. It returns null if there are no valid possible moves.
	 * @return A move object which represents the best move for the player or null if there are no valid moves.
	 */
	@Override
	public Move getMove() {
		Move bestMove = null;
		int maxTokens = -1;
		for (int row = 0; row < othello.getDimension(); row++) {
			for (int col = 0; col < othello.getDimension(); col++) {
				OthelloBoard copied = this.othello.copy();
				if (copied.move(row, col, this.player)) {
					int currTokenCount = copied.getCount(this.player);
					if (currTokenCount > maxTokens) {
						maxTokens = currTokenCount;
						bestMove = new Move(row, col);
					}
				}
			}
		}
		return bestMove;
	}
}
