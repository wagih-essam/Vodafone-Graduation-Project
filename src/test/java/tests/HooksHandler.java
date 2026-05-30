package tests;

import driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import properties_reading.ReadPropertiesFile;

import java.io.IOException;

public class HooksHandler extends BaseTest{

    String automationExerciseLink;
    private WebDriverSingleton driverSingleton;

    @Before(value = "@automationExercise" , order = 1)
    public void setAutomationExerciseLink() throws IOException {
        // Set default browser if not already set
        if (System.getProperty("BROWSERNAME") == null) {
            System.setProperty("BROWSERNAME", "chrome");
        }

        try {
            // Close any existing driver from previous test
            WebDriverSingleton.close();

            // Get fresh WebDriver instance from singleton
            driverSingleton = WebDriverSingleton.getWebDriverSingleton();
            driver = driverSingleton.getWebDriver();

            if (driver == null) {
                throw new RuntimeException("Failed to initialize WebDriver - driver is null");
            }

            driverSingleton.resetCache();
            driverSingleton.maximizeWindow();

            if (System.getProperty("ENVIRONMENT").equalsIgnoreCase("Testing")){
                properties = ReadPropertiesFile.setTestingEnvironmentProperties();
                data = ReadPropertiesFile.setDataTestingProperties();
                automationExerciseLink = properties.getProperty("automationExerciseTestingLink");
                driverSingleton.navigateTo(automationExerciseLink);
            }
            else if(System.getProperty("ENVIRONMENT").equalsIgnoreCase("Production")){
                properties = ReadPropertiesFile.setProductionEnvironmentProperties();
                data = ReadPropertiesFile.setDataProductionProperties();
                automationExerciseLink = properties.getProperty("automationExerciseProductionLink");
                driverSingleton.navigateTo(automationExerciseLink);
            }
        } catch (Exception e) {
            System.err.println("Error during Cucumber setup: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Cucumber setup failed", e);
        }
    }

    @After(value = "@automationExercise", order = 0)
    public void tearDownAutomationExercise(){
        try {
            if (driverSingleton != null) {
                driverSingleton.resetCache();
            }
            closeWebDriverAfterAllTestsHook();
        } catch (Exception e) {
            System.err.println("Error during Cucumber teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void closeWebDriverAfterAllTestsHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            WebDriverSingleton.close();
        }));
    }
}
