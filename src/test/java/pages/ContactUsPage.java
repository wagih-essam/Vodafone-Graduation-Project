package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By getInTouchTitle = By.xpath("//div[@class='contact-form']//h2[@class='title text-center']");
    private final By contactUsNameField = By.xpath("//div[@class='contact-form']//input[@name='name']");
    private final By contactUsEmailField = By.xpath("//div[@class='contact-form']//input[@name='email']");
    private final By contactUsSubjectField = By.xpath("//div[@class='contact-form']//input[@name='subject']");
    private final By contactUsYourMessageField = By.xpath("//div[@class='contact-form']//textarea[@id='message']");
    private final By contactUsChooseFileButton = By.xpath("//input[@name='upload_file']");
    private final String filePath = "E:\\PIC\\EgyptFlag.png";
    private final By contactUsSubmitButton = By.xpath("//input[@name='submit']");
    private final By contactUsSuccessfulMessage = By.xpath("//div[@class='status alert alert-success']");

    public ContactUsPage verifygetInTouchTitleIsVisible(){
        String getInTouchText = "GET IN TOUCH";
        String actialTitle = driver.findElement(getInTouchTitle).getText();
        Assert.assertEquals(actialTitle , getInTouchText);
        return new ContactUsPage(driver);
    }
    public ContactUsPage enterNameInContactUs(String name){
        driver.findElement(contactUsNameField).sendKeys(name);
        return new ContactUsPage(driver);
    }
    public ContactUsPage enterEmailInContactUs(String email){
        driver.findElement(contactUsEmailField).sendKeys(email);
        return new ContactUsPage(driver);
    }
    public ContactUsPage enterSubjectInContactUs(String subject){
        driver.findElement(contactUsSubjectField).sendKeys(subject);
        return new ContactUsPage(driver);
    }
    public ContactUsPage enterYourMessageInContactUs(String message){
        driver.findElement(contactUsYourMessageField).sendKeys(message);
        return new ContactUsPage(driver);
    }
    public ContactUsPage uploadFileInContactUs(){
        WebElement uploadElement = driver.findElement(contactUsChooseFileButton);
        uploadElement.sendKeys(filePath);
        return new ContactUsPage(driver);
    }
    public ContactUsPage clickOnSubmitButton(){
        driver.findElement(contactUsSubmitButton).click();
        return new ContactUsPage(driver);
    }
    public ContactUsPage acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new ContactUsPage(driver);
    }
    public void verifySuccessfulMessageIsVisible(){
        String successfulText = "Success! Your details have been submitted successfully.";
        String actualText = driver.findElement(contactUsSuccessfulMessage).getText();
        Assert.assertEquals(actualText,successfulText);
    }
}
