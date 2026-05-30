package driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverSingleton {

    private static WebDriver webDriver;
    private static WebDriverSingleton webDriverSingleton = null;

    private WebDriverSingleton() {
        setDriverCapabilities(System.getProperty("BROWSERNAME"));
    }
    public static WebDriverSingleton getWebDriverSingleton(){
        if (webDriverSingleton == null)
            webDriverSingleton = new WebDriverSingleton();
        return webDriverSingleton;
    }

    private void setDriverCapabilities(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
            webDriver = new ChromeDriver(chromeOptions);
        }else if (browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }
    public void navigateTo(String link){
        webDriver.navigate().to(link);
    }
    public void refreshCurrentUrl(){
        webDriver.navigate().refresh();
    }
    public void resetCache(){
        webDriver.manage().deleteAllCookies();
    }
    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }
    public static void close(){
        if (webDriver != null) {
            try {
                webDriver.quit();
            } catch (Exception e) {
                System.err.println("Error closing WebDriver: " + e.getMessage());
            }
            webDriver = null;
        }
        webDriverSingleton = null;
    }
}
