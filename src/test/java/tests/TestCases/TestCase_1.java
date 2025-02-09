package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TestCase_1 extends BaseTest {
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
}
