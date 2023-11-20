package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getPageTitleText(), "Products", "User is not logged in or wrong page is not opened");
    }

    @Test
    public void emptyInputLogin() {
        loginPage.openPage();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required", "Not appropriate or absent validation message");
    }

    @Test
    public void emptyPasswordLogin() {
        loginPage.openPage();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required", "Not appropriate or absent validation message");
    }

    @Test
    public void incorrectPasswordLogin() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce1");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service", "Not appropriate or absent validation message");
    }

    @Test
    public void lockedUserLogin() {
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.", "Not appropriate or absent validation message");
    }
}
