import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User is not logged in or wrong page is not opened");
    }

    @Test
    public void emptyInputLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(title, "Epic sadface: Username is required", "Not appropriate or absent validation message");
    }

    @Test
    public void emptyPasswordLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(title, "Epic sadface: Password is required", "Not appropriate or absent validation message");
    }

    @Test
    public void incorrectPasswordLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(title, "Epic sadface: Username and password do not match any user in this service", "Not appropriate or absent validation message");
    }

    @Test
    public void lockedUserLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(title, "Epic sadface: Sorry, this user has been locked out.", "Not appropriate or absent validation message");
    }
}
