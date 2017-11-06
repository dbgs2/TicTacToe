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

}
