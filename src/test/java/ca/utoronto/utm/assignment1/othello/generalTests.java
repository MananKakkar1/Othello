package ca.utoronto.utm.assignment1.othello;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class generalTests {
    OthelloBoard board;
    Othello othello;
    PlayerRandom randomPlayer;
    public void setUp() {
        this.othello = new Othello();
        this.board = new OthelloBoard(8);
        this.randomPlayer = new PlayerRandom(this.othello, OthelloBoard.P1);
    }

    @Test
    public void testInvalidMoveOutsideBoard() {
        this.setUp();
        assertFalse(board.move(100, 110, OthelloBoard.P1));
        assertFalse(board.move(8, 8, OthelloBoard.P1));
    }

    @Test
    public void testGameOver() {
        this.setUp();
        board.move(2, 4, OthelloBoard.P1);
        board.move(4, 5, OthelloBoard.P2);
        board.move(5, 6, OthelloBoard.P1);
        board.move(2, 2, OthelloBoard.P2);
        board.move(3, 2, OthelloBoard.P1);
        board.move(4, 6, OthelloBoard.P2);
        board.move(5, 4, OthelloBoard.P1);
        board.move(2, 3, OthelloBoard.P2);
        board.move(4, 7, OthelloBoard.P1);
        board.move(2, 5, OthelloBoard.P2);
        board.move(1, 4, OthelloBoard.P1);
        board.move(4, 2, OthelloBoard.P2);
        board.move(4, 1, OthelloBoard.P1);
        board.move(5, 2, OthelloBoard.P2);
        board.move(2, 1, OthelloBoard.P1);
        board.move(4, 0, OthelloBoard.P2);
        board.move(5, 0, OthelloBoard.P1);
        board.move(3, 0, OthelloBoard.P2);
        board.move(2, 0, OthelloBoard.P1);
        board.move(1, 5, OthelloBoard.P2);
        board.move(2, 6, OthelloBoard.P1);
        board.move(1, 2, OthelloBoard.P2);
        board.move(0, 3, OthelloBoard.P1);
        board.move(0, 2, OthelloBoard.P2);
        board.move(0, 1, OthelloBoard.P1);
        board.move(6, 5, OthelloBoard.P2);
        board.move(6, 2, OthelloBoard.P1);
        board.move(0, 5, OthelloBoard.P2);
        board.move(0, 6, OthelloBoard.P1);
        board.move(6, 7, OthelloBoard.P2);
        board.move(6, 6, OthelloBoard.P1);
        board.move(5, 5, OthelloBoard.P2);
        board.move(5, 3, OthelloBoard.P1);
        board.move(0, 7, OthelloBoard.P2);
        board.move(1, 3, OthelloBoard.P1);
        board.move(6, 4, OthelloBoard.P2);
        board.move(7, 4, OthelloBoard.P1);
        board.move(1, 0, OthelloBoard.P2);
        board.move(3, 1, OthelloBoard.P1);
        board.move(5, 1, OthelloBoard.P2);
        board.move(6, 1, OthelloBoard.P1);
        board.move(7, 5, OthelloBoard.P2);
        board.move(0, 0, OthelloBoard.P1);
        board.move(3, 5, OthelloBoard.P2);
        board.move(1, 1, OthelloBoard.P1);
        board.move(7, 2, OthelloBoard.P2);
        board.move(1, 6, OthelloBoard.P1);
        board.move(7, 7, OthelloBoard.P2);
        board.move(3, 6, OthelloBoard.P1);
        board.move(7, 3, OthelloBoard.P2);
        board.move(6, 3, OthelloBoard.P1);
        board.move(2, 7, OthelloBoard.P2);
        board.move(7, 6, OthelloBoard.P1);
        board.move(0, 4, OthelloBoard.P2);
        board.move(1, 7, OthelloBoard.P1);
        board.move(3, 7, OthelloBoard.P2);
        board.move(5, 7, OthelloBoard.P1);
        board.move(7, 1, OthelloBoard.P2);
        assertEquals(OthelloBoard.BOTH, board.hasMove());
        board.move(7, 0, OthelloBoard.P1);
        assertEquals(OthelloBoard.P2, board.hasMove());
        board.move(6, 0, OthelloBoard.P2);
        System.out.println(board.toString());
        assert(board.hasMove() == OthelloBoard.EMPTY);
        //Also testing player counts after game is over
        assertEquals(39, board.getCount(OthelloBoard.P1));
        assertEquals(25, board.getCount(OthelloBoard.P2));
    }

    @Test
    public void testPlayerRandom() {
        this.setUp();
        othello.move(2, 4);
        othello.move(4, 5);
        othello.move(5, 6);
        othello.move(2, 2);
        System.out.println(othello.getBoardString());

        ArrayList<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(5, 4));
        expectedMoves.add(new Move(4, 2));
        expectedMoves.add(new Move(5, 2));
        expectedMoves.add(new Move(3, 2));


        Move move = this.randomPlayer.getMove();
        System.out.println(move.toString());
        System.out.println(expectedMoves);
        for (int i = 0; i < expectedMoves.size(); i++) {
            if (expectedMoves.get(i).equals(move)) {
                assertEquals(expectedMoves.get(i), move);
            }
        }
    }
}
