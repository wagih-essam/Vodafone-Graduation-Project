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

    private final By loginToYourAccountTitle = By.xpath("//div[@class='login-form']//h2");
    private final By emailAddressField = By.xpath("//div[@class='login-form']//input[@name='email']");
    private final By passwordField = By.xpath("//div[@class='login-form']//input[@name='password']");
    private final By loginButton = By.xpath("//div[@class='login-form']//button");



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

    public SignUpLoginPage verifyLogintitleIsVisible(){
        String loginToYourAccount = "Login to your account";
        String actialTitle = driver.findElement(loginToYourAccountTitle).getText();
        Assert.assertEquals(actialTitle , loginToYourAccount);
        return new SignUpLoginPage(driver);
    }

    public HomePage enterLoginData(String emailAddress , String password){
        driver.findElement(emailAddressField).sendKeys(emailAddress);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

}
