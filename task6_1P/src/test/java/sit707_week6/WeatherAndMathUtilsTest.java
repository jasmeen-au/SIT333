package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "225142581";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Jasmeen";
		Assert.assertNotNull("Student name is null", studentName);
	}

	// ================= WEATHER TESTS =================

	@Test
	public void testCancelWeatherAdvice_Wind() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(71.0, 1.0));
	}

	@Test
	public void testCancelWeatherAdvice_Rain() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 7.0));
	}

	@Test
	public void testCancelWeatherAdvice_Combined() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 5.0));
	}

	@Test
	public void testWarnWeatherAdvice_Wind() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
	}

	@Test
	public void testWarnWeatherAdvice_Rain() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(10.0, 5.0));
	}

	@Test
	public void testAllClearWeatherAdvice() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 2.0));
	}

	// ================= isEven TESTS =================

	@Test
	public void testEvenNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}

	@Test
	public void testOddNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(5));
	}

	// ================= isPrime TESTS =================

	@Test
	public void testPrimeNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
	}

	@Test
	public void testNonPrimeNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(8));
	}

	@Test
	public void testPrimeEdgeCaseOne() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
	}
}
