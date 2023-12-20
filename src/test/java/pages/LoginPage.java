package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public void openPage() {
        log.info("Opening login page '{}'", BASE_URL);
        driver.get(BASE_URL);
    }

    @Step("Login by '{userName}' with password '{password}'")
    public void login(String userName, String password) {
        log.info("Login by '{}' with password '{}'", userName, password);
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Getting the error message text")
    public String getErrorMessageText() {
        log.info("Getting the error message text");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
