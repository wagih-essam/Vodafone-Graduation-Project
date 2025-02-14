package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    private final By allProductsTitle = By.xpath("//div[@class='features_items']/h2");
    private final By firstProduct = By.xpath("//a[@href='/product_details/1']");
    private final By firstProductName = By.xpath("//div[@class='product-information']/h2");
    private final By firstProductCategory = By.xpath("//div[@class='product-information']/p[1]");
    private final By firstProductAvailability = By.xpath("//div[@class='product-information']/p[2]");
    private final By firstProductCondition = By.xpath("//div[@class='product-information']/p[3]");
    private final By firstProductBrand = By.xpath("//div[@class='product-information']/p[4]");
    private By listOfProducts(String productName){
        return By.xpath("//div[@class='col-sm-4']//p[contains(text(), '"+productName+"')]");
    }
    private final By productImage = By.xpath("//div[@class='view-product']//img");



    public ProductsPage verifyAllProductsTitleIsVisible(){
        String allProducts = "ALL PRODUCTS";
        String actualTitle = driver.findElement(allProductsTitle).getText();
        Assert.assertEquals(actualTitle,allProducts);
        return new ProductsPage(driver);
    }

    public static List<String> validProductsElements = Arrays.asList("Blue Top", "Men Tshirt", "Sleeveless Dress");
    public static List<String> inValidProductsElements = Arrays.asList("Blue Top", "Man Tshirt", "Sleeveless Dress");

    public ProductsPage validateProductsList(List<String> headerTableElements) {
        for (String headerElement : headerTableElements) {
            if (!driver.findElement(listOfProducts(headerElement)).isDisplayed()) {
                throw new AssertionError("Header element not displayed: " + headerElement);
            }
        }
        return new ProductsPage(driver);
    }

    public ProductsPage clickOnFirstProduct(){
        driver.findElement(firstProduct).click();
        return new ProductsPage(driver);
    }

    public ProductsPage verifyFirstProductDetails() {
        // Expected Product Details
        Map<String, String> expectedDetails = Map.of(
                "name", "Blue Top",
                "category", "Category: Women > Tops",
                "availability", "Availability: In Stock",
                "condition", "Condition: New",
                "brand", "Brand: Polo"
        );
        // Actual Product Details
        Map<String, String> actualDetails = Map.of(
                "name", driver.findElement(firstProductName).getText(),
                "category", driver.findElement(firstProductCategory).getText(),
                "availability", driver.findElement(firstProductAvailability).getText(),
                "condition", driver.findElement(firstProductCondition).getText(),
                "brand", driver.findElement(firstProductBrand).getText()
        );
        // Assertions
        expectedDetails.forEach((key, expectedValue) ->
                Assert.assertEquals(actualDetails.get(key), expectedValue, "Mismatch in " + key)
        );
        return new ProductsPage(driver);
    }

    public ProductsPage verifyProductImageIsVisible() {
        String expectedAlt = "ecommerce website products"; // Optional if verifying alt text
        String actualAlt = driver.findElement(productImage).getAttribute("alt");

        boolean isImageVisible = driver.findElement(productImage).isDisplayed();
        Assert.assertTrue(isImageVisible, "Product image is not visible.");

        // Optional: Verify alt text if needed
        Assert.assertEquals(actualAlt, expectedAlt, "Image alt text does not match.");

        return new ProductsPage(driver);
    }
}
