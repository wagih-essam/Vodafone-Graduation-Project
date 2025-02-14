package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_9 extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Nine")
    public void searchProduct(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToProductsPage().verifyAllProductsTitleIsVisible()
                .enterProductInSearch("Fancy Green Top")
                .clickOnSearchIcon().verifySearchResult();
    }
}
