package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class TestCases extends BaseTest {

    @Test
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
    public void LoginUserWithCorrectEmailAndPassword(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifyLogintitleIsVisible()
                .enterLoginData("testFake@vf.com" , "Pass@2020")
                .verifyLoggedInVisibility().logoutFromAccount();
    }

    @Test
    public void LoginUserWithInCorrectEmailAndPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifyLogintitleIsVisible()
                .enterLoginData("testNotValid@vf.com" , "Pass@2020")
                .verifyInValidLoginAlert();
    }

    @Test
    public void LogoutUser(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToSignUpLoginPage().verifyLogintitleIsVisible()
                .enterLoginData("testFake@vf.com" , "Pass@2020")
                .verifyLoggedInVisibility().logoutFromAccount();
    }
}
