package test.es.unex.cum.mdp.sesion1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import sesion01.Calculator;


public class TestCalculator {

	private Calculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		calc = null;
	}

	@Test
	public void testAdd() {
		double result = calc.add(10.5, 20.32);
		assertEquals(30.82, result, 0);
	}

	@Test
	public void testSubtract() {		
		double result = calc.subtract(100.5, 100);
		assertEquals(0.5, result, 0);
	}

	@Test
	public void testMultiply() {
		double result = calc.multiply(2.5, 100);
		assertEquals(250, result, 0);
	}

	@Test
	public void testDivide() {
		double result = calc.divide(100, 10);
		assertEquals(10, result, 0.001);
		try {
			calc.divide(100.5, 0);
			fail();
		} catch (ArithmeticException e) {
			assertTrue(true);
		}

	}

}