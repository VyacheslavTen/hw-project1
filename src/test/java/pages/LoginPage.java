package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


import java.time.Duration;

public class LoginPage extends LoadableComponent {
    private final WebDriver driver;

    public static final By LOGIN_TAB = By.xpath("//a[@data-l='t,login_tab']\n");

    public static final By QR_TAB = By.xpath("//a[@data-l='t,qr_tab']");

    public static final By LOGIN_FIELD_TEXT = By.xpath("//label[@for='field_email']");

    public static final By LOGIN_FIELD = By.xpath("//*[@id=\"field_email\"]");

    public static final By PASSWORD_FIELD_TEXT = By.xpath("//label[@for='field_password']");

    public static final By PASSWORD_FIELD = By.id("field_password");

    public static final By LOGIN_BUTTON = By.xpath("//input[@data-l=\"t,sign_in\"]");

    public static final By QR_BUTTON = By.xpath("//a[@data-l=\"t,get_qr\"]");

    public static final By RESTORE_LINK = By.xpath("//a[@data-l=\"t,restore\"]");

    public static final By NO_PROFILE_TEXT = By.xpath("//div[@class=\"external-oauth-login_title-tx\"]");

    public static final By REGISTER_BUTTON = By.xpath("//div[@class=\"external-oauth-login-footer\"]//a[@data-l=\"t,register\"]");

    public static final By VK_BUTTON = By.xpath("//a[@data-l=\"t,vkc\"]");

    public static final By MAILRU_BUTTON = By.xpath("//a[@data-l=\"t,mailru\"]");

    public static final By GP_BUTTON = By.xpath("//a[@data-l=\"t,google\"]");

    public static final By YANDEX_BUTTON = By.xpath("//a[@data-l=\"t,yandex\"]");

    public static final By APPLE_BUTTON = By.xpath("//a[@data-l=\"t,apple\"]");

    public static final By ERROR_FIELD = By.xpath("//div[@class=\"input-e login_error\"]");

    public static final By WRONG_LOGIN_OR_PASSWORD = By.xpath("//div[@class=\"input-e login_error\"]");

    public static final By WRONG_LOGIN_PAGE = By.xpath("//div[@class=\"stub\"]");

    public static final By RESTORE_BUTTON = By.xpath("//button[@data-l=\"t,restore\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(LOGIN_TAB));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(QR_TAB));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(LOGIN_FIELD_TEXT));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(LOGIN_FIELD));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(PASSWORD_FIELD_TEXT));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(PASSWORD_FIELD));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(LOGIN_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(QR_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(RESTORE_LINK));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(NO_PROFILE_TEXT));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(REGISTER_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(VK_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(MAILRU_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(GP_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(YANDEX_BUTTON));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(APPLE_BUTTON));
    }

    public void clickLoginButtonWithError() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorText(){
        return driver.findElement(ERROR_FIELD).getText();
    }

    public void enterLoginText(String login) {
        driver.findElement(LOGIN_FIELD).sendKeys(login);
    }

    public LoginPage enterPasswordText(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public String wrongLoginPasswordPage(){
        return driver.findElement(WRONG_LOGIN_PAGE).getText();
    }

    public RestorePasswordPage restorePassword() {
        driver.findElement(RESTORE_BUTTON).click();
        return new RestorePasswordPage(driver);
    }
}
