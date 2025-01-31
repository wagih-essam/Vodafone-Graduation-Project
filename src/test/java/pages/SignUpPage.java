package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    private final By enterAccInfoField = By.xpath("//b[contains(text(), 'Enter Account Information')]");
    private final By titleRadioBox = By.xpath("//div[@class='radio-inline'][1]");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By birthDateDayDropdown = By.xpath("//select[@id='days']");
    private final By birthDateMonthDropdown = By.xpath("//select[@id='months']");
    private final By birthDateYearDropdown = By.xpath("//select[@id='years']");
    private final By newsletterCheckbox = By.xpath("//input[@id='newsletter']");
    private final By specialOffersCheckbox = By.xpath("//input[@id='optin']");
    private final By enterAddInfoField = By.xpath("//b[contains(text(), 'Address Information')]");
    private final By firstNameField = By.xpath("//input[@id='first_name']");
    private final By lastNameField = By.xpath("//input[@id='last_name']");
    private final By companyField = By.xpath("//input[@id='company']");
    private final By addressField = By.xpath("//input[@id='address1']");
    private final By countryDropDown = By.xpath("//select[@id='country']");
    private final By stateField = By.xpath("//input[@id='state']");
    private final By cityField = By.xpath("//input[@id='city']");
    private final By zipcodeField = By.xpath("//input[@id='zipcode']");
    private final By mobileNumberField = By.xpath("//input[@id='mobile_number']");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private final By accountCreationStatusField = By.xpath("//h2[@data-qa='account-created']");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");



    public SignUpPage verifyEnterAccountInformationVisibility(){
        String enterAccInfoText = "ENTER ACCOUNT INFORMATION";
        String actualText = driver.findElement(enterAccInfoField).getText();
        Assert.assertEquals(actualText,enterAccInfoText);
        return new SignUpPage(driver);
    }

    public SignUpPage enterAccountInformation(String password , String birthDateDay , String birthDateMonth , String birthDateYear){
        driver.findElement(titleRadioBox).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(birthDateDayDropdown).sendKeys(birthDateDay);
        driver.findElement(birthDateMonthDropdown).sendKeys(birthDateMonth);
        driver.findElement(birthDateYearDropdown).sendKeys(birthDateYear);
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(specialOffersCheckbox).click();
        return new SignUpPage(driver);
    }

    public SignUpPage verifyAddressInformationVisibility(){
        String enterAddInfoText = "ADDRESS INFORMATION";
        String actualText = driver.findElement(enterAddInfoField).getText();
        Assert.assertEquals(actualText,enterAddInfoText);
        return new SignUpPage(driver);
    }

    public SignUpPage enterAddressInformation(String firstName , String lastName , String company ,String address ,String country ,String state ,String city ,String zipcode ,String mobileNumber){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(countryDropDown).sendKeys(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
        driver.findElement(createAccountButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage verifyAccountCreationStatus(){
        String accountStatus = "ACCOUNT CREATED!";
        String actualStatus = driver.findElement(accountCreationStatusField).getText();
        Assert.assertEquals(actualStatus,accountStatus);
        return new SignUpPage(driver);
    }
    public HomePage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}
