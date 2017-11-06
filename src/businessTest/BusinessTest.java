package businessTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;
import business.Business;

public class BusinessTest {

	@Test
	public void testSetBoard() {
		
		// Empty board tested
		char[] emptyBoard;
		emptyBoard = new char[] {' ',' ',' ',' ',' ',' ',' ',' ',' '};
		assertArrayEquals(emptyBoard, Business.setBoard());
	}
	
	@Test
	public void testPrintBoard() {
		
		// Print current board test
		String emptyBoardPrinted;
		emptyBoardPrinted = "[ ,  ,  ,  ,  ,  ,  ,  ,  ]";
		assertEquals(emptyBoardPrinted , Business.printBoard());
	}
	
	@Test
	public void testPlayerMove() {
		
		// Player makes a move test
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
		assertEquals('X', Business.swapPlayer());
		assertEquals('O', Business.swapPlayer());
	}

}
