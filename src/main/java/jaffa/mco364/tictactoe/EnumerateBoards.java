package jaffa.mco364.tictactoe;

import java.util.List;
import java.util.Stack;

public class EnumerateBoards {

	/**
	 * Determine number of possible boards and which piece wins more often, X or
	 * O. Find how many times each piece wins.
	 */
	public static void main(String[] args) {
		Stack<Board> stack = new Stack<Board>();
		int nBoards = 0;
		int ties = 0;
		int xWins = 0;
		int oWins = 0;

		Board emptyBoard = new Board();
		stack.push(emptyBoard);

		while (!stack.isEmpty()) {
			Board board = stack.pop();
			nBoards++;

			Board.Piece winner = board.getWinner();
			if (winner == Board.Piece.X) {
				xWins++;
				continue;
			} else if (winner == Board.Piece.O) {
				oWins++;
				continue;
			}
			Board.Piece activePlayer = board.getActivePlayer();
			List<Integer> moves = board.getMoves();

			if (moves.isEmpty()) {
				ties++;
				continue;
			}
			for (int move : moves) {
				Board child = new Board(board);
				child.set(move, activePlayer);
				stack.push(child);
			}
		}

		System.out
				.print(String
						.format("number of boards = %d ties = %d xWins = %d oWins = %d leaves = %d",
								nBoards, ties, xWins, oWins, ties + xWins
										+ oWins));
	}

}
