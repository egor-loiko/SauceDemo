package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By PAGE_TITLE_TEXT = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTER = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitleText() {
        return driver.findElement(PAGE_TITLE_TEXT).getText();
    }

    public void addProductToShoppingCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).click();
    }

    public void removeProductFromShoppingCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).click();
    }

    public String getProductButtonTitle(String productName){
        return driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTER, productName))).getText();
    }

    public void openShoppingCart() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }
}
