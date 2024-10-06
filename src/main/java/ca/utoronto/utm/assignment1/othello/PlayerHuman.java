package ca.utoronto.utm.assignment1.othello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PlayerHuman makes a move through the user's input. It ensures that the inputs are valid and within the dimensions of
 * the othelloBoard. This class allows the user to input row and column numbers to make a move.
 * @author arnold
 *
 */
public class PlayerHuman {
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	private Othello othello;
	private char player;

	/**
	 * Constructs a PlayerHuman with the specified Othello game instance and a specific player.
	 * @param othello is the game instance that this player participates in.
	 * @param player is the character representing this player (P1 or P2).
	 */
	public PlayerHuman(Othello othello, char player) {
		
		this.othello = othello;
		this.player = player;
	}

	/**
	 * Prompts the human player for a move and retrieves the selected move from the Move class.
	 * The move consists of a row and column both determined using user input within the correct board bounds.
	 * @return A move object representing the player's chosen row and column
	 */
	public Move getMove() {
		
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}

	/**
	 * This method prompts the user for a specific move by asking for a row and column. It validates the input
	 * by checking the input is an integer between 0 and 7 inclusive. The user is prompted for an integer until a valid
	 * input is provided.
	 * @param message is the prompt message to display to the user
	 * @return The valid move chosen by user input as an integer.
	 */
	private int getMove(String message) {
		
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
