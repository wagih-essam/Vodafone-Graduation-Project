package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    String url = "https://automationexercise.com/";
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By signUpLoginButton = By.xpath("//a[@href='/login']");
    private final By loggedInField = By.xpath("//li[10]//a/b");
    private final By deleteAccountButton = By.xpath("//i[@class='fa fa-trash-o']");
    private final By accountDeletedStatusField = By.xpath("//h2[@data-qa='account-deleted']");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private final By logoutButton = By.xpath("//i[@class='fa fa-lock']");
    private final By invalidLoginAlert = By.xpath("//form//p");


    public HomePage navigateToAutomationHomePage(){
        driver.navigate().to(url);
        return this;
    }
    public SignUpLoginPage goToSignUpLoginPage(){
        driver.findElement(signUpLoginButton).click();
        return new SignUpLoginPage(driver);
    }

    public HomePage verifyHomePageVisibility(){
        String automationPage = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle , automationPage);
        return new HomePage(driver);
    }

    public HomePage verifyLoggedInVisibility(){
        String loggedInText = "Logged in as TestData";
        String actualText = driver.findElement(loggedInField).getText();
        return new HomePage(driver);
    }

    public HomePage clickOnDeleteAccountButton(){
        driver.findElement(deleteAccountButton).click();
        return new HomePage(driver);
    }

    public HomePage verifyAccountDeletedStatus(){
        String accountStatus = "ACCOUNT DELETED!";
        String actualStatus = driver.findElement(accountDeletedStatusField).getText();
        Assert.assertEquals(actualStatus,accountStatus);
        return new HomePage(driver);
    }

    public HomePage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }

    public HomePage logoutFromAccount(){
        driver.findElement(logoutButton).click();
        return new HomePage(driver);
    }

    public HomePage verifyInValidLoginAlert(){
        String invalidloginalert = "Your email or password is incorrect!";
        String actualalert = driver.findElement(invalidLoginAlert).getText();
        Assert.assertEquals(actualalert,invalidloginalert);
        return new HomePage(driver);
    }

}
