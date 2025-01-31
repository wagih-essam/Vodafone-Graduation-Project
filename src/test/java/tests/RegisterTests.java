package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class RegisterTests extends BaseTest {

    @Test
    public void TestCaseOne() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
            homePage.navigateToAutomationHomePage().verifyHomePageVisibility()
                    .goToSignUpLoginPage().verifySignUptitleIsVisible()
                    .enterSignUpData("TestData","testtask@vf.com")
                    .verifyEnterAccountInformationVisibility()
                    .enterAccountInformation("Pass@2020", "10","May","1995")
                    .verifyAddressInformationVisibility()
                    .enterAddressInformation("Test","Voda","VFCom","smart village","Canada","Manitoba","Toronto","12533","029965412")
                    .verifyAccountCreationStatus().clickOnContinueButton()
                    .verifyLoggedInVisibility().clickOnDeleteAccountButton()
                    .verifyAccountDeletedStatus().clickOnContinueButton();
    }

}
