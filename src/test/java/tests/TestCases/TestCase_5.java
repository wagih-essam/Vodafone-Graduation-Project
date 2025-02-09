package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_5 extends BaseTest {
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
