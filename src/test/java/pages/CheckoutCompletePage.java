package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutCompletePage extends BasePage {

    private final By COMPLETED_ORDER_TEXT = By.cssSelector(".complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting a successful order completion text")
    public String getSuccessfulOrderCompletedText() {
        log.info("Getting a successful order completion text");
        return driver.findElement(COMPLETED_ORDER_TEXT).getText();
    }
}
