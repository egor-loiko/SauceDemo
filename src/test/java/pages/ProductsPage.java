package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By PAGE_TITLE_TEXT = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTER = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting Product page Title text")
    public String getPageTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE_TEXT));
        return driver.findElement(PAGE_TITLE_TEXT).getText();
    }

    @Step("Adding product with name '{productName}' to Cart ")
    public void addProductToShoppingCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).click();
    }

    @Step("Removing product with name '{productName}' from Cart ")
    public void removeProductFromShoppingCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).click();
    }

    @Step("Getting button title for product with name '{productName}'")
    public String getProductButtonTitle(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).getText();
    }

    @Step("Navigate to Cart")
    public void openShoppingCart() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }
}
