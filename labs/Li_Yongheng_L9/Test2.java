package lab09green;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
		assertEquals("0 = 0", new Question3(0).toString());
		assertEquals("1 = 1", new Question3(1).toString());
		assertEquals("67 = 67", new Question3(67).toString());
		assertEquals("1616615 = 5 x 7 x 11 x 13 x 17 x 19", new Question3(1616615).toString());
	}

}
