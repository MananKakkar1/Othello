package ca.utoronto.utm.assignment1.othello;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayerRandom makes a move by first determining all possible moves that this
 * player can make, putting them in an ArrayList, and then randomly choosing one
 * of them.
 * 
 * @author arnold
 *
 */
public class PlayerRandom extends Player {

	private final Random rand = new Random();

	/**
	 * Constructs a PlayerRandom with the specified othello game instance and player character.
	 * This constructor calls the superclass constructor to initialize the game instance and player.
	 * @param othello is the game instance that this player participates in.
	 * @param player is the character representing this player (P1 or P2).
	 */
	public PlayerRandom(Othello othello, char player) {
		super(othello, player);
	}

	/**
	 * This method collects all possible moves that the player can make in an ArrayList and returns one of these
	 * possible moves at random. If there are no valid moves, it returns null.
	 * @return A Move object which represents a randomly selected valid move for the player,
	 * or null if no valid moves are available.
	 */
	@Override
	public Move getMove() {
		ArrayList<Move> moves = new ArrayList<Move>();
		for (int row = 0; row < this.othello.getDimension(); row++) {
			for (int col = 0; col < this.othello.getDimension(); col++) {
				OthelloBoard copied = this.othello.copy();
				if (copied.move(row, col, this.player)) {
					moves.add(new Move(row, col));
				}
			}
		}
		if (moves.isEmpty()) {
			return null;
		}
		return moves.get(rand.nextInt(moves.size()));
	}
}
