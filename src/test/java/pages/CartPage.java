package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By PRODUCT_TITLE = By.cssSelector(".inventory_item_name");
    private final String PRODUCT_PRICE_TEMPLATE = "//div[text()='%s']//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']";

    private final String REMOVE_PRODUCT_BUTTON_TEMPLATE = "//div[text()='%s']//ancestor::div[@class='cart_item']//button";

    private final By PRODUCT_ITEM = By.cssSelector(".cart_item");
    private final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBasketContainsProduct(String productName) {
        List<WebElement> productNamesList = driver.findElements(PRODUCT_TITLE);
        for (WebElement element : productNamesList) {
            if (element.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeProductFromShoppingCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON_TEMPLATE, productName))).click();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_TEMPLATE, productName))).getText();
    }

    public int getProductsQuantityInCart() {
        return driver.findElements(PRODUCT_ITEM).size();
    }

    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
