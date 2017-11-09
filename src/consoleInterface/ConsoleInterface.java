package consoleInterface;

import java.util.Scanner; 

import business.Business;

public class ConsoleInterface {

	public static Business business = new Business();
	public static char status;
	public static Scanner scan;
	
	public static void printBoard() {
		clearScreen();
		System.out.println(" " + business.board[0] + " | " + business.board[1] + " | " + business.board[2]);
		System.out.println("-----------");
		System.out.println(" " + business.board[3] + " | " + business.board[4] + " | " + business.board[5]);
		System.out.println("-----------");
		System.out.println(" " + business.board[6] + " | " + business.board[7] + " | " + business.board[8]);
		
	}
	
	public static void playerMove() {
		char player = 'X';
		int move = 0;
		boolean stopper = false;
		
		while(!stopper) {
			System.out.print("Choose number: ");
			scan = new Scanner(System.in);
			move = scan.nextInt();	
			stopper = business.playerMove(player, move);
			if(stopper == false) System.out.println("Wrong input!");
		}	 
	}
	
	public static void aIMoveRand() {
		//System.out.println("AI moves: ");
		business.swapPlayer();
		business.aIMoveRand();
		business.swapPlayer();
	}
	
	public static void clearScreen() {
		for(int i = 0; i < 20; i++)
			System.out.println("\n");
	}
	
	public static void main(String[] args) {
			
		while(business.gameStatus() == 'N') {
			playerMove();
			printBoard();
			aIMoveRand();
			printBoard();			
		}
		
		if(business.gameStatus() == 'X' || business.gameStatus() == 'O')
			System.out.println("Game over " + business.gameStatus() + " wins");
		else
			System.out.println("Game over its a Draw");
		
		scan.close();

	}
	
	

}
	