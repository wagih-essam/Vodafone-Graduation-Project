package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage extends BasePage{
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By testCasesTitle = By.xpath("//h2[@class='title text-center']//b");

    public void verifyTestCasesTitle(){
        String testCasesText = "TEST CASES";
        String actualText = driver.findElement(testCasesTitle).getText();
        Assert.assertEquals(actualText , testCasesText);
    }
}
