package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class CartPage extends BasePage {

    private final By PRODUCT_TITLE = By.cssSelector(".inventory_item_name");
    private final String PRODUCT_PRICE_TEMPLATE = "//div[text()='%s']//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']";

    private final String REMOVE_PRODUCT_BUTTON_TEMPLATE = "//div[text()='%s']//ancestor::div[@class='cart_item']//button";

    private final By PRODUCT_ITEM = By.cssSelector(".cart_item");
    private final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check is Cart contains product with name '{productName}'")
    public boolean isBasketContainsProduct(String productName) {
        log.info("Checking if Cart contains product with name '{}'", productName);
        List<WebElement> productNamesList = driver.findElements(PRODUCT_TITLE);
        for (WebElement element : productNamesList) {
            if (element.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Step("Removing product with name '{productName}' from Cart")
    public void removeProductFromShoppingCart(String productName) {
        log.info("Removing product with name '{}' from Cart", productName);
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON_TEMPLATE, productName))).click();
    }

    @Step("Getting price of product with name '{productName}'")
    public String getProductPrice(String productName) {
        log.info("Getting price of product with name '{}'", productName);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_TEMPLATE, productName))).getText();
    }

    @Step("Getting quantity of products in Cart")
    public int getProductsQuantityInCart() {
        log.info("Getting quantity of products in Cart");
        return driver.findElements(PRODUCT_ITEM).size();
    }

    @Step("Navigate to Checkout Information page")
    public void goToCheckout() {
        log.info("Navigating to Checkout Information page");
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
