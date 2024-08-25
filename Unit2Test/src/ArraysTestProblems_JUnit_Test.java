import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArraysTestProblems_JUnit_Test {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void testReturnMaxValue() {
		ArrayList<Double> vals = new ArrayList<Double>();
		vals.add(-2.3);
		vals.add(-10.5);
		vals.add(-1.2);
		vals.add(-20.75);
		assertEquals(-1.2,ArraysTestProblems.returnMaxValue(vals),.00001);
	}

	@Test
	public void testReturnMinValue() {
		int[] vals = {8,15,4,16,42,23};
		assertEquals(4,ArraysTestProblems.returnMinValue(vals));
	}

	@Test
	public void testFindIndexesOfMax() {
		ArrayList<Integer> vals = new ArrayList<Integer>();
		vals.add(-1);
		vals.add(-55);
		vals.add(-1);
		vals.add(-2);
		vals.add(-3);
		vals.add(-1);
		int[] result = ArraysTestProblems.findIndexesOfMax(vals);
		assertTrue(result.length == 3);
		assertEquals(0,result[0]);
		assertEquals(2,result[1]);
		assertEquals(5,result[2]);
	}

	@Test
	public void testReturnValsInReverseOrder() {
		ArrayList<String> words = new ArrayList<String>();
		words.add("Zuzu");
		words.add("Mildred");
		words.add("Taz");
		words.add("Dude");
		String[] reversed = ArraysTestProblems.returnValsInReverseOrder(words);
		assertTrue(reversed.length == 4);
		assertEquals("eduD",reversed[0]);
		assertEquals("zaT",reversed[1]);
		assertEquals("derdliM",reversed[2]);
		assertEquals("uzuZ",reversed[3]);
	}

	@Test
	public void testReturnListOfPositives() {
		double[] vals = {1.1, -2.3, 5.8, -13.21, -34.55};
		ArrayList<Double> positives = ArraysTestProblems.returnListOfPositives(vals);
		assertTrue(positives.size() == 2);
		assertEquals(1.1,positives.get(0),.0001);
		assertEquals(5.8,positives.get(1),.0001);
	}

	@Test
	public void testConcatenate() {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Zuzu");
		list1.add("Taz");
		list1.add("Helga");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Dude");
		list2.add("Eloise");
		String[] cat = ArraysTestProblems.concatenate(list1, list2);
		assertTrue(cat.length == 5);
		assertEquals("Zuzu",cat[0]);
		assertEquals("Taz",cat[1]);
		assertEquals("Helga",cat[2]);
		assertEquals("Dude",cat[3]);
		assertEquals("Eloise",cat[4]);
	}

	@Test
	public void testRemoveRectanglesWithArea72() {
		ArrayList<Rectangle> list = new ArrayList<Rectangle>();
		list.add(new Rectangle(new Point(2, 8)));
		list.add(new Rectangle());
		list.add(new Rectangle(0, 0,  9, 8));
		list.add(new Rectangle(5, 4));
		ArraysTestProblems.removeRectanglesWithArea72(list);
		assertTrue(list.size() == 3);
	}

	@Test
	public void testReflectAllPointsInYAxis() {
		Point[] points = new Point[3];
		points[0] = new Point(3, 7);
		points[1] = new Point(-1, -3);
		points[2] = new Point(0, -5);
		ArraysTestProblems.reflectAllPointsInYAxis(points);
		assertEquals(new Point(-3, 7),points[0]);
		assertEquals(new Point(1, -3),points[1]);
		assertEquals(new Point(0, -5),points[2]);
	}

	@Test
	public void testCreateAndReturnPoints() {
		int[] xV = new int[5];
		xV[0] = 0;
		xV[1] = -8;
		xV[2] = 9;
		xV[3] = 3;
		xV[4] = -16;
		int[] yV = new int[5];
		yV[0] = 9;
		yV[1] = -8;
		yV[2] = 7;
		yV[3] = -2;
		yV[4] = 6;
		Point[] p = ArraysTestProblems.createAndReturnPoints(xV, yV);
		assertEquals(new Point(0, 9),p[0]);
		assertEquals(new Point(-8, -8),p[1]);
		assertEquals(new Point(9, 7),p[2]);
		assertEquals(new Point(3, -2),p[3]);
		assertEquals(new Point(-16, 6),p[4]);
	}

	@Test
	public void testOutside() {
		ArrayList<Point> p = new ArrayList<Point>();
		double r = 5;
		p.add(new Point());
		p.add(new Point(3, 4));
		p.add(new Point(4, 8));
		boolean[] b = ArraysTestProblems.outside(p, r);
		assertEquals(false,b[0]);
		assertEquals(false,b[1]);
		assertEquals(true,b[2]);
	}

	@Test
	public void testRotateLeftOneCell() {
		String[] s = new String[8];
		for(int i = 0; i < s.length; i++)
			s[i] = "" + i;
		ArraysTestProblems.rotateLeftOneCell(s);
		assertEquals("1",s[0]);
		assertEquals("2",s[1]);
		assertEquals("3",s[2]);
		assertEquals("4",s[3]);
		assertEquals("5",s[4]);
		assertEquals("6",s[5]);
		assertEquals("7",s[6]);
		assertEquals("0",s[7]);
	}

	@Test
	public void testPrint2DArray() {
		char[][] c = new char[2][3];
		c[0][0] = 'a';
		c[0][1] = 'b';
		c[0][2] = 'c';
		c[1][0] = 'a';
		c[1][1] = 'b';
		c[1][2] = 'c';
		ArraysTestProblems.print2DArray(c);
		assertEquals("a b c "+ '\n' + "a b c \n" + '\n', outContent.toString());
	}

	@Test
	public void testReturnMaxValue2DArray() {
		double[][] d = new double[3][5];
		d[0][0] = 5;
		d[0][1] = 4;
		d[0][2] = 7;
		d[0][3] = -21;
		d[0][4] = 9;
		d[1][0] = 35.9;
		d[1][1] = 4;
		d[1][2] = 7;
		d[1][3] = 0;
		d[1][4] = 9;
		d[2][0] = 5;
		d[2][1] = 44;
		d[2][2] = 7.09;
		d[2][3] = 1;
		d[2][4] = 9;
		double max = ArraysTestProblems.returnMaxValue(d);
		assertEquals(44, max, 0.000001);
	}

}
