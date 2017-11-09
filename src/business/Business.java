package business;

import java.util.Arrays;
import java.util.Random;

public class Business {

	public char[] board;
	public char currPlayer;
	public int movesLeft;
	
	public static void main(String[] args) {
	}

	public Business() {
		board = setBoard();
		currPlayer = 'X';
		movesLeft = 9;
	}
	
	// New board set ' ' = empty square on board.
	public char[] setBoard() {
		board = new char[] {' ',' ',' ',' ',' ',' ',' ',' ',' '};		
		return  board;	
	}

	// Print current board out
	public String printBoard() {
		return Arrays.toString(board);
	}

	// Player makes a move to board
	public boolean playerMove(char player, int move) {	
		if(move < 0 || move > 9 || isOccupied(move)) return false;
		if(board[move] == ' ') {
			board[move] = player;
			movesLeft--;
		}
		return true;	
	}

	public char swapPlayer() {	
		if(currPlayer == 'X') currPlayer = 'O'; 
		else currPlayer = 'X';	
		return currPlayer;
	}

	public int movesLeft() {
		return movesLeft;
	}

	public char gameStatus() {
		// X winning conditions
		if((board[0] == 'X' && board[1] == 'X' && board[2] == 'X') ||
		   (board[3] == 'X' && board[4] == 'X' && board[5] == 'X') ||
		   (board[6] == 'X' && board[7] == 'X' && board[8] == 'X') ||
		   (board[0] == 'X' && board[3] == 'X' && board[6] == 'X') ||
		   (board[1] == 'X' && board[4] == 'X' && board[7] == 'X') ||
		   (board[2] == 'X' && board[5] == 'X' && board[8] == 'X') || 
		   (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') ||
		   (board[2] == 'X' && board[4] == 'X' && board[6] == 'X')) return 'X';
		
		// O winning conditions
		if((board[0] == 'O' && board[1] == 'O' && board[2] == 'O') ||
		   (board[3] == 'O' && board[4] == 'O' && board[5] == 'O') ||
		   (board[6] == 'O' && board[7] == 'O' && board[8] == 'O') ||   
		   (board[0] == 'O' && board[3] == 'O' && board[6] == 'O') ||
		   (board[1] == 'O' && board[4] == 'O' && board[7] == 'O') ||
		   (board[2] == 'O' && board[5] == 'O' && board[8] == 'O') ||
		   (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') ||
		   (board[2] == 'O' && board[4] == 'O' && board[6] == 'O')) return 'O';
		
		// If no moves are left, its draw
		if(movesLeft < 1) return 'D';
		
		// still moves left and X and O have not won yet
		return 'N';
	}

	public boolean isOccupied(int N) {
		if(N < 0 || N > 8) throw new IllegalArgumentException("Your number is out of bounds");
		if(board[N] == ' ') return false;
		return true;
	}

	public void aIMoveRand() {
		
		if(gameStatus() == 'N')
		{
			Random rand = new Random();
			int value = 4;
			while(isOccupied(value)) 
				value = rand.nextInt(9);
			
			playerMove(currPlayer, value);
		}
		// could just be nothing ??
		else if(gameStatus() == 'X' || gameStatus() == 'O' || gameStatus() == 'D')
		{
			// no moves left or draw or X / O wins
		}
		
		
	}
}
