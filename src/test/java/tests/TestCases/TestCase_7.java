package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_7 extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Seven")
    public void verifyTestCasesPage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToTestCasesPage().verifyTestCasesTitle();
    }
}
