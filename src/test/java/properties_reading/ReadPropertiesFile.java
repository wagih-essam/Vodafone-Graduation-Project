package properties_reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    private static final String automationExerciseTestingEnvironmentConfigPath = System.getProperty("user.dir")+"/resources/config/website-testing-config.properties";
    private static final String automationExerciseProductionEnvironmentConfigPath = System.getProperty("user.dir")+"/resources/config/website-production-config.properties";
    private static final String dataTestingEnvironmentConfigPath = System.getProperty("user.dir")+"/resources/config/data-testing-config.properties";
    private static final String dataProductionEnvironmentConfigPath = System.getProperty("user.dir")+"/resources/config/data-production-config.properties";

    public static Properties setTestingEnvironmentProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(automationExerciseTestingEnvironmentConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }

    public static Properties setProductionEnvironmentProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(automationExerciseProductionEnvironmentConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }

    public static Properties setDataTestingProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(dataTestingEnvironmentConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }

    public static Properties setDataProductionProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(dataProductionEnvironmentConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }

}
