package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class TestEmptyLoginFormErrors extends BaseTest {

    @Test
    public void testEmptyLoginFormErrors() {
        openUrl("https://ok.ru");
        Assertions.assertEquals("https://ok.ru/", getDriver().getCurrentUrl(), "адрес не совпал с ожидаемым");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickLoginButtonWithError();

        Assertions.assertEquals("Введите логин", loginPage.getErrorText(), "отобразилась неверная ошибка");
    }
}
