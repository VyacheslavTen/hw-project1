package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RegistrationPage extends LoadableComponent {

    public static final By CONTINUE_BUTTON = By.xpath("//input[@data-l=\"t,submit\"]");

    public static final By PHONE_ERROR_MESSAGE = By.xpath("//div[@class=\"input-e js-ph-vl-hint\"]");

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(CONTINUE_BUTTON));
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String phoneErrorMessage() {
       return driver.findElement(PHONE_ERROR_MESSAGE).getText();
    }
}
