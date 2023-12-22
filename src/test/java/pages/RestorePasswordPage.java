package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RestorePasswordPage extends LoadableComponent {

    public static final By PHONE_LINK = By.xpath("//a[@data-l=\"t,phone\"]");

    public static final By EMAIL_LINK = By.xpath("//a[@data-l=\"t,email\"]");

    public static final By QR_IMAGE = By.xpath("//img[@class=\"qr_code_image\"]");

    public static final By SUPPORT_LINK = By.xpath("//a[@data-l=\"t,support\"]");

    public static final By CLOSE_SUPPORT_APPEAL = By.xpath("//button[@class=\"button-pro __sec\"]");

    public static final By SUPPORT_LOGIN_PASSWORD_BUTTON = By.xpath("//button[contains(text(), 'Нужен логин/пароль')]");

    public static final By SUPPORT_CHAT = By.tagName("support-chat");

    private final WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(PHONE_LINK));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(EMAIL_LINK));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(QR_IMAGE));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(SUPPORT_LINK));
    }

    public RecoveryStartPhoneLink clickPhoneLink() {
        driver.findElement(PHONE_LINK).click();
        return new RecoveryStartPhoneLink(driver);
    }

    public RestorePasswordPage clickSupportLink() {
        driver.findElement(SUPPORT_LINK).click();
        return this;
    }

    public RestorePasswordPage clickSupportLoginPasswordButton() {
        driver.findElement(SUPPORT_LOGIN_PASSWORD_BUTTON).click();
        return this;
    }

    public RestorePasswordPage switchToSupportChat() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        return this;
    }

    public RecoveryStratEmailLink clickEmailLink() {
        driver.findElement(EMAIL_LINK).click();
        return new RecoveryStratEmailLink(driver);
    }

}