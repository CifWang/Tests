package testJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	public static Calculator c=new Calculator();

	@BeforeEach
	void setUp() throws Exception {
		c.clear();
	}

	@Test
	void testAdd() {
		c.add(3);
		c.add(4);
		assertEquals(7,c.getResults());//看是否相等来测试
	}

	@Test
	void testSubstract() {
		c.add(8);
		c.substract(3);
		assertEquals(5,c.getResults());
	}

	@Test
	void testMultiply() {
		c.add(2);
		c.multiply(2);
		assertEquals(4,c.getResults());
	}

	@Test
	void testDivide() {
		c.add(9);
		c.divide(3);
		assertEquals(3,c.getResults());
	}

}
