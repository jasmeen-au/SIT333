package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class WeatherControllerTest {

	static WeatherController wController;
	static double[] temperatures;
	static int nHours;

	@BeforeClass
	public static void setup() {
		wController = WeatherController.getInstance();

		nHours = wController.getTotalHours();
		temperatures = new double[nHours];

		for (int i = 0; i < nHours; i++) {
			temperatures[i] = wController.getTemperatureForHour(i + 1);
		}
	}

	@AfterClass
	public static void teardown() {
		wController.close();
	}

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

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

		double minTemperature = 1000;

		for (int i = 0; i < nHours; i++) {
			double temperatureVal = temperatures[i];
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}

		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
	}

	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		double maxTemperature = -1;

		for (int i = 0; i < nHours; i++) {
			double temperatureVal = temperatures[i];
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}

		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		double sumTemp = 0;

		for (int i = 0; i < nHours; i++) {
			double temperatureVal = temperatures[i];
			sumTemp += temperatureVal;
		}

		double averageTemp = sumTemp / nHours;

		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
	}

	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}