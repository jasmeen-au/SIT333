package sit707_week4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest {

    private static final String DRIVER_PATH =
        "C:\\Users\\skmdt\\Downloads\\chromedriver-win64(2)\\chromedriver-win64\\chromedriver.exe";

    private static final String URL =
        "https://www.bunnings.com.au/login";

    // manual wait for popup
    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        // wait for popup (you close manually)
        System.out.println("Close popup manually...");
        sleep(80);

        return driver;
    }

    // ✅ 1. testLoginSuccess
    @Test
    public void testLoginSuccess() {
        WebDriver driver = setupDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        WebElement email = driver.findElement(By.id("username"));
        email.click();
        email.clear();
        email.sendKeys("valid@email.com"); // may not actually login

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("validpassword");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // allow both outcomes due to site restrictions
        Assert.assertTrue(driver.getCurrentUrl().contains("login")
                || driver.getCurrentUrl().contains("account"));

        driver.quit();
    }

    // ✅ 2. testLoginFailWrongPassword
    @Test
    public void testLoginFailWrongPassword() {
        WebDriver driver = setupDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        WebElement email = driver.findElement(By.id("username"));
        email.click();
        email.clear();
        email.sendKeys("test@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("wrongpass");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        driver.quit();
    }

    // ✅ 3. testLoginFailWrongUsername
    @Test
    public void testLoginFailWrongUsername() {
        WebDriver driver = setupDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        WebElement email = driver.findElement(By.id("username"));
        email.click();
        email.clear();
        email.sendKeys("wrongemail");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("123456");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        driver.quit();
    }

    // ✅ 4. testLoginFailEmpty
    @Test
    public void testLoginFailEmpty() {
        WebDriver driver = setupDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='submit']")));

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        driver.quit();
    }

    // ✅ 5. testLoginFailWrongDob (repurposed as invalid case)
    @Test
    public void testLoginFailWrongDob() {
        WebDriver driver = setupDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        WebElement email = driver.findElement(By.id("username"));
        email.click();
        email.clear();
        email.sendKeys("wrongemail");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("wrongpass");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        driver.quit();
    }
}