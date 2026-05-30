package tests;

import driver.WebDriverSingleton;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    protected static Properties properties;
    protected static Properties data;
    public Wait<WebDriver> wait;

    @BeforeMethod
    public void setUp(){
        try {
            // Set default browser if not already set
            if (System.getProperty("BROWSERNAME") == null) {
                System.setProperty("BROWSERNAME", "chrome");
            }

            // Close any existing driver from previous test
            WebDriverSingleton.close();

            // Get fresh WebDriver instance from singleton
            WebDriverSingleton driverSingleton = WebDriverSingleton.getWebDriverSingleton();
            driver = driverSingleton.getWebDriver();

            if (driver == null) {
                throw new RuntimeException("Failed to initialize WebDriver - driver is null");
            }

            // Maximize window
            driverSingleton.maximizeWindow();

            // Setup FluentWait
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NotFoundException.class)
                    .ignoring(ElementNotInteractableException.class)
                    .ignoring(AssertionError.class)
                    .ignoring(StaleElementReferenceException.class);
        } catch (Exception e) {
            System.err.println("Error during test setup: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Test setup failed", e);
        }
    }

    @AfterMethod
    public void tearDown(){
        try {
            WebDriverSingleton.close();
        } catch (Exception e) {
            System.err.println("Error during test teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
