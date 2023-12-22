package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RecoveryStratEmailLink extends LoadableComponent {

    public static final By MAIL_FIELD = By.xpath("//input[@id=\"field_email\"]");

    public static final By RECEIVE_CODE = By.xpath("//input[@data-l=\"t,submit\"]");

    public static final By ERROR_MESSAGE = By.xpath("//div[@class=\"input-e\"]");

    private final WebDriver driver;

    public RecoveryStratEmailLink(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(MAIL_FIELD));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(RECEIVE_CODE));
    }

    public void clickReceiveCode() {
        driver.findElement(RECEIVE_CODE).click();
    }

    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }


}
