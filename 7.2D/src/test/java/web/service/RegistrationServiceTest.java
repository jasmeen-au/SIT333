package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class RegistrationServiceTest {

    // ✅ Same driver path as your login test
    private static final String DRIVER_PATH = "C:\\Users\\skmdt\\Downloads\\chromedriver-win64(2)\\chromedriver-win64\\chromedriver.exe";

    // ✅ CHANGE: Now pointing to register.html
    private static final String FILE_PATH = "file:///D:/7.1P-resources/webservice1/src/main/resources/pages/register.html";

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ Common setup
    private WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(FILE_PATH);
        sleep(2);
        return driver;
    }

    // ✅ Helper to set DOB
    private void setDOB(WebDriver driver, String date) {
        ((JavascriptExecutor) driver)
            .executeScript("document.getElementById('dob').value='" + date + "';");
    }

    // ✅ TEST 1: VALID REGISTRATION
    @Test
    public void testRegistrationSuccess() {
        WebDriver driver = setupDriver();

        driver.findElement(By.id("fname")).sendKeys("John");
        driver.findElement(By.id("lname")).sendKeys("Doe");
        driver.findElement(By.id("email")).sendKeys("john@gmail.com");
        setDOB(driver, "2000-01-01");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("success", driver.getTitle());

        driver.quit();
    }

    // ❌ TEST 2: INVALID EMAIL
    @Test
    public void testRegistrationFailInvalidEmail() {
        WebDriver driver = setupDriver();

        driver.findElement(By.id("fname")).sendKeys("John");
        driver.findElement(By.id("lname")).sendKeys("Doe");
        driver.findElement(By.id("email")).sendKeys("wrongemail");
        setDOB(driver, "2000-01-01");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("fail", driver.getTitle());

        driver.quit();
    }

    // ❌ TEST 3: EMPTY INPUT
    @Test
    public void testRegistrationFailEmpty() {
        WebDriver driver = setupDriver();

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("fail", driver.getTitle());

        driver.quit();
    }

    // ❌ TEST 4: SHORT NAME
    @Test
    public void testRegistrationFailShortName() {
        WebDriver driver = setupDriver();

        driver.findElement(By.id("fname")).sendKeys("J");
        driver.findElement(By.id("lname")).sendKeys("D");
        driver.findElement(By.id("email")).sendKeys("john@gmail.com");
        setDOB(driver, "2000-01-01");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("fail", driver.getTitle());

        driver.quit();
    }
}