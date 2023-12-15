package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GiftsPage extends LoadableComponent {

    public static final By GIFT_ITEM = By.xpath("//div[@class=\"gifts-catalog-categories_group\"]/div[@class=\"gifts-catalog-category\"]/a[@href=\"/gifts/catalog/mezhdunarodnye-prazdniki\"]");

    public static final By HEADER_TEXT = By.xpath("//h1[@class=\"gifts-catalog-header_title\"]");

    private final WebDriver driver;

    public GiftsPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(GIFT_ITEM));
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(HEADER_TEXT));
    }

    public String returnHeaderText () throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(5)).wait();
        String headerText = driver.findElement(HEADER_TEXT).getText();
        return headerText;
    }

    public void scrollAndClickOnGiftItem() {
        WebElement giftItem = driver.findElement(GIFT_ITEM);
        Actions actions = new Actions(driver);
        actions.moveToElement(giftItem).perform();
        giftItem.click();
    }
}

