package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {

        // Step 1: Locate chrome driver
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\skmdt\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"
        );

        // Step 2: Open Chrome browser
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Open webpage
        driver.get(url);

        /*
         * Locate input fields and populate values
         */
        sleep(29);
        // First name
        WebElement element = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + element);
        element.sendKeys("Ahsan");

        // Last name
        WebElement lastname = driver.findElement(By.id("lastname"));
        lastname.sendKeys("Habib");

        // Email
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("ahsan123@email.com");

        // Phone
        WebElement phone = driver.findElement(By.id("phoneNumber"));
        phone.sendKeys("0400000000");

        // Weak password so form fails (as assignment requires)
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("12345");

        /*
         * Click Create Account button
         */
        WebElement createAccountButton =
                driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));

        createAccountButton.click();

        sleep(3);

        /*
         * Take screenshot using Selenium API
         */
        try {

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            FileHandler.copy(src, new File("officeworks_screenshot.png"));

            System.out.println("Demo screenshot saved.");

        } catch (IOException e) {

            e.printStackTrace();

        }

        sleep(2);

        // Close browser
        driver.close();
    }
    
    
    
    public static void demo_registration_page(String url) {

        System.setProperty(
        "webdriver.chrome.driver",
        "C:\\Users\\skmdt\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"
        );

        System.out.println("Opening demo registration page.");

        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get(url);

        // wait for page to load
        sleep(3);

        // First Name
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ahsan");

        // Last Name
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Habib");

        // Address
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Test Address Melbourne");

        // Email
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ahsan@email.com");

        // Phone
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0412345678");

        // Gender (Male)
        driver.findElement(By.xpath("//input[@value='Male']")).click();

        // Hobbies (Cricket)
        driver.findElement(By.id("checkbox1")).click();

        // Password
        driver.findElement(By.id("firstpassword")).sendKeys("12345");

        // Confirm Password
        driver.findElement(By.id("secondpassword")).sendKeys("12345");

        sleep(2);

        // Take Screenshot
        try {

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            FileHandler.copy(src, new File("demo_registration_screenshot.png"));

            System.out.println("Demo screenshot saved.");

        } catch (IOException e) {

            e.printStackTrace();

        }

        sleep(2);

        driver.close();
    }
    /*
     * Main method to run the program
     */
   

}