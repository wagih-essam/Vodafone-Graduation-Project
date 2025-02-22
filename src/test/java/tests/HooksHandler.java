package tests;

import driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import properties_reading.ReadPropertiesFile;

import java.io.IOException;

public class HooksHandler extends BaseTest{

    String automationExerciseLink;

    @Before(value = "@automationExercise" , order = 1)
    public void setAutomationExerciseLink() throws IOException {
        driver = WebDriverSingleton.getWebDriverSingleton();
        driver.resetCache();
        driver.maximizeWindow();

        if (System.getProperty("ENVIRONMENT").equalsIgnoreCase("Testing")){
            properties = ReadPropertiesFile.setTestingEnvironmentProperties();
            data = ReadPropertiesFile.setDataTestingProperties();
            automationExerciseLink = properties.getProperty("automationExerciseTestingLink");
            driver.navigateTo(automationExerciseLink);
        }
        else if(System.getProperty("ENVIRONMENT").equalsIgnoreCase("Production")){
            properties = ReadPropertiesFile.setProductionEnvironmentProperties();
            data = ReadPropertiesFile.setDataProductionProperties();
            automationExerciseLink = properties.getProperty("automationExerciseProductionLink");
            driver.navigateTo(automationExerciseLink);
        }
    }

    @After(value = "@automationExercise", order = 0)
    public void tearDownAutomationExercise(){
        driver.resetCache();
        closeWebDriverAfterAllTestsHook();
    }
    private void closeWebDriverAfterAllTestsHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            WebDriverSingleton.close();
        }));
    }
}
