package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By COMPLETED_ORDER_TEXT = By.cssSelector(".complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessfulOrderCompletedText() {
        return driver.findElement(COMPLETED_ORDER_TEXT).getText();
    }
}
