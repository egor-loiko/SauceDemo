package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulOrderCreation() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToShoppingCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToShoppingCart("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutInformationPage.enterDeliveryInformation("First_Name", "Last_Name", "ZIP_Code");
        checkoutInformationPage.continueCheckout();
        checkoutOverviewPage.finishCheckout();
        assertEquals(checkoutCompletePage.getSuccessfulOrderCompletedText(), "Thank you for your order!", "Order is not placed");
    }
}
