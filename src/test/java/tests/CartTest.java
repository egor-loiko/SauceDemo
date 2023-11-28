package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test(description = "Product should be added to cart", retryAnalyzer = Retry.class)
    public void addProductsToCart() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToShoppingCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToShoppingCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        assertTrue(cartPage.isBasketContainsProduct("Sauce Labs Bolt T-Shirt"), "Product is not in the basket");
        assertTrue(cartPage.isBasketContainsProduct("Sauce Labs Backpack"), "Product is not in the basket");
        assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99", "Wrong product price");
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99", "Wrong product price");
    }

    @Test(description = "Product should be removed from cart")
    public void removeProductsFromCart() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToShoppingCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToShoppingCart("Sauce Labs Backpack");
        productsPage.addProductToShoppingCart("Sauce Labs Bike Light");
        productsPage.openShoppingCart();
        assertEquals(cartPage.getProductsQuantityInCart(), 3, "Quantity of products in the Shopping Cart is wrong");
        cartPage.removeProductFromShoppingCart("Sauce Labs Bolt T-Shirt");
        cartPage.removeProductFromShoppingCart("Sauce Labs Bike Light");
        assertEquals(cartPage.getProductsQuantityInCart(), 1, "Quantity of products in the Shopping Cart is wrong");
    }
}
