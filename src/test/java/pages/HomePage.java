package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final By contactUsButton = By.xpath("//a[@href='/contact_us']");
    private final By testCasesButton = By.xpath("//a[@href='/test_cases']");
    private final By productsButton = By.xpath("//a[@href='/products']");
    private final By subscriptionSection = By.xpath("//div[@class='footer-widget']//h2[contains(text(), 'Subscription')]");
    private final By subscriptionEmailField = By.xpath("//input[@id='susbscribe_email']");
    private final By subscriptionButton = By.xpath("//button[@id='subscribe']");
    private final By subscriptionSuccessAlert = By.xpath("//div[@class='alert-success alert']");

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

    public ContactUsPage goToContactUsPage(){
        driver.findElement(contactUsButton).click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage goToTestCasesPage(){
        driver.findElement(testCasesButton).click();
        return new TestCasesPage(driver);
    }

    public ProductsPage goToProductsPage(){
        driver.findElement(productsButton).click();
        return new ProductsPage(driver);
    }

    public HomePage scrollDownToSubscription() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement subscription = driver.findElement(subscriptionSection);
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",subscription);
        return new HomePage(driver);
    }

    public HomePage enterEmailForSubscription(String emailsubscription){
        driver.findElement(subscriptionEmailField).sendKeys(emailsubscription);
        return new HomePage(driver);
    }

    public HomePage clickOnSubscriptionButton(){
        driver.findElement(subscriptionButton).click();
        return new HomePage(driver);
    }

    public HomePage verifySuccessSubscriptionAlert(){
        String subscriptionAlert = "You have been successfully subscribed!";
        String actualText = driver.findElement(subscriptionSuccessAlert).getText();
        Assert.assertEquals(actualText,subscriptionAlert);
        return new HomePage(driver);
    }

}
