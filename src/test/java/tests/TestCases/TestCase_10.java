package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_10 extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Ten")
    public void verifySubscriptionInHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .scrollDownToSubscription().enterEmailForSubscription("test@VF.com")
                .clickOnSubscriptionButton().verifySuccessSubscriptionAlert();

    }
}
