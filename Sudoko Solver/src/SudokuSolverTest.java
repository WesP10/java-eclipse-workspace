import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SudokuSolverTest {
	SudokuSolver s;
	@Before
	public void setUp() throws Exception {
		s = new SudokuSolver("Puzzles/puzzle.txt");
	}

	@Test
	public void testIsPossibleDigit() {
		assertTrue(s.isPossibleDigit(4,0,0));
		assertTrue(s.isPossibleDigit(1,0,4));
		assertTrue(s.isPossibleDigit(1,1,8));
		assertTrue(s.isPossibleDigit(9,3,0));
		assertTrue(s.isPossibleDigit(8,3,3));
		assertTrue(s.isPossibleDigit(5,3,4));
		
		assertFalse(s.isPossibleDigit(5,0,0));
		assertFalse(s.isPossibleDigit(7,0,0));

	}

	@Test
	public void testIsInSquareIntIntInt() {
		assertTrue(s.isInSquare(9,0,0));
		assertTrue(s.isInSquare(8,0,0));
		assertTrue(s.isInSquare(6,0,0));
		assertTrue(s.isInSquare(5,0,0));
		assertTrue(s.isInSquare(7,0,0));
		assertTrue(s.isInSquare(1,0,0));
		assertTrue(s.isInSquare(3,0,0));
		assertTrue(s.isInSquare(2,0,0));
		assertFalse(s.isInSquare(4,0,0));
		
		assertTrue(s.isInSquare(9,0,1));
		assertTrue(s.isInSquare(8,0,1));
		assertTrue(s.isInSquare(6,0,1));
		assertTrue(s.isInSquare(5,0,1));
		assertTrue(s.isInSquare(7,0,1));
		assertTrue(s.isInSquare(1,0,1));
		assertTrue(s.isInSquare(3,0,1));
		assertTrue(s.isInSquare(2,0,1));
		assertFalse(s.isInSquare(4,0,1));
	}

	@Test
	public void testGetSquare() {
		int[][] topLeft = s.getSquare(0,0);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(0,1);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(0,2);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(1,0);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(1,1);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(1,2);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(2,0);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(2,1);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		topLeft = s.getSquare(2,2);
		assertEquals(9,topLeft[0][1]);
		assertEquals(8,topLeft[0][2]);
		assertEquals(6,topLeft[1][0]);
		assertEquals(5,topLeft[1][1]);
		assertEquals(7,topLeft[1][2]);
		assertEquals(1,topLeft[2][0]);
		assertEquals(3,topLeft[2][1]);
		assertEquals(2,topLeft[2][2]);
		
		int[][] topCenter = s.getSquare(0,3);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(0,4);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(0,5);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(1,3);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(1,4);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(1,5);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(2,3);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(2,4);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		topCenter = s.getSquare(2,5);
		assertEquals(5,topCenter[0][0]);
		assertEquals(6,topCenter[0][2]);
		assertEquals(3,topCenter[1][0]);
		assertEquals(2,topCenter[1][1]);
		assertEquals(9,topCenter[1][2]);
		assertEquals(7,topCenter[2][0]);
		assertEquals(8,topCenter[2][1]);
		assertEquals(4,topCenter[2][2]);
		
		int[][] topRight = s.getSquare(0,6);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(0,7);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(0,8);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(1,6);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(1,7);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(1,8);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(2,6);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(2,7);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		topRight = s.getSquare(2,8);
		assertEquals(7,topRight[0][0]);
		assertEquals(2,topRight[0][1]);
		assertEquals(3,topRight[0][2]);
		assertEquals(8,topRight[1][0]);
		assertEquals(4,topRight[1][1]);
		assertEquals(6,topRight[2][0]);
		assertEquals(9,topRight[2][1]);
		assertEquals(5,topRight[2][2]);
		
		int[][] middleLeft = s.getSquare(3,0);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(3,1);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(3,2);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(4,0);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(4,1);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(4,2);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(5,0);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(5,1);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		middleLeft = s.getSquare(5,2);
		assertEquals(1,middleLeft[0][1]);
		assertEquals(4,middleLeft[0][2]);
		assertEquals(2,middleLeft[1][0]);
		assertEquals(8,middleLeft[1][1]);
		assertEquals(5,middleLeft[1][2]);
		assertEquals(7,middleLeft[2][0]);
		assertEquals(3,middleLeft[2][2]);
		
		int[][] middleCenter = s.getSquare(3,3);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(3,4);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(3,5);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(4,3);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(4,4);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(4,5);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(5,3);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(5,4);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		middleCenter = s.getSquare(5,5);
		assertEquals(7,middleCenter[0][2]);
		assertEquals(6,middleCenter[1][0]);
		assertEquals(9,middleCenter[1][1]);
		assertEquals(3,middleCenter[1][2]);
		assertEquals(1,middleCenter[2][0]);
		assertEquals(4,middleCenter[2][1]);
		assertEquals(2,middleCenter[2][2]);
		
		int[][] middleRight = s.getSquare(3,6);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(3,7);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(3,8);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(4,6);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(4,7);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(4,8);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(5,6);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(5,7);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		middleRight = s.getSquare(5,8);
		assertEquals(2,middleRight[0][0]);
		assertEquals(3,middleRight[0][1]);
		assertEquals(1,middleRight[1][0]);
		assertEquals(7,middleRight[1][1]);
		assertEquals(4,middleRight[1][2]);
		assertEquals(5,middleRight[2][0]);
		assertEquals(8,middleRight[2][1]);
		assertEquals(9,middleRight[2][2]);
		
		int[][] bottomLeft = s.getSquare(6,0);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(6,1);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(6,2);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(7,0);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(7,1);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(7,2);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(8,0);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(8,1);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		bottomLeft = s.getSquare(8,2);
		assertEquals(8,bottomLeft[0][0]);
		assertEquals(2,bottomLeft[0][1]);
		assertEquals(9,bottomLeft[0][2]);
		assertEquals(5,bottomLeft[1][0]);
		assertEquals(7,bottomLeft[1][1]);
		assertEquals(6,bottomLeft[1][2]);
		assertEquals(3,bottomLeft[2][0]);
		assertEquals(1,bottomLeft[2][2]);
		
		int[][] bottomCenter = s.getSquare(6,3);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(6,4);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(6,5);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(7,3);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(7,4);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(7,5);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(8,3);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(8,4);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		bottomCenter = s.getSquare(8,5);
		assertEquals(4,bottomCenter[0][0]);
		assertEquals(6,bottomCenter[0][1]);
		assertEquals(1,bottomCenter[0][2]);
		assertEquals(9,bottomCenter[1][0]);
		assertEquals(8,bottomCenter[1][2]);
		assertEquals(2,bottomCenter[2][0]);
		assertEquals(7,bottomCenter[2][1]);
		assertEquals(5,bottomCenter[2][2]);
		
		int[][] bottomRight = s.getSquare(6,6);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(6,7);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(6,8);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(7,6);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(7,7);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(7,8);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(8,6);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(8,7);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
		
		bottomRight = s.getSquare(8,8);
		assertEquals(3,bottomRight[0][0]);
		assertEquals(5,bottomRight[0][1]);
		assertEquals(7,bottomRight[0][2]);
		assertEquals(1,bottomRight[1][1]);
		assertEquals(2,bottomRight[1][2]);
		assertEquals(9,bottomRight[2][0]);
		assertEquals(6,bottomRight[2][1]);
	}

	@Test
	public void testIsInColumn() {
		assertTrue(s.isInColumn(6,0));
		assertTrue(s.isInColumn(1,0));
		assertTrue(s.isInColumn(2,0));
		assertTrue(s.isInColumn(7,0));
		assertTrue(s.isInColumn(8,0));
		assertTrue(s.isInColumn(5,0));
		assertTrue(s.isInColumn(3,0));
		assertFalse(s.isInColumn(4,0));
		assertFalse(s.isInColumn(9,0));
		
		assertTrue(s.isInColumn(9,1));
		assertTrue(s.isInColumn(5,1));
		assertTrue(s.isInColumn(3,1));
		assertTrue(s.isInColumn(1,1));
		assertTrue(s.isInColumn(8,1));
		assertTrue(s.isInColumn(2,1));
		assertTrue(s.isInColumn(7,1));
		assertFalse(s.isInColumn(4,1));
		assertFalse(s.isInColumn(6,1));
		
		assertTrue(s.isInColumn(8,2));
		assertTrue(s.isInColumn(7,2));
		assertTrue(s.isInColumn(2,2));
		assertTrue(s.isInColumn(4,2));
		assertTrue(s.isInColumn(5,2));
		assertTrue(s.isInColumn(3,2));
		assertTrue(s.isInColumn(9,2));
		assertTrue(s.isInColumn(6,2));
		assertTrue(s.isInColumn(1,2));
		
		assertTrue(s.isInColumn(5,3));
		assertTrue(s.isInColumn(3,3));
		assertTrue(s.isInColumn(7,3));
		assertTrue(s.isInColumn(6,3));
		assertTrue(s.isInColumn(1,3));
		assertTrue(s.isInColumn(4,3));
		assertTrue(s.isInColumn(9,3));
		assertTrue(s.isInColumn(2,3));
		assertFalse(s.isInColumn(8,3));
		
		assertTrue(s.isInColumn(2,4));
		assertTrue(s.isInColumn(8,4));
		assertTrue(s.isInColumn(9,4));
		assertTrue(s.isInColumn(4,4));
		assertTrue(s.isInColumn(6,4));
		assertTrue(s.isInColumn(7,4));
		assertFalse(s.isInColumn(1,4));
		assertFalse(s.isInColumn(3,4));
		assertFalse(s.isInColumn(5,4));
		
		assertTrue(s.isInColumn(6,5));
		assertTrue(s.isInColumn(9,5));
		assertTrue(s.isInColumn(4,5));
		assertTrue(s.isInColumn(7,5));
		assertTrue(s.isInColumn(3,5));
		assertTrue(s.isInColumn(2,5));
		assertTrue(s.isInColumn(1,5));
		assertTrue(s.isInColumn(8,5));
		assertTrue(s.isInColumn(5,5));
		
		assertTrue(s.isInColumn(7,6));
		assertTrue(s.isInColumn(8,6));
		assertTrue(s.isInColumn(6,6));
		assertTrue(s.isInColumn(2,6));
		assertTrue(s.isInColumn(1,6));
		assertTrue(s.isInColumn(5,6));
		assertTrue(s.isInColumn(3,6));
		assertTrue(s.isInColumn(9,6));
		assertFalse(s.isInColumn(4,6));
		
		assertTrue(s.isInColumn(2,7));
		assertTrue(s.isInColumn(4,7));
		assertTrue(s.isInColumn(9,7));
		assertTrue(s.isInColumn(3,7));
		assertTrue(s.isInColumn(7,7));
		assertTrue(s.isInColumn(8,7));
		assertTrue(s.isInColumn(5,7));
		assertTrue(s.isInColumn(1,7));
		assertTrue(s.isInColumn(6,7));
		
		assertTrue(s.isInColumn(3,8));
		assertTrue(s.isInColumn(5,8));
		assertTrue(s.isInColumn(4,8));
		assertTrue(s.isInColumn(9,8));
		assertTrue(s.isInColumn(7,8));
		assertTrue(s.isInColumn(2,8));
		assertFalse(s.isInColumn(1,8));
		assertFalse(s.isInColumn(6,8));
		assertFalse(s.isInColumn(8,8));
	}

	@Test
	public void testIsInRow() {
		assertTrue(s.isInRow(9,0));
		assertTrue(s.isInRow(8,0));
		assertTrue(s.isInRow(5,0));
		assertTrue(s.isInRow(6,0));
		assertTrue(s.isInRow(7,0));
		assertTrue(s.isInRow(2,0));
		assertTrue(s.isInRow(3,0));
		assertFalse(s.isInRow(1,0));
		assertFalse(s.isInRow(4,0));
		
		assertTrue(s.isInRow(6,1));
		assertTrue(s.isInRow(5,1));
		assertTrue(s.isInRow(7,1));
		assertTrue(s.isInRow(3,1));
		assertTrue(s.isInRow(2,1));
		assertTrue(s.isInRow(9,1));
		assertTrue(s.isInRow(8,1));
		assertTrue(s.isInRow(4,1));
		assertFalse(s.isInRow(1,1));
		
		assertTrue(s.isInRow(1,2));
		assertTrue(s.isInRow(3,2));
		assertTrue(s.isInRow(2,2));
		assertTrue(s.isInRow(7,2));
		assertTrue(s.isInRow(8,2));
		assertTrue(s.isInRow(7,2));
		assertTrue(s.isInRow(6,2));
		assertTrue(s.isInRow(9,2));
		assertTrue(s.isInRow(5,2));
		
		assertTrue(s.isInRow(1,3));
		assertTrue(s.isInRow(4,3));
		assertTrue(s.isInRow(7,3));
		assertTrue(s.isInRow(2,3));
		assertTrue(s.isInRow(3,3));
		assertFalse(s.isInRow(5,3));
		assertFalse(s.isInRow(6,3));
		assertFalse(s.isInRow(8,3));
		assertFalse(s.isInRow(9,3));
		
		assertTrue(s.isInRow(2,4));
		assertTrue(s.isInRow(8,4));
		assertTrue(s.isInRow(5,4));
		assertTrue(s.isInRow(6,4));
		assertTrue(s.isInRow(9,4));
		assertTrue(s.isInRow(3,4));
		assertTrue(s.isInRow(1,4));
		assertTrue(s.isInRow(7,4));
		assertTrue(s.isInRow(4,4));
		
		assertTrue(s.isInRow(7,5));
		assertTrue(s.isInRow(3,5));
		assertTrue(s.isInRow(1,5));
		assertTrue(s.isInRow(4,5));
		assertTrue(s.isInRow(2,5));
		assertTrue(s.isInRow(5,5));
		assertTrue(s.isInRow(8,5));
		assertTrue(s.isInRow(9,5));
		assertFalse(s.isInRow(6,5));
		
		assertTrue(s.isInRow(8,6));
		assertTrue(s.isInRow(2,6));
		assertTrue(s.isInRow(9,6));
		assertTrue(s.isInRow(4,6));
		assertTrue(s.isInRow(6,6));
		assertTrue(s.isInRow(1,6));
		assertTrue(s.isInRow(3,6));
		assertTrue(s.isInRow(5,6));
		assertTrue(s.isInRow(7,6));
		
		assertTrue(s.isInRow(5,7));
		assertTrue(s.isInRow(7,7));
		assertTrue(s.isInRow(6,7));
		assertTrue(s.isInRow(9,7));
		assertTrue(s.isInRow(8,7));
		assertTrue(s.isInRow(1,7));
		assertTrue(s.isInRow(2,7));
		assertFalse(s.isInRow(3,7));
		assertFalse(s.isInRow(4,7));
		
		assertTrue(s.isInRow(3,8));
		assertTrue(s.isInRow(1,8));
		assertTrue(s.isInRow(2,8));
		assertTrue(s.isInRow(7,8));
		assertTrue(s.isInRow(5,8));
		assertTrue(s.isInRow(9,8));
		assertTrue(s.isInRow(6,8));
		assertFalse(s.isInRow(4,8));
		assertFalse(s.isInRow(8,8));
	}

	@Test
	public void testShowPuzzle() {
		s.showPuzzle();
	}

}