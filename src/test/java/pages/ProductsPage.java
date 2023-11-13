package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By PAGETITLE_TEXT = By.cssSelector(".title");
    //private final By ADDPRODUCT_BUTTON = By.xpath("//*[text()='Sauce Labs Bike Light']/ancestor::*[@class='inventory_item']//button");
    private final String ADD_TO_CART_PATTER ="//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By SHOPPINGCART_BUTTON = By.cssSelector(".shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitleText() {
        return driver.findElement(PAGETITLE_TEXT).getText();
    }

    public void addProductToShoppingCart(String productName){
        By addToCardButton = By.xpath(String.format(ADD_TO_CART_PATTER, productName));
        driver.findElement(addToCardButton).click();
    }

    public void openShoppingCart(){
        driver.findElement(SHOPPINGCART_BUTTON).click();
    }
}
