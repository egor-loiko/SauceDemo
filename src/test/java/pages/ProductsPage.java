package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProductsPage extends BasePage {

    private final By PAGE_TITLE_TEXT = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTER = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting Product page Title text")
    public String getPageTitleText() {
        log.info("Getting Product page Title text");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE_TEXT));
        return driver.findElement(PAGE_TITLE_TEXT).getText();
    }

    @Step("Adding product with name '{productName}' to Cart ")
    public void addProductToShoppingCart(String productName) {
        log.info("Adding product with name '{}' to Cart ", productName);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).click();
    }

    @Step("Removing product with name '{productName}' from Cart ")
    public void removeProductFromShoppingCart(String productName) {
        log.info("Removing product with name '{}' from Cart ", productName);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).click();
    }

    @Step("Getting button title for product with name '{productName}'")
    public String getProductButtonTitle(String productName) {
        log.info("Getting button title for product with name '{}'", productName);
        return driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).getText();
    }

    @Step("Navigate to Cart")
    public void openShoppingCart() {
        log.info("Navigate to Cart");
        driver.findElement(SHOPPING_CART_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }
}
