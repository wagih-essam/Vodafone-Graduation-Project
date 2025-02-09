package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_3 extends BaseTest {
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
}
