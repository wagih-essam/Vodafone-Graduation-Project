package tests;

import io.cucumber.java.hu.De;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestCases extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case One")
    public void RegisterUser() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifySignUptitleIsVisible()
                .enterSignUpData("TestData","testtask1@vf.com")
                .verifyEnterAccountInformationVisibility()
                .enterAccountInformation("Pass@2020", "10","May","1995")
                .verifyAddressInformationVisibility()
                .enterAddressInformation("Test","Voda","VFCom","smart village","Canada","Manitoba","Toronto","12533","029965412")
                .verifyAccountCreationStatus().clickOnContinueButton()
                .verifyLoggedInVisibility().clickOnDeleteAccountButton()
                .verifyAccountDeletedStatus().clickOnContinueButton();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Two")
    public void LoginUserWithCorrectEmailAndPassword(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifyLogintitleIsVisible()
                .enterLoginData("testFake@vf.com" , "Pass@2020")
                .verifyLoggedInVisibility().logoutFromAccount();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Three")
    public void LoginUserWithInCorrectEmailAndPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifyLogintitleIsVisible()
                .enterLoginData("testNotValid@vf.com" , "Pass@2020")
                .verifyInValidLoginAlert();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Four")
    public void LogoutUser(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifyLogintitleIsVisible()
                .enterLoginData("testFake@vf.com" , "Pass@2020")
                .verifyLoggedInVisibility().logoutFromAccount();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Five")
    public void RegisterUserWithExistingEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifySignUptitleIsVisible()
                .enterSignUpData("TestData","testFake@vf.com")
                .verifyInValidRegisterAlert();
    }
}
