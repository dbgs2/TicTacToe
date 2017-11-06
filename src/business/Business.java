package business;

import java.util.Arrays;

public class Business {

	public static char[] board;
	public static char currPlayer;
	public static int movesLeft;
	
	public static void main(String[] args) {
	}

	public Business() {
		board = setBoard();
		currPlayer = 'X';
		movesLeft = 9;
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
		if(board[move] == ' ') {
			board[move] = player;
			movesLeft--;
		}	
	}

	public static char swapPlayer() {	
		if(currPlayer == 'X') currPlayer = 'O'; 
		else currPlayer = 'X';	
		return currPlayer;
	}

	public static int movesLeft() {
		return movesLeft;
	}

	public static char gameStatus() {
		// X winning conditions
		if((board[0] == 'X' && board[1] == 'X' && board[2] == 'X') ||
		   (board[3] == 'X' && board[4] == 'X' && board[5] == 'X') ||
		   (board[6] == 'X' && board[7] == 'X' && board[8] == 'X') ||
		   (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') ||
		   (board[2] == 'X' && board[4] == 'X' && board[6] == 'X')) return 'X';
		
		// O winning conditions
		if((board[0] == 'O' && board[1] == 'O' && board[2] == 'O') ||
		   (board[3] == 'O' && board[4] == 'O' && board[5] == 'O') ||
		   (board[6] == 'O' && board[7] == 'O' && board[8] == 'O') ||
		   (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') ||
		   (board[2] == 'O' && board[4] == 'O' && board[6] == 'O')) return 'O';
		
		// If no moves are left, its draw
		if(movesLeft < 1) return 'D';
		
		// still moves left and X and O have not won yet
		return 'N';
	}
}
