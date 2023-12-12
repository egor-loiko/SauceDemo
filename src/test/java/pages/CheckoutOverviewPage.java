package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutOverviewPage extends BasePage {

    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Checkout Complete page")
    public void finishCheckout() {
        log.info("Navigate to Checkout Complete page");
        driver.findElement(FINISH_BUTTON).click();
    }
}
