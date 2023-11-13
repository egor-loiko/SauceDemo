package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void buyProduct() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToShoppingCart("Sauce Labs Bolt T-Shirt");
        productsPage.openShoppingCart();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(productName, "Sauce Labs Bike Light", "Wrong product name");
        String productPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        assertEquals(productPrice, "$9.99", "Wrong product price");
    }
}
