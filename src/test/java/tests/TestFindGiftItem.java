package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GiftsPage;

public class TestFindGiftItem extends BaseTest {
    @Test
    public void testFindGiftItem() throws InterruptedException {
        openUrl("https://ok.ru/gifts/catalog/all");
        GiftsPage giftsPage = new GiftsPage(getDriver());
        giftsPage.scrollAndClickOnGiftItem();
        Thread.sleep(2000);
        Assertions.assertEquals("Открытки на международные праздники", giftsPage.returnHeaderText() ,"текст не совпал с ожидаемым");
        Assertions.assertEquals("https://ok.ru/gifts/catalog/mezhdunarodnye-prazdniki", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
    }
}
