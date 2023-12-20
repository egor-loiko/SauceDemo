package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "user should be logged in")
    public void successfulLogin() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getPageTitleText(), "Products", "User is not logged in or wrong page is not opened");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "secret_sauce1", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(description = "login test using data provider", dataProvider = "loginData")
    public void negativeLogin(String user, String password, String expectedError) {
        loginPage.openPage();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessageText(), expectedError, "Not appropriate or absent validation message");
    }

    @Test(description = "unsuccessful login with empty input")
    public void emptyInputLogin() {
        loginPage.openPage();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required", "Not appropriate or absent validation message");
    }

    @Test(description = "unsuccessful login with empty password")
    public void emptyPasswordLogin() {
        loginPage.openPage();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required", "Not appropriate or absent validation message");
    }

    @Test(description = "unsuccessful login with invalid input")
    public void incorrectPasswordLogin() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce1");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service", "Not appropriate or absent validation message");
    }

    @Test(description = "unsuccessful login for locked user")
    public void lockedUserLogin() {
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.", "Not appropriate or absent validation message");
    }
}
