package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {

    private final By FIRST_NAME_INPUT = By.id("first-name");
    private final By LAST_NAME_INPUT = By.id("last-name");
    private final By ZIP_CODE_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling delivery information '{firstName}', '{lastName}', 'zipCode'")
    public void enterDeliveryInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
    }

    @Step("Navigate to Checkout Overview page")
    public void continueCheckout() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
