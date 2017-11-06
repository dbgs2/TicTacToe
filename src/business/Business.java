package business;

import java.util.Arrays;

public class Business {

	public static char[] board;
	public static char currPlayer;
	
	public static void main(String[] args) {
	}

	public Business() {
		//board = setBoard();
		//currPlayer = 'X';
	}
	
	// New board set ' ' = empty square on board.
	public static char[] setBoard() {
		board = new char[] {' ',' ',' ',' ',' ',' ',' ',' ',' '};		
		return  board;	
	}

	// Print current board out
	public static String printBoard() {
		setBoard();
		return Arrays.toString(board);
	}

	// Player makes a move to board
	public static void playerMove(char player, int move) {	
		if(move < 0 || move > 9) return;
		if(board[move] == ' ') board[move] = player;	
	}

	public static char swapPlayer() {	
		if(currPlayer == 'X') currPlayer = 'O'; 
		else currPlayer = 'X';	
		return currPlayer;
	}
}
