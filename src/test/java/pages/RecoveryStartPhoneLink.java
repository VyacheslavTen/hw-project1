package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RecoveryStartPhoneLink extends LoadableComponent {

    public static final By PHONE_INPUT_RECOVERY = By.xpath("//input[@name=\"st.r.phone\"]");

    public static final By GET_CODE = By.xpath("//input[@data-l=\"t,submit\"]");

    public static final By COUNTRY_LIST = By.xpath("//div[@data-l=\"t,country\"]");

    public static final By COUNTRY_LIST_ITEM = By.xpath("//div[@class=\"country-select_i\"]");

    public static final By SELECTED_CODE = By.xpath("//div[@class=\"country-select_code\"]");




    private final WebDriver driver;

    public RecoveryStartPhoneLink(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(PHONE_INPUT_RECOVERY));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(GET_CODE));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(COUNTRY_LIST));

    }

    public RecoveryStartPhoneLink enterPhoneRecovery (String phoneRecovery) {
        driver.findElement(PHONE_INPUT_RECOVERY).sendKeys("value", phoneRecovery);
        return this;
    }


    public RecoveryPhoneCode getCode() {
        driver.findElement(GET_CODE).click();
        return new RecoveryPhoneCode(driver);
    }

    public String countryListInput() {
        driver.findElement(COUNTRY_LIST).click();
        String dataName = driver.findElements(COUNTRY_LIST_ITEM).get(0).getAttribute("data-name");
        By countryCode = By.xpath("//div[@data-name='"+dataName+"']/div[@class='country-select_code']");
        String code = driver.findElement(countryCode).getText();
        driver.findElements(COUNTRY_LIST_ITEM).get(0).click();
        return code;
    }

    public String countryListwithName(String countryName) {
        driver.findElement(COUNTRY_LIST).click();
        By countryCode = By.xpath("//div[@data-name='" + countryName + "']/div[@class='country-select_code']");
        String codeField = driver.findElement(countryCode).getText();
        driver.findElement(countryCode).click();
        return codeField;
    }

    public String phoneField() {
        String phoneFieldNumber = driver.findElement(PHONE_INPUT_RECOVERY).getAttribute("value");
        return phoneFieldNumber;
    }
}
