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
public class PlayerRandom {

	private final char player;
	private final Othello othello;
	private final Random rand = new Random();

	public PlayerRandom(Othello othello, char player) {
		this.player = player;
		this.othello = othello;
	}

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
