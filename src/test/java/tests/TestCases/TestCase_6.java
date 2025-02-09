package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_6 extends BaseTest {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Two")
    public void ContactUsForm() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility().goToContactUsPage()
                .verifygetInTouchTitleIsVisible().enterNameInContactUs("test")
                .enterSubjectInContactUs("Test Subject").enterEmailInContactUs("test@VF.com")
                .enterYourMessageInContactUs("testing").uploadFileInContactUs()
                .clickOnSubmitButton().acceptAlert().verifySuccessfulMessageIsVisible();
    }
}
