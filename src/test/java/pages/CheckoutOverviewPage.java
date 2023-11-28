package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Checkout Complete page")
    public void finishCheckout() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
