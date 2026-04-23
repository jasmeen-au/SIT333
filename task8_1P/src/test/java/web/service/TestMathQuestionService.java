package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	// Q1 Addition - valid input
	@Test
	public void testTrueAdd() {
		Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.0001);
	}

	// Q1 Addition - empty input
	@Test(expected = IllegalArgumentException.class)
	public void testAddNumber1Empty() {
		MathQuestionService.q1Addition("", "2");
	}

	// Q1 Addition - invalid input
	@Test(expected = IllegalArgumentException.class)
	public void testAddInvalidInput() {
		MathQuestionService.q1Addition("abc", "2");
	}

	// Q2 Subtraction - valid
	@Test
	public void testSubtractionValid() {
		Assert.assertEquals(2.0, MathQuestionService.q2Subtraction("5", "3"), 0.0001);
	}

	// Q2 Subtraction - invalid
	@Test(expected = IllegalArgumentException.class)
	public void testSubtractionInvalid() {
		MathQuestionService.q2Subtraction("x", "3");
	}

	// Q3 Multiplication - valid
	@Test
	public void testMultiplicationValid() {
		Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0.0001);
	}

	// Q3 Multiplication - empty
	@Test(expected = IllegalArgumentException.class)
	public void testMultiplicationEmpty() {
		MathQuestionService.q3Multiplication("", "3");
	}
}