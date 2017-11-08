package businessTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;
import business.Business;

public class BusinessTest {

	static Business business;
	
	@Test
	public void testSetBoard() {
		
		// Empty board tested
		business = new Business();
		char[] emptyBoard;
		emptyBoard = new char[] {' ',' ',' ',' ',' ',' ',' ',' ',' '};
		assertArrayEquals(emptyBoard, business.setBoard());
	}
	
	@Test
	public void testPrintBoard() {
		
		// Print current board test
		business = new Business();
		String emptyBoardPrinted;
		emptyBoardPrinted = "[ ,  ,  ,  ,  ,  ,  ,  ,  ]";
		assertEquals(emptyBoardPrinted , business.printBoard());
	}
	
	@Test
	public void testPlayerMove() {
		
		// Player makes a move test
		business = new Business();
		char[] emptyBoard;
		emptyBoard = new char[] {'X',' ',' ',' ',' ',' ',' ',' ',' '};
		business.playerMove('X', 0);
		business.playerMove('O', 0);
		business.playerMove('O', -1);
		business.playerMove('O', 10);
		assertArrayEquals(emptyBoard, business.board);
		
		emptyBoard = new char[] {'X','O',' ',' ',' ',' ',' ',' ',' '};
		business.playerMove('X', 0);
		business.playerMove('O', 1);
		assertArrayEquals(emptyBoard, business.board);
		
	}
	
	@Test
	public void testSwapPlayer() {
		
		// Swap player test
		business = new Business();
		assertEquals('O', business.swapPlayer());
		assertEquals('X', business.swapPlayer());
		assertEquals('O', business.swapPlayer());
	}
	
	@Test
	public void testMovesLeft() {
		
		// Moves left test
		business = new Business();
		assertEquals(9 , business.movesLeft());	
		business.playerMove('X', 0);
		assertEquals(8 , business.movesLeft());	
		business.playerMove('X', 0);
		assertEquals(8 , business.movesLeft());
		business.playerMove('O', 1);
		assertEquals(7 , business.movesLeft());
	}
	
	@Test
	public void testGameStatus() {
		
		// Game status test
		business = new Business();
		
		// None wins, still moves left
		assertEquals('N' , business.gameStatus());
		
		// X wins
		business.playerMove('X', 0);
		business.playerMove('X', 1);
		business.playerMove('X', 2);
		assertEquals('X' , business.gameStatus());
		
		// O wins
		business = new Business();
		business.playerMove('O', 0);
		business.playerMove('O', 1);
		business.playerMove('O', 2);
		assertEquals('O' , business.gameStatus());
		
		// Draw
		business = new Business();
		business.playerMove('X', 0);
		business.playerMove('O', 1);
		business.playerMove('X', 2);
		business.playerMove('O', 3);
		business.playerMove('X', 4);
		business.playerMove('X', 5);
		business.playerMove('O', 6);
		business.playerMove('X', 7);
		business.playerMove('O', 8);
		assertEquals('D' , business.gameStatus());
	}
	
	@Test public void testIsOccupied() {
		
		// Is occupied test
		business = new Business();
		business.playerMove('X', 0);
		assertEquals(true , business.isOccupied(0));
		assertEquals(false , business.isOccupied(1));
		
		// what to put in the first equals true/false/llegalArgumentException.class?
		try{
			assertEquals(true , business.isOccupied(10));
	    } catch(IllegalArgumentException e){
	        //ignore, this exception is expected.
	    	//System.out.println(e.getMessage()); 
	    }
		
		try{
			assertEquals(IllegalArgumentException.class , business.isOccupied(-1));
	    } catch(IllegalArgumentException e){
	        //ignore, this exception is expected.
	    	//System.out.println(e.getMessage()); 
	    }
	}
	
	@Test public void testAIMoveRand() {
		
		// AI move test
		business = new Business();
		assertEquals(9 , business.movesLeft);
		
		// Player moves as X
		business.playerMove('X', 4);
		business.swapPlayer();
		assertEquals(8 , business.movesLeft);
		
		// AI as O
		business.aIMoveRand();
		assertEquals(7 , business.movesLeft);
		//System.out.println(Business.printBoard()); 
	}
	
	

}
