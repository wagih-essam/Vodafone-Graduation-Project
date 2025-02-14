package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import tests.BaseTest;

public class TestCase_8 extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Eight")
    public void verifyAllProductsAndProductDetailPage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToProductsPage().verifyAllProductsTitleIsVisible()
                .validateProductsList(ProductsPage.validProductsElements)
                .clickOnFirstProduct().verifyProductImageIsVisible().verifyFirstProductDetails();
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Eight-2")
    public void verifyInvalidAllProductsAndProductDetailPage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                .goToProductsPage().verifyAllProductsTitleIsVisible()
                .validateProductsList(ProductsPage.inValidProductsElements);
    }

}
