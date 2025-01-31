package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpLoginPage extends BasePage {

    public SignUpLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By newUserSignUpTitle = By.xpath("//div[@class='signup-form']//h2");
    private final By userNameField = By.xpath("//div[@class='signup-form']//input[@name='name']");
    private final By userEmailField = By.xpath("//div[@class='signup-form']//input[@name='email']");
    private final By signUpButton = By.xpath("//div[@class='signup-form']//button");



    public SignUpLoginPage verifySignUptitleIsVisible(){
        String newUserSignUp = "New User Signup!";
        String actialTitle = driver.findElement(newUserSignUpTitle).getText();
        Assert.assertEquals(actialTitle , newUserSignUp);
        return new SignUpLoginPage(driver);
    }

    public SignUpPage enterSignUpData(String userName , String userEmail){
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(userEmailField).sendKeys(userEmail);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

}
