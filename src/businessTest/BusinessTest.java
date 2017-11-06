package businessTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;
import business.Business;

public class BusinessTest {

	Business business;
	
	@Test
	public void testSetBoard() {
		
		// Empty board tested
		business = new Business();
		char[] emptyBoard;
		emptyBoard = new char[] {' ',' ',' ',' ',' ',' ',' ',' ',' '};
		assertArrayEquals(emptyBoard, Business.setBoard());
	}
	
	@Test
	public void testPrintBoard() {
		
		// Print current board test
		business = new Business();
		String emptyBoardPrinted;
		emptyBoardPrinted = "[ ,  ,  ,  ,  ,  ,  ,  ,  ]";
		assertEquals(emptyBoardPrinted , Business.printBoard());
	}
	
	@Test
	public void testPlayerMove() {
		
		// Player makes a move test
		business = new Business();
		char[] emptyBoard;
		emptyBoard = new char[] {'X',' ',' ',' ',' ',' ',' ',' ',' '};
		Business.playerMove('X', 0);
		Business.playerMove('O', 0);
		Business.playerMove('O', -1);
		Business.playerMove('O', 10);
		assertArrayEquals(emptyBoard, Business.board);
		
		emptyBoard = new char[] {'X','O',' ',' ',' ',' ',' ',' ',' '};
		Business.playerMove('X', 0);
		Business.playerMove('O', 1);
		assertArrayEquals(emptyBoard, Business.board);
		
	}
	
	@Test
	public void testSwapPlayer() {
		
		// Swap player test
		business = new Business();
		assertEquals('O', Business.swapPlayer());
		assertEquals('X', Business.swapPlayer());
		assertEquals('O', Business.swapPlayer());
	}
	
	@Test
	public void testMovesLeft() {
		
		// Moves left test
		business = new Business();
		assertEquals(9 , Business.movesLeft());	
		Business.playerMove('X', 0);
		assertEquals(8 , Business.movesLeft());	
		Business.playerMove('X', 0);
		assertEquals(8 , Business.movesLeft());
		Business.playerMove('O', 1);
		assertEquals(7 , Business.movesLeft());
	}
	
	@Test
	public void testGameStatus() {
		
		// Game status test
		business = new Business();
		
		// None wins, still moves left
		assertEquals('N' , Business.gameStatus());
		
		// X wins
		Business.playerMove('X', 0);
		Business.playerMove('X', 1);
		Business.playerMove('X', 2);
		assertEquals('X' , Business.gameStatus());
		
		// O wins
		business = new Business();
		Business.playerMove('O', 0);
		Business.playerMove('O', 1);
		Business.playerMove('O', 2);
		assertEquals('O' , Business.gameStatus());
		
		// Draw
		business = new Business();
		Business.playerMove('X', 0);
		Business.playerMove('O', 1);
		Business.playerMove('X', 2);
		Business.playerMove('O', 3);
		Business.playerMove('X', 4);
		Business.playerMove('X', 5);
		Business.playerMove('O', 6);
		Business.playerMove('X', 7);
		Business.playerMove('O', 8);
		assertEquals('D' , Business.gameStatus());
	}

}
