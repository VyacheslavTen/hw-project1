package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class TestQRLogin extends BaseTest {
    @Test
    public void testQrLogin() throws InterruptedException {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.qrLogin();
        Thread.sleep(2000);
        Assertions.assertEquals("Получите код для быстрого входа в ОК", loginPage.qrCodeHeader() ,"текст не совпал с ожидаемым");
    }
}
