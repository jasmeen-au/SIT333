package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.text.SimpleDateFormat;
import java.util.Date;

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

        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.0001);
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

        Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0.0001);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        double sumTemp = 0;

        for (int i = 0; i < nHours; i++) {
            sumTemp += temperatures[i];
        }

        double averageTemp = sumTemp / nHours;

        Assert.assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0.0001);
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        // Arrange
        String beforeTime = new SimpleDateFormat("H:m:s").format(new Date());

        // Act
        String persistTime = wController.persistTemperature(10, 19.5);

        String afterTime = new SimpleDateFormat("H:m:s").format(new Date());

        System.out.println("Before: " + beforeTime);
        System.out.println("Persist: " + persistTime);
        System.out.println("After: " + afterTime);

        // Assert 
        boolean isValid =
                persistTime.equals(beforeTime) ||
                persistTime.equals(afterTime);

        Assert.assertTrue("Persist time not within expected range", isValid);
    }
}