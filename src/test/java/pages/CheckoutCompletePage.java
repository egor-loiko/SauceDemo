package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By COMPLETED_ORDER_TEXT = By.cssSelector(".complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting a successful order completion text")
    public String getSuccessfulOrderCompletedText() {
        return driver.findElement(COMPLETED_ORDER_TEXT).getText();
    }
}
