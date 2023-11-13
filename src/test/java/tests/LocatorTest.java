package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {

    @Test
    public void findDifferentLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("password"));
        driver.findElement(By.className("submit-button"));
        driver.findElement(By.tagName("form"));
        driver.findElement(By.xpath("//input[@data-test='login-button']"));
        driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
        driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
        driver.findElement(By.xpath("//div[contains(text(),'secret')]"));
        driver.findElement(By.xpath("//*[contains(text(),'secret')]//ancestor::div[@class='login_wrapper']"));
        driver.findElement(By.xpath("//*[contains(text(),'standard')]//descendant::br"));
        driver.findElement(By.xpath("//*[contains(text(),'standard')]//descendant::br//following::br"));
        driver.findElement(By.xpath("//*[contains(text(),'standard')]/parent::div"));
        driver.findElement(By.xpath("//div[@class='login_wrapper']//preceding::div"));
        driver.findElement(By.cssSelector(".login-box"));
        driver.findElement(By.cssSelector(".submit-button.btn_action"));
        driver.findElement(By.cssSelector(".form_column .error-message-container "));
        driver.findElement(By.cssSelector("#user-name"));
        driver.findElement(By.cssSelector("input"));
        driver.findElement(By.cssSelector("input.btn_action"));
        driver.findElement(By.cssSelector("[type=password]"));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt"));
        driver.findElement(By.partialLinkText("Bolt"));
        driver.findElement(By.cssSelector("[alt~='Backpack']"));
        driver.findElement(By.cssSelector("[style|='z']"));
        driver.findElement(By.cssSelector("[data-test^='ad']"));
        driver.findElement(By.cssSelector("[data-test$='backpack']"));
        driver.findElement(By.cssSelector("[id*='4_title']"));
    }
}
