package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_4 extends BaseTest {
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
}
