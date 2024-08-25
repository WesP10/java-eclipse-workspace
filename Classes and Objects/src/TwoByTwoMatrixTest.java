import static org.junit.Assert.*;

import org.junit.Test;

public class TwoByTwoMatrixTest {

	//unit testing - isolate components or "units" of our software and test them individually
	@Test
	public void testAddition() {
		TwoByTwoMatrix m1 = new TwoByTwoMatrix(1, 1, 1, 1);
		TwoByTwoMatrix m2 = new TwoByTwoMatrix(2, 3, 4, 5);
		TwoByTwoMatrix sum = m1.addition(m2);
		
		TwoByTwoMatrix answer = new TwoByTwoMatrix(3, 4, 5, 6);
		assertEquals(answer, sum);
	}

	
	
	
	
	
}
