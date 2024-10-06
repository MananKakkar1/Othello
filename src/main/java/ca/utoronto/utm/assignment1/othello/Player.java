package ca.utoronto.utm.assignment1.othello;

/**
 * Player is an abstract class that serves a base for different types of players in the Othello game.
 *
 * Subclasses of Player are expected to implement the getMove() method, which determines the player's next move based on
 * a specific strategy.
 *
 * This class contains all shared properties and attributes of any Player types.
 */
public abstract class Player {
    protected Othello othello;
    protected char player;

    /**
     * Constructs a Player with a specified Othello game instance and player character.
     * @param othello is the game instance that this player participates in.
     * @param player is the character representing this player (P1 or P2).
     */
    public Player(Othello othello, char player) {
        this.othello = othello;
        this.player = player;
    }

    /**
     * This is an abstract method that must be implemented by subclasses to determine and return
     * the player's next move in the game. It is not implemented here because each type of player does not share any
     * strategy.
     * @return A move object which represents the player's chosen move. The specified strategy to choose a move is
     * defined in each subclass.
     */
    public abstract Move getMove();
}
