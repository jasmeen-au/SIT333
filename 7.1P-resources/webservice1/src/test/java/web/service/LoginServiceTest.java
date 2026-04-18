package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class LoginServiceTest {

    // ✅ Update if needed
    private static final String DRIVER_PATH = "C:\\Users\\skmdt\\Downloads\\chromedriver-win64(2)\\chromedriver-win64\\chromedriver.exe";

    // ✅ Correct file URL format
    private static final String FILE_PATH = "file:///D:/7.1P-resources/webservice1/src/main/resources/pages/login.html";

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ Common setup method
    private WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(FILE_PATH);
        sleep(2);
        return driver;
    }

    // ✅ Helper to set DOB properly
    private void setDOB(WebDriver driver, String date) {
        ((JavascriptExecutor) driver)
            .executeScript("document.getElementById('dob').value='" + date + "';");
    }

    // ✅ TEST 1: VALID LOGIN
    @Test
    public void testLoginSuccess() {
        WebDriver driver = setupDriver();

        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
        setDOB(driver, "2000-01-01");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("success", driver.getTitle());

        driver.quit();
    }

    // ❌ TEST 2: WRONG PASSWORD
    @Test
    public void testLoginFailWrongPassword() {
        WebDriver driver = setupDriver();

        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("passwd")).sendKeys("wrong_pass");
        setDOB(driver, "2000-01-01");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("fail", driver.getTitle());

        driver.quit();
    }

    // ❌ TEST 3: WRONG USERNAME
    @Test
    public void testLoginFailWrongUsername() {
        WebDriver driver = setupDriver();

        driver.findElement(By.id("username")).sendKeys("wrong_user");
        driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
        setDOB(driver, "2000-01-01");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("fail", driver.getTitle());

        driver.quit();
    }

    // ❌ TEST 4: WRONG DOB
    @Test
    public void testLoginFailWrongDob() {
        WebDriver driver = setupDriver();

        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
        setDOB(driver, "1999-01-01");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("fail", driver.getTitle());

        driver.quit();
    }

    // ❌ TEST 5: EMPTY INPUT
    @Test
    public void testLoginFailEmpty() {
        WebDriver driver = setupDriver();

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        Assert.assertEquals("fail", driver.getTitle());

        driver.quit();
    }
}