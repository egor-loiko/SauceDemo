package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(description = "Add Remove button replacement for product")
    public void addRemoveButtonTitleChange() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToShoppingCart("Sauce Labs Bolt T-Shirt");
        assertEquals(productsPage.getProductButtonTitle("Sauce Labs Bolt T-Shirt"), "Remove", "Wrong button name for product item");
        productsPage.removeProductFromShoppingCart("Sauce Labs Bolt T-Shirt");
        assertEquals(productsPage.getProductButtonTitle("Sauce Labs Bolt T-Shirt"), "Add to cart", "Wrong button name for product item");
    }

}
