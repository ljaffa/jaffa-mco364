package jaffa.mco364.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

	public enum Piece {
		X, O, EMPTY;

		Piece otherPlayer() {
			return this == Piece.X ? Piece.O : Piece.X;
		}
	}

	private Piece array[] = new Piece[9];
	private Piece activePlayer = Piece.X;

	public Board() {
		Arrays.fill(array, Piece.EMPTY);
	}

	public Board(Board other) {
		array = Arrays.copyOf(other.array, 9);
		activePlayer = other.activePlayer.otherPlayer();
	}

	public Piece getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Piece activePlayer) {
		this.activePlayer = activePlayer;
	}

	/**
	 * @return a Piece as the winner or null if there is no winner
	 */
	public Piece getWinner() {
		if (isWinner(0, 1, 2)) {
			return array[0];
		}
		if (isWinner(3, 4, 5)) {
			return array[3];
		}
		if (isWinner(6, 7, 8)) {
			return array[6];
		}
		if (isWinner(1, 4, 7)) {
			return array[1];
		}
		if (isWinner(2, 5, 8)) {
			return array[2];
		}
		if (isWinner(0, 3, 6)) {
			return array[0];
		}
		if (isWinner(0, 4, 8)) {
			return array[0];
		}
		if (isWinner(2, 4, 6)) {
			return array[2];
		}
		return null;
	}

	private boolean isWinner(int a, int b, int c) {
		return array[a] != Piece.EMPTY && array[a] == array[b]
						&& array[b] == array[c];
	}

	public void set(int index, Piece piece) {
		array[index] = piece;
	}

	public Piece get(int index) {
		return array[index];
	}

	/**
	 * @return a list of all possible moves
	 */
	public List<Integer> getMoves() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (array[i] == Piece.EMPTY) {
				list.add(i);
			}
		}
		return list;
	}

	public boolean isFull() {
		for (int i = 0; i < 9; i++) {
			if (array[i] == Piece.EMPTY) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return array[0].name() + array[1].name() + array[2].name() + "\n"
				+ array[3].name() + array[4].name() + array[5].name() + "\n"
				+ array[6].name() + array[7].name() + array[8].name();
	}

}
