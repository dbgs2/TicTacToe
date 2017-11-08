package consoleInterface;

import java.util.Scanner; 

import business.Business;

public class ConsoleInterface {

	public static Business business = new Business();
	public static char status;
	public static Scanner scan;
	//public static  move;
	
	public static void printBoard() {
		//System.out.println(business.printBoard());
		for(int i = 0; i < 9; i = i +3) {
			System.out.println(business.board[i] + " | " + business.board[i + 1] + " | " + business.board[i + 2]);
		}
		
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
		System.out.println("AI moves: ");
		business.swapPlayer();
		business.aIMoveRand();
		business.swapPlayer();
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
	